package com.manager.project.service;

import com.manager.project.model.BookDTO;

import java.util.List;

public interface BookService  {
    BookDTO getBookById(long id);
    List<BookDTO> getAllBooks();
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(long id , BookDTO bookDTO);
    void deleteBook(long id);

}
