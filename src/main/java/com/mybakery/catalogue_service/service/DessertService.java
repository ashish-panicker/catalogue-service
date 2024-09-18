package com.mybakery.catalogue_service.service;

import com.mybakery.catalogue_service.domain.Dessert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DessertService {

    Page<Dessert> getAllDesserts(Pageable pageable);

    Dessert getDessertById(Long id);

    Dessert addDessert(Dessert dessert);

    Dessert updateDessert(Long id, Dessert updatedDessert);

    boolean deleteDessert(Long id);

    List<String> findDistinctCategories();
}