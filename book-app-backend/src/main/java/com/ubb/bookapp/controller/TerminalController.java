package com.ubb.bookapp.controller;

import com.ubb.bookapp.dao.dto.TerminalDto;
import com.ubb.bookapp.service.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/terminals")
@RequiredArgsConstructor
public class TerminalController {

    private final TerminalService terminalService;

    @GetMapping()
    public List<TerminalDto> getAllTerminals() {
        return this.terminalService.getAllTerminals();
    }

}
