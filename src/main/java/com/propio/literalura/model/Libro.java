package com.propio.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Long id;
    private String titulo;
    private String idioma;
    private Double descargas;
    @ManyToOne
    private Autor autor;


    public Libro(Libro libro){
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.idioma = libro.idioma;
        this.descargas = libro.descargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", descargas=" + descargas +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getDescargas() {
        return descargas;
    }

    public void setDescargas(Double descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
