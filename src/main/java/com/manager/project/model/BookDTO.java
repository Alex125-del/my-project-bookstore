package com.manager.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY)
                      Long id,
                      String title,
                      String genre,
                      int yearPublished,
                      AuthorDTO author) {
}
