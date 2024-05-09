package com.ubb.bookapp.service;

import com.ubb.bookapp.dao.dto.TerminalDto;
import com.ubb.bookapp.dao.mappers.TerminalMapper;
import com.ubb.bookapp.dao.model.Terminal;
import com.ubb.bookapp.dao.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;

    public List<TerminalDto> getAllTerminals() {
        List<Terminal> terminals = (List<Terminal>) this.terminalRepository.findAll();
        return TerminalMapper.mapToDtoList(terminals);
    }
}
