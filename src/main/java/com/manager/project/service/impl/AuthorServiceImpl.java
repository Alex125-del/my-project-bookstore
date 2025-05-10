package com.manager.project.service.impl;


import com.manager.project.model.AuthorDTO;
import com.manager.project.entity.Author;

import com.manager.project.repository.AuthorRepository;
import com.manager.project.service.AuthorService;
import com.manager.project.util.ModelConvertor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl  implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorDTO getAuthorById(long id) {
        Author foundAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return ModelConvertor.convertAuthorToDTO(foundAuthor);

    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> allAuthors = authorRepository.findAll();
        return allAuthors
                .stream()
                .map(ModelConvertor::convertAuthorToDTO)
                .toList();
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = ModelConvertor.convertToAuthor(authorDTO);
        Author createAuthor = authorRepository.save(author);
        return ModelConvertor.convertAuthorToDTO(createAuthor);
    }

    @Override
    public AuthorDTO updateAuthor(long id, AuthorDTO authorDTO) {
        Author author = ModelConvertor.convertToAuthor(authorDTO);
        author.setId(id);
        Author updateAuthor = authorRepository.save(author);
        return ModelConvertor.convertAuthorToDTO(updateAuthor);

    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }
}
