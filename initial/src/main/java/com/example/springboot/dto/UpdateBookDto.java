package com.example.springboot.dto;

import com.example.springboot.validation.NotBlankIfPresent;

public class UpdateBookDto {

    @NotBlankIfPresent(message = "Title cannot be blank if present")
    private String title;
    @NotBlankIfPresent(message = "Author cannot be blank if present")
    private String author;

    public UpdateBookDto() {}

    public UpdateBookDto(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
