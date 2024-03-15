package org.example;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Autenticacion {
    private ArrayList<Usuario> listaUsuarios;

    public Autenticacion(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario iniciarSesion() {
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido/a, " + usuario.getNombre() + "!");
                return usuario;
            }
        }

        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
        return null;
    }

    public void registrarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");
        String telefono = JOptionPane.showInputDialog("Ingrese su número de teléfono:");
        String email = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
        String nombreUsuario = JOptionPane.showInputDialog("Elija un nombre de usuario:");
        String contraseña = JOptionPane.showInputDialog("Elija una contraseña:");

        Usuario nuevoUsuario = new Usuario(nombre, apellido, telefono, email, nombreUsuario, contraseña);
        listaUsuarios.add(nuevoUsuario);
        JOptionPane.showMessageDialog(null, "¡Registro exitoso! Ahora puede iniciar sesión con su nuevo usuario.");
    }
}