package com.propio.literalura.Model;

import jakarta.persistence.criteria.CriteriaBuilder;

public class Libro {
    private String titulo;
    private String autor;
    private Integer añoNacimiento;
    private Integer añoFallecimiento;
    private String idioma;
    private Integer numeroDescargas;

    @Override
    public String toString() {
        return "titulo" + titulo + "/" +
                "autor" + autor + "/" +
                "idioma" + idioma + "/" +
                "numero de Descargas: " + numeroDescargas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(Integer añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public Integer getAñoFallecimiento() {
        return añoFallecimiento;
    }

    public void setAñoFallecimiento(Integer añoFallecimiento) {
        this.añoFallecimiento = añoFallecimiento;
    }

    public String getLenguaje() {
        return idioma;
    }

    public void setLenguaje(String lenguaje) {
        this.idioma = lenguaje;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }


}
