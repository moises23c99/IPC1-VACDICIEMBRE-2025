package sc.ejemploestudiante.controladores;

import java.util.Scanner;
import sc.ejemploestudiante.modelos.RepositorioBibliotecario;
import sc.ejemploestudiante.modelos.RepositorioEstudiante;
import sc.ejemploestudiante.modelos.RepositorioLibro;

public class ControladorLogin {
    private ControladorPrincipal controladorPrincipal;
    private RepositorioBibliotecario bibliotecarios;
    private RepositorioEstudiante estudiantes;


    public ControladorLogin(ControladorPrincipal controladorPrincipal,
            RepositorioBibliotecario bibliotecarios,
            RepositorioEstudiante estudiates){
        this.controladorPrincipal = controladorPrincipal;
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiates;
        
    }

    public void autenticar(String usuario, String contrasena) {
            if (usuario.equals("admin") && contrasena.equals("admin123")) {
                controladorPrincipal.mostrarVistaAdmin();
            } else if (estudiantes.encontrarEstudiante(usuario, contrasena)) {
                controladorPrincipal.mostrarVistaEstudiante();
            } else if (bibliotecarios.encontrarBibliotecario(usuario, contrasena)) {
                //pendiente
            } else {
                System.out.println("No se encontro usuario");
            }

    }
}