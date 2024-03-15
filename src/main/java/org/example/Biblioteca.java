package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;
    private Autenticacion autenticacion;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        autenticacion = new Autenticacion(listaUsuarios);

        // Agregar libros iniciales
        inicializarLibros();
    }

    private void inicializarLibros() {
        listaLibros.add(new Libro("Quijote", "Miguel de Cervantes","8282"));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez","2828"));
        listaLibros.add(new Libro("1984", "George Orwell","1414"));
        listaLibros.add(new Libro("Orgullo y prejuicio", "Jane Austen","4141"));
        listaLibros.add(new Libro("El señor de los anillos", "J.R.R. Tolkien","1616"));
        listaLibros.add(new Libro("Crimen y castigo", "Fyodor Dostoevsky","6161"));
    }

    public void agregarUsuario() {
        autenticacion.registrarUsuario();
    }

    public Usuario iniciarSesion() {
        return autenticacion.iniciarSesion();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public void agregarUsuario(String nombre, String apellido, String telefono, String email, String nombreUsuario, String contraseña) {
        Usuario nuevoUsuario = new Usuario(nombre, apellido, telefono, email, nombreUsuario, contraseña);
        listaUsuarios.add(nuevoUsuario);
    }

    // Métodos para manejar la cola de reserva de libros
    public void agregarAcolaReserva(Libro libro, Usuario usuario) {
        libro.getColaReserva().add(usuario);
    }

    public void notificarSiguienteUsuario(Libro libro) {
        if (!libro.getColaReserva().isEmpty()) {
            Usuario siguienteUsuario = libro.getColaReserva().remove(0);
            JOptionPane.showMessageDialog(null, "El libro " + libro.getTitulo() + " está disponible. Se ha notificado al siguiente usuario en la cola: " + siguienteUsuario.getNombre());
        }
    }

    public void verLibrosDisponibles() {
        StringBuilder librosDisponibles = new StringBuilder("Esta es la lista de libros disponibles:\n");
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            librosDisponibles.append(i + 1).append("- ").append(libro.getTitulo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, librosDisponibles);
    }

    public void alquilarLibro(Usuario usuario) {
        if (listaLibros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros disponibles para alquilar.");
            return;
        }

        StringBuilder librosDisponibles = new StringBuilder("Bienvenido/a " + usuario.getNombre() + ". ¿Qué libro quiere usted alquilar?" + "\n");
        for (int x = 0; x < listaLibros.size(); x++) {
            Libro libro = listaLibros.get(x);
            librosDisponibles.append(x + 1).append("- ").append(libro.getTitulo()).append("\n");
        }
        String input = JOptionPane.showInputDialog(librosDisponibles.toString());
        int indiceLibro = Integer.parseInt(input);
        if (indiceLibro > 0 && indiceLibro <= listaLibros.size()) {
            Libro libroSeleccionado = listaLibros.remove(indiceLibro - 1);
            usuario.getLibrosPorDevolver().add(libroSeleccionado);
            JOptionPane.showMessageDialog(null, "Has alquilado el libro " + libroSeleccionado.getTitulo());
        } else {
            JOptionPane.showMessageDialog(null, "El índice del libro no es válido.");
        }
    }

    public void devolverLibro(Usuario usuario) {
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
            Libro libroSeleccionado = usuario.getLibrosPorDevolver().remove(indiceLibro - 1);
            listaLibros.add(libroSeleccionado);
            JOptionPane.showMessageDialog(null, "Ha devuelto el libro " + libroSeleccionado.getTitulo());
        } else {
            JOptionPane.showMessageDialog(null, "El índice del libro no es válido.");
        }
    }

    public void verLibrosAlquilados(Usuario usuario) {
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
