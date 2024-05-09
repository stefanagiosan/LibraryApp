package com.ubb.bookapp.service;

import com.ubb.bookapp.dao.dto.BookDto;
import com.ubb.bookapp.dao.mappers.BookMapper;
import com.ubb.bookapp.dao.model.Book;
import com.ubb.bookapp.dao.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        List<Book> books = (List<Book>) this.bookRepository.findAll();
        return BookMapper.mapToDtoList(books);
    }
}
