package com.manager.project.service;

import com.manager.project.model.AuthorDTO;

import java.util.List;

public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO authorDTO);

    AuthorDTO getAuthorById(long id);

    List<AuthorDTO> getAllAuthors();

    AuthorDTO updateAuthor(long id , AuthorDTO authorDTO);

    void deleteAuthor(long id);

}
