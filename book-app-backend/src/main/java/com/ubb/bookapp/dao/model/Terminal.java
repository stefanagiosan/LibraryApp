package com.ubb.bookapp.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "terminal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Terminal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "locatie")
    private String locatie;

}
