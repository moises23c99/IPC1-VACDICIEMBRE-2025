
package sc.ejemploestudiante.controladores;
import sc.ejemploestudiante.modelos.RepositorioLibro;
import sc.ejemploestudiante.modelos.Estudiante;
import sc.ejemploestudiante.modelos.Libro;

public class ControladorEstudiante {
    private ControladorPrincipal controladorPrincipal;
    private RepositorioLibro libros;
    
    public ControladorEstudiante(ControladorPrincipal controladorPrincipal,
            RepositorioLibro libros){
        this.controladorPrincipal = controladorPrincipal;
        this.libros = libros;
    }
    
    public Libro[] obtenerCatalogoLibros(){
        return libros.todosLosLibros();
    }
    
    public void cerrarSesion(){
        controladorPrincipal.mostrarLogin();
    }
}