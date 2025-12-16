package sc.ejemploestudiante.modelos;

import sc.ejemploestudiante.modelos.Bibliotecario;

public class RepositorioBibliotecario {

    private Bibliotecario[] bibliotecarios = new Bibliotecario[100];

    //Agregar
    public void agregarBibliotecarios(Bibliotecario nuevoBibliotecario) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] == null) {
                bibliotecarios[i] = nuevoBibliotecario;
                break;
            }
        }
    }

    //eliminar
    public void eliminarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                bibliotecarios[i] = null;
            }
        }
    }

    //mostrarBibliotecarios
    public void mostrarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                System.out.println(bibliotecarios[i].toString());
            }
        }
    }

    //retornarBibliotecario
    public Bibliotecario retornarBibliotecario(String IDEmpleado) {
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado)) {
                return bibliotecarios[i];
            }
        }
        return null;
    }
    
    //encontrarBibliotecario
    public boolean encontrarBibliotecario(String IDEmpleado, String contrasena){
        for (int i = 0; i < bibliotecarios.length; i++) {
            if (bibliotecarios[i] != null && bibliotecarios[i].getIDEmpleado().equals(IDEmpleado) &&
                    bibliotecarios[i].getcontrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;        
    }

}
