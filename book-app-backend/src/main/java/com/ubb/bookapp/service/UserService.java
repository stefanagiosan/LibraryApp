package com.ubb.bookapp.service;

import com.ubb.bookapp.dao.dto.LoginDto;
import com.ubb.bookapp.dao.dto.UserDto;
import com.ubb.bookapp.dao.mappers.UserMapper;
import com.ubb.bookapp.dao.model.Book;
import com.ubb.bookapp.dao.model.User;
import com.ubb.bookapp.dao.repository.BookRepository;
import com.ubb.bookapp.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserDto loginUser(LoginDto loginDto) {
        User user = this.userRepository.findByNameAndPassword(loginDto.name(), loginDto.password())
                .orElseThrow();
        return UserMapper.mapToDto(user);
    }

    public UserDto registerUser(UserDto user) {
        User userModel = UserMapper.mapToModel(user);
        userModel.setBooks(new ArrayList<>());
        userModel.setType("ABONAT");
        User userCreated = this.userRepository.save(userModel);
        return UserMapper.mapToDto(userCreated);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) this.userRepository.findAll();
        return UserMapper.mapToDtoList(users);
    }

    public UserDto returnBook(Long userId, Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow();
        User user = this.userRepository.findById(userId).orElseThrow();

        book.setNumberOfBooks(book.getNumberOfBooks() + 1);

        List<Book> books = user.getBooks();
        books.remove(book);

        user.setBooks(books);
        book.setUser(null);
        book.setIsAvailable(true);
        this.bookRepository.save(book);

        return UserMapper.mapToDto(this.userRepository.save(user));
    }

    public UserDto borrowBook(Long userId, Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow();
        User user = this.userRepository.findById(userId).orElseThrow();

        book.setNumberOfBooks(book.getNumberOfBooks() - 1);

        List<Book> books = user.getBooks();
        books.add(book);

        user.setBooks(books);
        book.setIsAvailable(false);
        book.setUser(user);
        this.bookRepository.save(book);

        return UserMapper.mapToDto(this.userRepository.save(user));
    }
}
