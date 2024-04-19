package com.yakupselami.springdatajpaintro.repositories;

import com.yakupselami.springdatajpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
