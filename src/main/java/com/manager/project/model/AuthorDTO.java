package com.manager.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manager.project.exception.InvalidInputException;


public record AuthorDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                          String name,
                          String lastName,
                          Integer age ){

    @Override
    public Integer age() {
        if(age < 0 ){
            throw new InvalidInputException("Age must be a positive integer");
        }
        return age;
    }
}

