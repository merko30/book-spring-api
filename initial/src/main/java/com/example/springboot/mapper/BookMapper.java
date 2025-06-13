package com.example.springboot.mapper;

import com.example.springboot.dto.CreateBookDto;
import com.example.springboot.dto.UpdateBookDto;
import com.example.springboot.entity.Book;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    Book toEntity(CreateBookDto dto);

    void updateBookFromDto(CreateBookDto dto, @MappingTarget Book book);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDto(UpdateBookDto dto, @MappingTarget Book book);
}