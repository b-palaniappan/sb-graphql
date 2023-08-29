package io.c12.bala.api.controller;

import io.c12.bala.db.entity.Author;
import io.c12.bala.db.entity.Book;
import io.c12.bala.db.repository.AuthorRepository;
import io.c12.bala.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @QueryMapping(name = "authors")
    Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @QueryMapping(name = "authorById")
    Optional<Author> getAuthorById(@Argument Long id) {
        return authorRepository.findById(id);
    }

    @MutationMapping(name = "addBook")
    Book addBook(@Argument BookInput book) {
        log.info(" ----> Book Input - {}", book);
        Author author = this.authorRepository.findById(book.authorId()).orElseThrow(() -> new IllegalArgumentException("author not found"));
        log.info(" ----> Author - {}", author.getName());
        Book b = new Book(null, book.title(), book.publisher(), author);
        log.info(" ----> Book - {} | {} | {}", b.getId(), b.getTitle(), b.getPublisher());
        return this.bookRepository.save(b);
    }

    record BookInput(String title, String publisher, Long authorId) {}
}
