package com.mybakery.catalogue_service.repository;

import com.mybakery.catalogue_service.domain.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DessertRepository extends JpaRepository<Dessert, Long> {

    @Query("SELECT DISTINCT d.category FROM Dessert d")
    List<String> findDistinctCategories();

}