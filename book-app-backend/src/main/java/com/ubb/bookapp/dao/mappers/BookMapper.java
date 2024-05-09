package com.ubb.bookapp.dao.mappers;

import com.ubb.bookapp.dao.dto.BookDto;
import com.ubb.bookapp.dao.model.Book;

import java.util.List;

public class BookMapper {
    public static BookDto mapToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .type(book.getType())
                .isAvailable(book.getIsAvailable())
                .numberOfBooks(book.getNumberOfBooks())
                .image(book.getImage())
                .build();
    }

    public static Book mapToModel(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.id())
                .title(bookDto.title())
                .author(bookDto.author())
                .type(bookDto.type())
                .isAvailable(bookDto.isAvailable())
                .numberOfBooks(bookDto.numberOfBooks())
                .image(bookDto.image())
                .build();
    }

    public static List<BookDto> mapToDtoList(List<Book> books) {
        return books.stream()
                .map(BookMapper::mapToDto)
                .toList();
    }
}
