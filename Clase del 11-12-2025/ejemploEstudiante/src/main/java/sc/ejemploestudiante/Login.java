package sc.ejemploestudiante;

import java.util.Scanner;

public class Login {

    private RepositorioBibliotecario bibliotecario;
    private RepositorioEstudiante estudiantes;
    private Scanner entrada = new Scanner(System.in);

    public Login(RepositorioBibliotecario bibliotecario, RepositorioEstudiante estudiantes) {
        this.bibliotecario = bibliotecario;
        this.estudiantes = estudiantes;
    }

    public void iniciarsesion() {
        boolean salir = false;
        //estudiantes.mostrarEstudiante("2020");
        do {
            System.out.print("usuario: ");
            String usuario = entrada.nextLine();
            System.out.print("Contrasena: ");
            String contrasena = entrada.nextLine();

            if (usuario.equals("admin") && contrasena.equals("admin123")) {
                System.out.println("Bienvenido a Admin");
            } else if (estudiantes.encontrarEstudiante(usuario, contrasena)) {
                System.out.println("Bienvenido a Estudiantes");
            } else if (bibliotecario.encontrarBibliotecario(usuario, contrasena)) {
                System.out.println("Bienvenido a Bibliotecario");
            } else {
                System.out.println("No se encontro usuario");
            }
        } while (!salir);

    }
}
