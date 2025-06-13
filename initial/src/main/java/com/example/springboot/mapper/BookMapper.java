package com.example.springboot.mapper;

import com.example.springboot.dto.CreateBookDto;
import com.example.springboot.entity.Book;

public class BookMapper {
    public static Book toEntity(CreateBookDto dto) {
        Book book = new Book(
            dto.getTitle(),
            dto.getAuthor()
        );
        return book;
    }
}