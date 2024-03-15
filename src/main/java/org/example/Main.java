package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            String[] opciones = {"Registrar usuario", "Iniciar sesión", "Libros disponibles", "Alquilar libro", "Devolver libro", "Salir"};

            int indiceOpciones = JOptionPane.showOptionDialog(null, "Bienvenido/a a la biblioteca, ¿qué necesita?:", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            String opcionElegida = opciones[indiceOpciones];

            switch (opcionElegida) {
                case "Registrar usuario":
                    biblioteca.agregarUsuario();
                    break;
                case "Iniciar sesión":
                    Usuario usuario = biblioteca.iniciarSesion();
                    if (usuario != null) {
                        while (true) {
                            String[] opcionesUsuario = {"Libros disponibles", "Libros alquilados", "Alquilar libro", "Devolver libro", "Salir"};

                            int indiceOpcionesUsuario = JOptionPane.showOptionDialog(null, "Bienvenido/a " + usuario.getNombre() + ", ¿qué necesita?:", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesUsuario, opcionesUsuario[0]);

                            String opcionElegidaUsuario = opcionesUsuario[indiceOpcionesUsuario];

                            switch (opcionElegidaUsuario) {
                                case "Libros disponibles":
                                    biblioteca.verLibrosDisponibles();
                                    break;
                                case "Libros alquilados":
                                    biblioteca.verLibrosAlquilados(usuario);
                                    break;
                                case "Alquilar libro":
                                    biblioteca.alquilarLibro(usuario);
                                    break;
                                case "Devolver libro":
                                    biblioteca.devolverLibro(usuario);
                                    break;
                                case "Salir":
                                    JOptionPane.showMessageDialog(null, "Has salido de la biblioteca. Bye-bye.");
                                    System.exit(0);
                            }
                        }
                    }
                    break;
                case "Libros disponibles":
                    biblioteca.verLibrosDisponibles();
                    break;
                case "Salir":
                    JOptionPane.showMessageDialog(null, "Has salido de la biblioteca. Bye-bye.");
                    System.exit(0);
            }
        }
    }
}
