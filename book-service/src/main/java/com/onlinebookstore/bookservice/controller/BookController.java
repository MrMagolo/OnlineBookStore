package com.onlinebookstore.bookservice.controller;

import com.onlinebookstore.bookservice.dto.BookDTO;
import com.onlinebookstore.bookservice.dto.CreateBookDTO;
import com.onlinebookstore.bookservice.dto.UpdateBookDTO;
import com.onlinebookstore.bookservice.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ApiOperation(value = "Add Book")
    public BookDTO addBook(@RequestBody CreateBookDTO createBookDTO) {
        return bookService.addBook(createBookDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Retrieve Book")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody UpdateBookDTO updateBookDTO) {
        return bookService.updateBook(id, updateBookDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Book")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieve Book details by ID")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    @ApiOperation(value = "Get All Books")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }
}

