package com.propio.literalura.Service;

import com.propio.literalura.Principal.principal;
import com.propio.literalura.Repository.LibroRepository;
import com.propio.literalura.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class LibroPorIdioma {
    Scanner teclado = new Scanner(System.in);
    @Autowired
    private final LibroRepository libroRepositorio;

    public LibroPorIdioma(LibroRepository libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    public principal mostrarMenuIdioma() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("""
                    ***************************
                         Menu de Idiomas
                    
                    1 - Ingles(EN)
                    2 - Español(ES)
                    3 - Frances(fr)
                    
                    0 - Volver
                    """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    librosIngles();
                    break;
                case 2:
                    librosEspañol();
                    break;
                case 3:
                    librosFrances();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalidad");
                    break;
            }
        }
        return null;
    }

    private void librosIngles() {
        var opcion = "[en]";
        List<Libro> filtroIngles = libroRepositorio.findByLanguages(opcion);
        System.out.println(filtroIngles);

    }

    private void librosEspañol() {
        var opcion = "[es]";
        List<Libro> filtroEspañol = libroRepositorio.findByLanguages(opcion);
        System.out.println(filtroEspañol);
    }

    private void librosFrances() {
        var opcion = "[fr]";
        List<Libro> filtroFrances = libroRepositorio.findByLanguages(opcion);
        System.out.println(filtroFrances);
    }



}
