package com.manager.project.controller;

import com.manager.project.model.BookDTO;
import com.manager.project.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Books", description = "APIs for managing books and authors")
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(
            summary = "Find book by ID",
            description = "Returns the details of the book with the given ID. If the book does not exist, an error is returned."
    )
    @GetMapping("/{id}")
    public BookDTO findBook(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @Operation(
            summary = "Find all books",
            description = "Returns a list of all books available in the system."
    )
    @GetMapping
    public List<BookDTO> findAllBooks() {
        return bookService.getAllBooks();
    }

    @Operation(
            summary = "Create a new book",
            description = "Creates a new book using the data provided in the request body and returns the created BookDTO."
    )
    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @Operation(
            summary = "Update an existing book",
            description = "Updates the book with the specified ID using the data provided in the request body. Returns the updated BookDTO."
    )
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable long id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @Operation(
            summary = "Delete a book by ID",
            description = "Deletes the book with the specified ID from the system. No content is returned if the deletion is successful."
    )
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }
}


