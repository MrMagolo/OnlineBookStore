package com.onlinebookstore.bookservice.service;


import com.onlinebookstore.bookservice.dto.BookDTO;
import com.onlinebookstore.bookservice.dto.CreateBookDTO;
import com.onlinebookstore.bookservice.dto.UpdateBookDTO;
import com.onlinebookstore.bookservice.model.Book;
import com.onlinebookstore.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO addBook(CreateBookDTO createBookDTO) {
        Book book = new Book();
        book.setTitle(createBookDTO.getTitle());
        book.setAuthor(createBookDTO.getAuthor());
        book.setIsbn(createBookDTO.getIsbn());
        book.setPublishedYear(createBookDTO.getPublishedYear());
        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    public BookDTO updateBook(Long id, UpdateBookDTO updateBookDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            Book book = new Book();
            book.setTitle("The book was not Found");
            book.setAuthor("N/A");
            book.setIsbn("N/A");
            book.setPublishedYear(Integer.parseInt("N/A"));



            return convertToDTO(book);
        }
        Book book = optionalBook.get();
        book.setTitle(updateBookDTO.getTitle());
        book.setAuthor(updateBookDTO.getAuthor());
        book.setIsbn(updateBookDTO.getIsbn());
        book.setPublishedYear(updateBookDTO.getPublishedYear());
        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(this::convertToDTO).orElse(null);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setPublishedYear(book.getPublishedYear());
        return bookDTO;
    }
}
