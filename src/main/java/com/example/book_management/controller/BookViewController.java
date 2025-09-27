package com.example.book_management.controller;

import com.example.book_management.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookViewController {

    private final BookService bookService;

    public BookViewController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list") // URL for browser UI
    public String getBooksPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books"; // Thymeleaf template: books.html
    }
}
