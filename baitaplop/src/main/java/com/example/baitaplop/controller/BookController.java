package com.example.baitaplop.controller;

import com.example.baitaplop.model.Book;
import com.example.baitaplop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Hiển thị danh sách sách
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // Hiển thị form thêm sách
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("bosok", new Book());
        return "add";
    }

    // Thêm sách mới
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // Hiển thị form sửa sách
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        bookService.getBookById(id).ifPresent(book -> model.addAttribute("book", book));
        return "edit";
    }

    // Cập nhật sách
    @PostMapping("/edit")
    public String updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/books";
    }

    // Xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
