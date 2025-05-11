package com.manager.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manager.project.entity.Book;

public record BookDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY)
                      Long id,
                      String title,
                      String genre,
                      int yearPublished,
                      AuthorDTO author) {
}
