package com.ubb.bookapp.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "carte")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titlu")
    private String title;

    @Column(name = "autor")
    private String author;

    @Column(name = "gen")
    private String type;

    @Column(name = "disponibila")
    private Boolean isAvailable;

    @Column(name = "numar_carti")
    private Long numberOfBooks;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_abonat", referencedColumnName = "id")
    User user;
}
