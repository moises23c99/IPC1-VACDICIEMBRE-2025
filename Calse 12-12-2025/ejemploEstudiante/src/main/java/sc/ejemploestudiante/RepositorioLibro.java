package sc.ejemploestudiante;

import sc.ejemploestudiante.modelos.Libro;

public class RepositorioLibro {

    private Libro[] libros = new Libro[200];

    public void agregarLibro(Libro libroNuevo) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = libroNuevo;
                break;
            }
        }
    }

    public void eliminarLibro(String ISBN) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getISBN().equals(ISBN)) {
                libros[i]= null;
            }
        }
    }
    
   public Libro buscarLibro(String ISBN) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getISBN().equals(ISBN)) {
                return libros[i];
            }
        }
        return null;
    }

    public boolean verificarLibro(String ISBN) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null && libros[i].getISBN().equals(ISBN)) {
                return true;
            }
        }
        return false;
    } 
    
    public void mostarTodosLibros(){
        for (int i = 0; i < libros.length; i++) {
            if(libros[i]!=null){
                System.out.println(libros[i].toString());
            }
        }        
    }
    public Libro[] todosLosLibros() {
        return libros;
    }
}

