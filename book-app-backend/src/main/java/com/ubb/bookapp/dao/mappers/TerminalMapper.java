package com.ubb.bookapp.dao.mappers;

import com.ubb.bookapp.dao.dto.TerminalDto;
import com.ubb.bookapp.dao.model.Terminal;

import java.util.List;

public class TerminalMapper {
    public static TerminalDto mapToDto(Terminal terminal) {
        return TerminalDto.builder()
                .id(terminal.getId())
                .locatie(terminal.getLocatie())
                .build();
    }

    public static Terminal mapToModel(TerminalDto terminal) {
        return Terminal.builder()
                .id(terminal.id())
                .locatie(terminal.locatie())
                .build();
    }

    public static List<TerminalDto> mapToDtoList(List<Terminal> terminals) {
        return terminals.stream()
                .map(TerminalMapper::mapToDto)
                .toList();
    }
}
