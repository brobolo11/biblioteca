package org.example;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String nombreUsuario;
    private String contraseña;
    private ArrayList<Libro> librosPorDevolver;

    public Usuario(String nombre, String apellido, String telefono, String email, String nombreUsuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.librosPorDevolver = new ArrayList<>();
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ArrayList<Libro> getLibrosPorDevolver() {
        return librosPorDevolver;
    }

    public void setLibrosPorDevolver(ArrayList<Libro> librosPorDevolver) {
        this.librosPorDevolver = librosPorDevolver;
    }
}
