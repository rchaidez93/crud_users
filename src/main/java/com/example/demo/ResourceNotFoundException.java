package com.example.demo;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String id){
        super("Could not find user with id " + id);
    }
}
