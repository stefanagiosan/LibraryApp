package com.ubb.bookapp.dao.dto;

import lombok.Builder;

@Builder
public record TerminalDto (
        Long id,
        String locatie
) {}
