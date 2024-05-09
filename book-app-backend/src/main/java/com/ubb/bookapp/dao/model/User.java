package com.ubb.bookapp.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "abonat")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnp")
    private String cnp;

    @Column(name = "nume")
    private String name;

    @Column(name = "parola")
    private String password;

    @Column(name = "adresa")
    private String address;

    @Column(name = "telefon")
    private String phone;

    @Column(name = "tip")
    private String type;

    @OneToMany(mappedBy = "user")
    List<Book> books;

}
