package com.onlinebookstore.bookservice.dto;

import lombok.Data;

@Data
public class UpdateBookDTO {
    private String title;
    private String author;
    private String isbn;
    private int publishedYear;

}