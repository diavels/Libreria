package com.propio.literalura.model;

import com.propio.literalura.DTO.DatosLibro;
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

    public Libro(){}

    public static Libro convertirDesdeDatos(DatosLibro datosLibro, Autor autor) {
        Libro libro = new Libro();
    libro.setTitulo(datosLibro.titulo());
    libro.setIdioma(String.valueOf(datosLibro.idioma()));
    libro.setDescargas(datosLibro.descargas());
    libro.setAutor(autor);  // El autor debe buscarse o crearse antes
    return libro;
    );
    }


    @Override
    public String toString() {
        return "************" + "Libro" + "***********" + "\n" +
                "Titulo='" + titulo + '\n' +
                "Autor='" + autor.getNombre()+ '\n' +
                "Idioma='" + idioma + '\n' +
                "Descargas=" + descargas + "\n" +
        "**************************************";
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
