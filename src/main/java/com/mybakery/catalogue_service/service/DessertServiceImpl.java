package com.mybakery.catalogue_service.service;

import com.mybakery.catalogue_service.domain.Dessert;
import com.mybakery.catalogue_service.exception.ItemNotFoundException;
import com.mybakery.catalogue_service.repository.DessertRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DessertServiceImpl implements DessertService {

    private final DessertRepository dessertRepository;

    public DessertServiceImpl(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    /**
     * Retrieves a paginated list of desserts.
     *
     * @param pageable the pagination information, such as page number and size.
     * @return a paginated list of desserts.
     */
    public Page<Dessert> getAllDesserts(Pageable pageable) {
        return dessertRepository.findAll(pageable);
    }

    /**
     * Retrieves a specific dessert by ID.
     *
     * @param id the ID of the dessert.
     * @return the dessert if found, or null otherwise.
     */
    public Dessert getDessertById(Long id) {
        return dessertRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item with id "+ id + " not found."));
    }

    /**
     * Adds a new dessert to the database.
     *
     * @param dessert the dessert to be added.
     * @return the saved dessert.
     */
    public Dessert addDessert(Dessert dessert) {
        return dessertRepository.save(dessert);
    }

    /**
     * Updates an existing dessert.
     *
     * @param id the ID of the dessert to update.
     * @param updatedDessert the updated dessert object.
     * @return the updated dessert if found and updated, or null otherwise.
     */
    public Dessert updateDessert(Long id, Dessert updatedDessert) {
        return dessertRepository.findById(id).map(dessert -> {
            dessert.setName(updatedDessert.getName());
            dessert.setCategory(updatedDessert.getCategory());
            dessert.setPrice(updatedDessert.getPrice());
            dessert.setImageThumbnail(updatedDessert.getImageThumbnail());
            dessert.setImageMobile(updatedDessert.getImageMobile());
            dessert.setImageTablet(updatedDessert.getImageTablet());
            dessert.setImageDesktop(updatedDessert.getImageDesktop());
            return dessertRepository.save(dessert);
        }).orElseThrow(() -> new ItemNotFoundException("Item with id "+ id + " not found."));
    }

    /**
     * Deletes a dessert by ID.
     *
     * @param id the ID of the dessert to delete.
     * @return true if deleted successfully, false otherwise.
     */
    public boolean deleteDessert(Long id) {
        if (dessertRepository.existsById(id)) {
            dessertRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * List all category of desserts
     */

    @Override
    public List<String> findDistinctCategories() {
        return dessertRepository.findDistinctCategories();
    }
}
