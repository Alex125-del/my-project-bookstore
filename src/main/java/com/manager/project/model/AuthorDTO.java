package com.manager.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record AuthorDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                          String name,
                          String lastName,
                          Integer age ){

}

