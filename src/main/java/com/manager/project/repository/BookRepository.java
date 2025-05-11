package com.manager.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.project.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

}
