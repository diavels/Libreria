package com.propio.literalura.Principal;

import com.propio.literalura.Service.ConsumoAPI;

import java.util.Scanner;

public class principal {
    private static String UrlApi = "https://gutendex.com/books?search=";

    public static void menuPrincipal(){
        //generar el scanner
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        //generar el menu y su bucle
        do{
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

        }while(opcion != 0);
        opcion = teclado.nextInt();
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
                menuPrincipal();
        }
        


    }


    private static void buscarLibro() {
        var consumoApi = new ConsumoAPI();
        var json = consumoApi.obtenerDatos(UrlApi);

    }

    private static void mostrarListaDeLibros() {
    }

    private static void mostrarListaDeAutores() {
    }

    private static void mostrarAutoresVivos() {
    }

    private static void mostrarLibrosPorIdioma() {
    }
}
