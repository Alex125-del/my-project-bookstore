package com.manager.project.util;

import com.manager.project.entity.Book;
import com.manager.project.model.AuthorDTO;
import com.manager.project.model.BookDTO;
import com.manager.project.entity.Author;




public class ModelConvertor {

    public static Author convertToAuthor(AuthorDTO dto) {
        if (dto.id() != null) {
            return new Author(dto.id(), dto.name(), dto.lastName(), dto.age());
        } else {
            return new Author(dto.name(), dto.lastName(), dto.age());
        }
    }

    public static AuthorDTO convertAuthorToDTO(Author author) {
        return new AuthorDTO(author.getId(), author.getName(), author.getLastName(), author.getAge());
    }
    public static Book convertToBook(BookDTO dto) {
       if (dto == null) {
           return null;
       }
        if (dto.id() != null) {
            return new Book(dto.id(), dto.title(), dto.genre(), dto.yearPublished(), convertToAuthor(dto.author()));
        } else {
            return new Book(dto.title(), dto.genre(), dto.yearPublished(),convertToAuthor (dto.author()));
        }
    }

    public static BookDTO convertBookToDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getGenre(), book.getYearPublished(),convertAuthorToDTO(book.getAuthor()));
    }
}

