package com.manager.project.controller;


import com.manager.project.model.AuthorDTO;
import com.manager.project.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Authors", description = "APIs for managing books, author ")

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @Operation(
            summary = "Find author by ID",
            description = "Returns the details of the author with the given ID. If the author does not exist, an error is returned.")
    @GetMapping("/{id}")
    public AuthorDTO findAuthor(@PathVariable long id) {
        return authorService.getAuthorById(id);
    }
    @Operation(
            summary = "Find all authors by ID",
            description = "Retrieve an author based on the provided ID. Returns the author data as AuthorDTO."
    )
    @GetMapping
    public List<AuthorDTO> findAllAuthors() {
        return authorService.getAllAuthors();
    }

    @Operation(
            summary = "Create a new author",
            description = "Creates a new author using the data provided in the request body and returns the created AuthorDTO."
    )
    @PostMapping
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }
    @Operation(
            summary = "Update an existing author",
            description = "Updates the author with the specified ID using the data provided in the request body. Returns the updated AuthorDTO."
    )
    @PutMapping("{id}")
    public AuthorDTO updateAuthor(@PathVariable long id, @RequestBody AuthorDTO employeeDTO) {
        return authorService.updateAuthor(id, employeeDTO);
    }
    @Operation(
            summary = "Delete an author by ID",
            description = "Deletes the author with the specified ID from the system. No content is returned if the deletion is successful."
    )
    @DeleteMapping("{id}")

    public void deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);
    }
}