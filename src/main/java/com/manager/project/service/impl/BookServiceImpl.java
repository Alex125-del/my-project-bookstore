package com.manager.project.service.impl;

import com.manager.project.entity.Author;
import com.manager.project.model.BookDTO;
import com.manager.project.entity.Book;
import com.manager.project.repository.AuthorRepository;
import com.manager.project.repository.BookRepository;
import com.manager.project.service.BookService;
import com.manager.project.util.ModelConvertor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDTO getBookById(long id) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return ModelConvertor.convertBookToDTO(foundBook);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return allBooks
                .stream()
                .map(ModelConvertor::convertBookToDTO)
                .toList();
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = ModelConvertor.convertToBook(bookDTO);

//
        Author author = authorRepository.findByName(bookDTO.author().name())
               .orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);

        Book createBook = bookRepository.save(book);
        return ModelConvertor.convertBookToDTO(createBook);

    }

    @Override
    public BookDTO updateBook(long id, BookDTO bookDTO) {
        Book book = ModelConvertor.convertToBook(bookDTO);
        book.setId(id);
        Book updateBook = bookRepository.save(book);
        return ModelConvertor.convertBookToDTO(updateBook);

    }

    @Override
    public void  deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}








