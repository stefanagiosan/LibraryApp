package com.ubb.bookapp.controller;

import com.ubb.bookapp.dao.dto.LoginDto;
import com.ubb.bookapp.dao.dto.UserDto;
import com.ubb.bookapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    List<UserDto> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping("/login")
    UserDto loginUser(@RequestBody LoginDto loginDto) {
        return this.userService.loginUser(loginDto);
    }

    @PostMapping("/register")
    UserDto registerUser(@RequestBody UserDto userDto) {
        return this.userService.registerUser(userDto);
    }

    @PutMapping("{userId}/return/{bookId}")
    UserDto returnBook(@PathVariable Long userId, @PathVariable Long bookId) {
        return this.userService.returnBook(userId, bookId);
    }

    @PutMapping("{userId}/borrow/{bookId}")
    UserDto borrowBook(@PathVariable Long userId, @PathVariable Long bookId) {
        return this.userService.borrowBook(userId, bookId);
    }
}
