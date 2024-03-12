package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> listaLibros = new ArrayList<>();
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public Biblioteca() {
        listaLibros.add(new Libro("Quijote", "Miguel de Cervantes","8282"));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez","2828"));
        listaLibros.add(new Libro("1984", "George Orwell","1414"));
        listaLibros.add(new Libro("Orgullo y prejuicio", "Jane Austen","4141"));
        listaLibros.add(new Libro("El señor de los anillos", "J.R.R. Tolkien","1616"));
        listaLibros.add(new Libro("Crimen y castigo", "Fyodor Dostoevsky","6161"));

        listaUsuarios.add(new Usuario("Bruno","Fandiño","1234","bruno@gmail.com"));
        listaUsuarios.add(new Usuario("Julian", "Julianez", "5678", "julian@hotmail.com"));
        listaUsuarios.add(new Usuario("Minerva", "La cierva", "1254", "minervacierva@outlook.es"));
        listaUsuarios.add(new Usuario("Jorge", "el Gita", "7894", "gitanoman@yahoo.com"));
        listaUsuarios.add(new Usuario("Provenzo", "Artemaniaco", "1236", "provenzo12@icloud.com"));
    }

    public void verLibrosDisponibles(){
        StringBuilder librosDisponibles = new StringBuilder("Esta es la lista de libros disponibles:\n");
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            librosDisponibles.append(i + 1).append("- ").append(libro.getTitulo()).append("\n");
        }
        JOptionPane.showMessageDialog(null,librosDisponibles);
    }

    public void verLibrosAlquilados(){
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono para entrar a su cuenta de usuario");
        boolean usuarioEncontrado = false;
        for (Usuario usuario : listaUsuarios) {
            if (telefono.equals(usuario.getTelefono())) {
                usuarioEncontrado = true;
                if (usuario.getLibrosPorDevolver().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Estimado/a " + usuario.getNombre() + ", no tiene libros alquilados");
                    return;
                }
                StringBuilder librosUsuarios = new StringBuilder("Bienvenido/a " + usuario.getNombre() + ". Esta es la lista de libros que ha alquilado y pendientes de devolver:" + "\n");
                for (int x = 0; x < usuario.getLibrosPorDevolver().size(); x++) {
                    Libro libro = usuario.getLibrosPorDevolver().get(x);
                    librosUsuarios.append(x + 1).append("- ").append(libro.getTitulo()).append("\n");
                }
                JOptionPane.showMessageDialog(null, librosUsuarios);
            }
        }
        if (!usuarioEncontrado){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el usuario");
        }
    }

    public void alquilarLibro(){
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono para entrar a su cuenta de usuario");
        boolean usuarioEncontrado = false;
        for (Usuario usuario : listaUsuarios) {
            if (telefono.equals(usuario.getTelefono())) {
                usuarioEncontrado = true;
                StringBuilder librosDisponibles = new StringBuilder("Bienvenido/a " + usuario.getNombre() + ". ¿Qué libro quiere usted alquilar?" + "\n");
                for (int x = 0; x < listaLibros.size(); x++) {
                    Libro libro = listaLibros.get(x);
                    librosDisponibles.append(x + 1).append("- ").append(libro.getTitulo()).append("\n");
                }
                String input = JOptionPane.showInputDialog(librosDisponibles.toString());
                int indiceLibro = Integer.parseInt(input);
                if (indiceLibro > 0 && indiceLibro <= listaLibros.size()) {
                    Libro libroSeleccionado = listaLibros.get(indiceLibro - 1);
                    usuario.getLibrosPorDevolver().add(libroSeleccionado);
                    listaLibros.remove(libroSeleccionado);
                    JOptionPane.showMessageDialog(null, "Has alquilado el libro " + libroSeleccionado.getTitulo());
                } else {
                    JOptionPane.showMessageDialog(null, "El índice del libro no es válido.");
                    return;
                }
            }
        }
        if (!usuarioEncontrado){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el usuario");
        }
    }

    public void devolverLibro(){
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono para entrar a su cuenta de usuario");
        boolean usuarioEncontrado = false;
        for (Usuario usuario : listaUsuarios) {
            if (telefono.equals(usuario.getTelefono())) {
                usuarioEncontrado = true;
                if (usuario.getLibrosPorDevolver().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Estimado/a " + usuario.getNombre() + ", no tiene libros para devolver");
                    return;
                }
                StringBuilder librosDevolver = new StringBuilder("Bienvenido/a " + usuario.getNombre() + ". ¿Qué libro desea devolver?" + "\n");
                for (int x = 0; x < usuario.getLibrosPorDevolver().size(); x++) {
                    Libro libro = usuario.getLibrosPorDevolver().get(x);
                    librosDevolver.append(x + 1).append("- ").append(libro.getTitulo()).append("\n");
                }
                String input = JOptionPane.showInputDialog(librosDevolver.toString());
                int indiceLibro = Integer.parseInt(input);
                if (indiceLibro > 0 && indiceLibro <= usuario.getLibrosPorDevolver().size()) {
                    Libro libroSeleccionado = usuario.getLibrosPorDevolver().get(indiceLibro - 1);
                    listaLibros.add(libroSeleccionado);
                    usuario.getLibrosPorDevolver().remove(libroSeleccionado);
                    JOptionPane.showMessageDialog(null, "Ha devuelto el libro " + libroSeleccionado.getTitulo());
                } else {
                    JOptionPane.showMessageDialog(null, "El índice del libro no es válido.");
                    return;
                }
            }
        }
        if (!usuarioEncontrado){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el usuario");
        }
    }
}