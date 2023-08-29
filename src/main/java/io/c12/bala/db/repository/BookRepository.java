package io.c12.bala.db.repository;

import io.c12.bala.db.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
