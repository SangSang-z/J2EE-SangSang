package com.example.bai2.controller;

import java.util.List;

import com.example.bai2.model.Book;
import com.example.bai2.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. Lấy danh sách tất cả sách
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 2. Lấy thông tin sách theo ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // 3. Thêm sách mới
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully!";
    }

    // 4. Cập nhật thông tin sách
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        boolean ok = bookService.updateBook(id, updatedBook);
        return ok ? "Book updated successfully!" : "Book not found!";
    }

    // 5. Xóa sách theo ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean ok = bookService.deleteBook(id);
        return ok ? "Book deleted successfully!" : "Book not found!";
    }
}
