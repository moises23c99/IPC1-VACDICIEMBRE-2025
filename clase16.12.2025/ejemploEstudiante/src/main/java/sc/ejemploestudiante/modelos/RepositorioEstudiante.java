package sc.ejemploestudiante.modelos;

import sc.ejemploestudiante.modelos.Estudiante;

public class RepositorioEstudiante {

    private Estudiante[] estudiantes = new Estudiante[100];

    public void agregarEstudiante(Estudiante estudianteAgregar) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] == null) {
                estudiantes[i] = estudianteAgregar;
                break;
            }
        }
    }

    public void eliminarEstudiante(String carnet) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCarne().equals(carnet)) {
                estudiantes[i].setActivo(false);
            }
        }
    }

    public void mostrarEstudiante(String carnet) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCarne().equals(carnet)
                    && estudiantes[i].isActivo()) {
                System.out.println(estudiantes[i].toString());
            }
        }
    }

    public Estudiante retornarEstudiante(String carnet) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCarne().equals(carnet)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    public boolean encontrarEstudiante(String carnet, String contrasena) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCarne().equals(carnet)
                    && estudiantes[i].getcontrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public Estudiante[] todosLosEstudiantes() {
        return estudiantes;
    }

    public boolean actualizarEstudiante(String carnet, Estudiante estudianteNuevo) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCarne().equals(carnet)) {
                estudianteNuevo.setActivo(estudiantes[i].isActivo());
                estudiantes[i] = estudianteNuevo;
                return true;
            }
        }
        return false;
    }

    public boolean cambiarEstado(String carnet, boolean nuevoEstado) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCarne().equals(carnet)) {
                estudiantes[i].setActivo(nuevoEstado);
                return true;
            }
        }
        return false;
    }

    public boolean alternarEstado(String carnet) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] != null && estudiantes[i].getCarne().equals(carnet)) {
                estudiantes[i].setActivo(!estudiantes[i].isActivo());
                return true;
            }
        }
        return false;
    }


    /*public void editarEstudiante(){
        boolean cambiarNombre = false;
        Estudiante estudianteActual = retornarEstudiante("2024000");
        
        if(estudianteActual== null){
            System.out.println("No se encontro el estudiante ");
            return;
        }
        
        String nuevoNombre= "Abner";
        cambiarNombre = true;
        
        if(cambiarNombre){
            estudianteActual.SedNombre(nuevoNombre);
            cambiarNombre = false;
        }        
    }*/
}
