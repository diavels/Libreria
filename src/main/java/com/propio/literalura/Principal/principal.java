package com.propio.literalura.Principal;


import com.propio.literalura.DTO.Datos;
import com.propio.literalura.DTO.Libro;
import com.propio.literalura.Service.ConsumoAPI;
import com.propio.literalura.Service.ConvierteDatos;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class principal {

    private final String UrlApi = "https://gutendex.com/books/?search=";
    Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();



    public void menuPrincipal() throws IOException, InterruptedException {

        int opcion = -1;
        //generar el menu y su bucle
        while (opcion != 0) {
            System.out.println("""
                    =====Bienvenidos a LiterAlura=========
                    
                    Elige una opcion
                    
                    1 - BUSCA UN LIBRO POR SU NOMBRE
                    2 - LISTA DE LIBROS REGISTRADOS
                    3 - LISTA DE AUTORES REGISTRADOS
                    4 - LISTA DE AUTORES VIVOS EN DETERMINADO AÑO
                    5 - LIBROS REGISTRADOS POR IDIOMA
                    
                    
                    0 - SALIR
                    """);

            opcion = teclado.nextInt();
            teclado.nextLine();
            //genera el switch que integra los metodos a aplicar segun cada caso

         switch (opcion){
            case 1:
                //funcion de budcar libro por nombre
                buscarLibro();
                break;
            case 2:
                //mostrar lista de libros
                mostrarListaDeLibros();
                break;
            case 3:
                //funcion de mostrar lista de autores registrados
                mostrarListaDeAutores();
            case 4:
                //mostrar lista de autores vivos segun año
                mostrarAutoresVivos();
            case 5:
                //mostrar libros por idioma, debe generar un texto
                //que pueda hacer elegir entre distintos idiomas
                //y luego mostrar los libros registrados en el idioma correspondiente
                mostrarLibrosPorIdioma();
            case 0:
                System.out.println("""
                        ====CERRANDO LA APLICACION=====
                          GRACIAS POR SU PREFERENCIA
                        """);
                break;
            default:
                System.out.println("opcion incorrecta, ingrese otra opcion");
         }
        }
    }


    private void buscarLibro() {
        System.out.println("¿Que libro desea buscar?");
        var nombreLibro= teclado.nextLine();
        var Json = consumoAPI.obtenerDatos(UrlApi + nombreLibro.replace(" ", "+"));
        Datos datos = conversor.obtenerDatos(Json, Datos.class);
        System.out.println(datos);
        Optional<Libro> libroBuscado = datos.resultados().stream()
                .filter(libro -> libro.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()){
            System.out.println("*********************************");
            System.out.println("Libro encontrado: ");
            System.out.println("Titulo: " + libroBuscado.get().titulo());
            System.out.println("Autor: " + libroBuscado.get().autor().get(0).nombre());
            System.out.println("Idioma: " + libroBuscado.get().idioma());
            System.out.println("Numero de Descargas: " + libroBuscado.get().descargas());
            System.out.println("*********************************");
        }else {
            System.out.println("Libro no encontrado");
        }
    }

    private  void mostrarListaDeLibros() {
        System.out.println();
    }

    private  void mostrarListaDeAutores() {
    }

    private  void mostrarAutoresVivos() {
    }

    private  void mostrarLibrosPorIdioma() {
    }
}
