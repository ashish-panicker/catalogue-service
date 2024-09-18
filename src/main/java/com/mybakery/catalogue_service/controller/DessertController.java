package com.mybakery.catalogue_service.controller;

import com.mybakery.catalogue_service.domain.Dessert;
import com.mybakery.catalogue_service.exception.ItemNotFoundException;
import com.mybakery.catalogue_service.response.CategoriesResponse;
import com.mybakery.catalogue_service.service.DessertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/" +
                "")
public class DessertController {

    private final DessertService dessertService;

    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    /**
     * Retreives all distinct categories of desserts with HATEOS links.
     */

    @GetMapping("/categories")
    public ResponseEntity<CategoriesResponse> getDistinctCategories() {
        List<String> categories = dessertService.findDistinctCategories();
        CategoriesResponse response = new CategoriesResponse(categories);

        // Add self link
        response.add(linkTo(methodOn(DessertController.class).getDistinctCategories()).withSelfRel());

        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves all desserts with pagination, adding HATEOAS links.
     *
     * @param page the page number to retrieve (default: 0)
     * @param size the page size (default: 10)
     * @return a paginated list of desserts with HATEOAS links
     */
    @GetMapping
    public PagedModel<EntityModel<Dessert>> getAllDesserts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {

        Page<Dessert> dessertPage = dessertService.getAllDesserts(PageRequest.of(page, size));

        List<EntityModel<Dessert>> desserts = dessertPage.stream()
            .map(dessert -> EntityModel.of(dessert,
                linkTo(methodOn(DessertController.class).getDessertById(dessert.getId())).withSelfRel(),
                linkTo(methodOn(DessertController.class).getAllDesserts(page, size)).withRel("desserts")))
            .toList();

        return PagedModel.of(desserts,
            new PagedModel.PageMetadata(size, page, dessertPage.getTotalElements()),
            linkTo(methodOn(DessertController.class).getAllDesserts(page, size)).withSelfRel());
    }

    /**
     * Retrieves a specific dessert by ID, adding HATEOAS links.
     *
     * @param id the ID of the dessert to retrieve
     * @return the dessert with HATEOAS links
     */
    @GetMapping("/{id}")
    public EntityModel<Dessert> getDessertById(@PathVariable Long id) {
        Dessert dessert = dessertService.getDessertById(id);
        return EntityModel.of(dessert,
            linkTo(methodOn(DessertController.class).getDessertById(id)).withSelfRel(),
            linkTo(methodOn(DessertController.class).getAllDesserts(0, 10)).withRel("desserts"));
    }

    /**
     * Adds a new dessert and returns it with HATEOAS links.
     *
     * @param dessert the dessert to add
     * @return the added dessert with HATEOAS links
     */
    @PostMapping
    public EntityModel<Dessert> addDessert(@RequestBody Dessert dessert) {
        Dessert newDessert = dessertService.addDessert(dessert);
        return EntityModel.of(newDessert,
            linkTo(methodOn(DessertController.class).getDessertById(newDessert.getId())).withSelfRel(),
            linkTo(methodOn(DessertController.class).getAllDesserts(0, 10)).withRel("desserts"));
    }

    /**
     * Updates an existing dessert and returns it with HATEOAS links.
     *
     * @param id      the ID of the dessert to update
     * @param dessert the updated dessert
     * @return the updated dessert with HATEOAS links
     */
    @PutMapping("/{id}")
    public EntityModel<Dessert> updateDessert(@PathVariable Long id, @RequestBody Dessert dessert) {
        Dessert updatedDessert = dessertService.updateDessert(id, dessert);
        return EntityModel.of(updatedDessert,
            linkTo(methodOn(DessertController.class).getDessertById(id)).withSelfRel(),
            linkTo(methodOn(DessertController.class).getAllDesserts(0, 10)).withRel("desserts"));
    }

    /**
     * Deletes a dessert by ID.
     *
     * @param id the ID of the dessert to delete
     * @return a message confirming deletion
     */
    @DeleteMapping("/{id}")
    public EntityModel<String> deleteDessert(@PathVariable Long id) {
        boolean isDeleted = dessertService.deleteDessert(id);
        String message = isDeleted ? "Dessert deleted successfully" : "Dessert not found";
        return EntityModel.of(message,
            linkTo(methodOn(DessertController.class).getAllDesserts(0, 10)).withRel("desserts"));
    }

    @ExceptionHandler({ItemNotFoundException.class})
    public ResponseEntity<Object> handleItemNotFound(ItemNotFoundException e) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}