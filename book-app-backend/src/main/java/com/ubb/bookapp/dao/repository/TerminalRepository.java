package com.ubb.bookapp.dao.repository;

import com.ubb.bookapp.dao.model.Terminal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends CrudRepository<Terminal, Long> {
}
