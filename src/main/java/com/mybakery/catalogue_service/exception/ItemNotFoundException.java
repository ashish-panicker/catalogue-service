package com.mybakery.catalogue_service.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String message){
        super(message);
    }
}