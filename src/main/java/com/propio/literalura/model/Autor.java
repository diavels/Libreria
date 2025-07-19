package com.propio.literalura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String fechaDeNacimiento;
    private String fechaDeFallecimiento;
    @OneToMany(mappedBy = "Autor", cascade = CascadeType.ALL)
    List<Libro> libros;

}
