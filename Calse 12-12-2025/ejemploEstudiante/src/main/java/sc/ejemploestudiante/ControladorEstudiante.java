
package sc.ejemploestudiante;
import sc.ejemploestudiante.modelos.Estudiante;

public class ControladorEstudiante {
    private RepositorioLibro libros;
    
    public ControladorEstudiante(RepositorioLibro libros){
        this.libros = libros;
    }
    
    public void mostrarLibros(){
        libros.mostarTodosLibros();
    }
}
