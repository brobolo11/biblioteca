package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            String[] opciones = {"Libros disponibles", "Libros alquilados", "Alquilar libro", "Devolver libro", "Salir"};

            int indiceOpciones = JOptionPane.showOptionDialog(null, "Bienvenido/a a la biblioteca, ¿qué necesita?:", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,opciones[0]);

            String opcionElegida = opciones[indiceOpciones];

            switch (opcionElegida) {

                case "Libros disponibles":
                    biblioteca.verLibrosDisponibles();
                    break;

                case "Libros alquilados":
                    biblioteca.verLibrosAlquilados();
                    break;

                case "Alquilar libro":
                    biblioteca.alquilarLibro();
                    break;

                case "Devolver libro":
                    biblioteca.devolverLibro();
                    break;

                case "Salir":
                    JOptionPane.showMessageDialog(null, "Has salido de la biblioteca. Bye-bye.");
                    System.exit(0);
            }
        }
    }
}