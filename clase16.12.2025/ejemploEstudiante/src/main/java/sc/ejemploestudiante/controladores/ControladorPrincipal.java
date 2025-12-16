package sc.ejemploestudiante.controladores;

import sc.ejemploestudiante.modelos.RepositorioBibliotecario;
import sc.ejemploestudiante.modelos.RepositorioEstudiante;
import sc.ejemploestudiante.modelos.RepositorioLibro;
import sc.ejemploestudiante.vistas.vistaAdmin;
import sc.ejemploestudiante.vistas.vistaEstudiante;
import sc.ejemploestudiante.vistas.vistaLogin;

public class ControladorPrincipal {
    //Estos son los repositorios
    private RepositorioBibliotecario bibliotecarios;
    private RepositorioEstudiante estudiates;
    private RepositorioLibro libros;
    
    // vistas "Se crean unicamente una vez
    private vistaLogin vLogin;
    private vistaAdmin vAdmin;
    private vistaEstudiante vEstudiante;
    
    // Controladores
   private ControladorLogin controladorLogin;
   private ControladorAdministrador controladorAdmin;
   private ControladorEstudiante controladorEstudiante;
   
   public ControladorPrincipal(RepositorioBibliotecario bibliotecarios,
            RepositorioEstudiante estudiantes,
            RepositorioLibro libros){
       this.bibliotecarios=bibliotecarios;
       this.estudiates = estudiantes;
       this.libros = libros;
       iniciarControladores();
       iniciarVistas();
   }
   
   private void iniciarControladores(){
       controladorLogin = new ControladorLogin(this,bibliotecarios, estudiates);
       controladorAdmin = new ControladorAdministrador(this,bibliotecarios, estudiates, libros);
       controladorEstudiante = new ControladorEstudiante(this,libros);
   }
   
   private void iniciarVistas(){
       vLogin = new vistaLogin(controladorLogin);
       vAdmin = new vistaAdmin(controladorAdmin);
       vEstudiante = new vistaEstudiante(controladorEstudiante);
   }
   
   public void mostrarLogin(){
       ocultarTodasLasVistas();
       vLogin.limpiarCampos();
       vLogin.setVisible(true);
   }
   
   public void mostrarVistaAdmin(){
       ocultarTodasLasVistas();
       vAdmin.setVisible(true);
   }
   
   public void mostrarVistaEstudiante(){
       ocultarTodasLasVistas();
       vEstudiante.setVisible(true);
   }
   
   private void ocultarTodasLasVistas(){
       vLogin.setVisible(false);
       vEstudiante.setVisible(false);
       vAdmin.setVisible(false);
   }
}
