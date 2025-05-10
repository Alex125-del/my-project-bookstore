package com.manager.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.project.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
