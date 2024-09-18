package com.mybakery.catalogue_service.response;

import org.springframework.hateoas.CollectionModel;

import java.util.List;

public class CategoriesResponse extends CollectionModel<String> {

    private List<String> categories;

    public CategoriesResponse(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}