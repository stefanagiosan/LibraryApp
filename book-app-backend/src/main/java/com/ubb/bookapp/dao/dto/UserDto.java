package com.ubb.bookapp.dao.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record UserDto (
        Long id,
        String cnp,
        String name,
        String password,
        String address,
        String phone,
        String type,
        List<BookDto> books
) {
}
