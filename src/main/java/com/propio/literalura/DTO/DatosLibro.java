package com.propio.literalura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title")  String titulo,
        @JsonAlias("authors") List<Autor> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Double descargas
) {

    @Override
    public String toString() {
        return "************  " + "Libro" + "  ************" + "\n" +
                "Titulo= " + titulo + '\n' +
                "Autor= " + autor.get(0).nombre()+ '\n' +
                "Idioma= " + idioma + '\n' +
                "Descargas= " + descargas + "\n" +
                "*********************************";
    }
}
