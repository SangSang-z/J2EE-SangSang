package com.example.bai2.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.bai2.model.Book;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>(List.of(
            new Book(1, "Java nâng cao", "Nguyễn Văn An"),
            new Book(2, "Spring Boot thực chiến", "Trần Thị Bình"),
            new Book(3, "Microservices căn bản", "Lê Văn Cường")
    ));

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean updateBook(int id, Book newInfo) {
        Book old = getBookById(id);
        if (old == null) return false;

        old.setTitle(newInfo.getTitle());
        old.setAuthor(newInfo.getAuthor());
        return true;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(b -> b.getId() == id);
    }
}
