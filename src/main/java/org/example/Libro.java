package org.example;

import java.util.ArrayList;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private ArrayList<Usuario> colaReserva;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.colaReserva = new ArrayList<>();
    }

    // Getters y setters

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ArrayList<Usuario> getColaReserva() {
        return colaReserva;
    }

    public void setColaReserva(ArrayList<Usuario> colaReserva) {
        this.colaReserva = colaReserva;
    }
}
