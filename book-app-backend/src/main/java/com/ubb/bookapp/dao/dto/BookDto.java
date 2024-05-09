package com.ubb.bookapp.dao.dto;

import lombok.Builder;

@Builder
public record BookDto(
        Long id,
        String title,
        String author,
        String type,
        Boolean isAvailable,
        Long numberOfBooks,
        String image
) {
}
