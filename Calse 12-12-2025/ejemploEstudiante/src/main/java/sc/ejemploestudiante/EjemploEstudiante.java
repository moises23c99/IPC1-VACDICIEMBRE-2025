package sc.ejemploestudiante;

import sc.ejemploestudiante.modelos.Bibliotecario;
import sc.ejemploestudiante.modelos.Estudiante;

public class EjemploEstudiante {
    //public static Estudiante[] estudiantes = new Estudiante[10];

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        //Repositorios
        RepositorioEstudiante estudiantes = new RepositorioEstudiante();
        RepositorioBibliotecario bibliotecarios = new RepositorioBibliotecario();
        RepositorioLibro libros = new RepositorioLibro();
        
        //Agregar Estudiante
        Estudiante nuevoEstudiante = new Estudiante("Sistemas", 5, "Ingenieria", "estudiante1", "David", "1234567", "estudiantes@gmail.coom", "estudiante1", "estudiante1", 'M', 20, 213213, 'S');
        estudiantes.agregarEstudiante(nuevoEstudiante);
        /*
        Carné = estudiante1
        contrasena = estudiante1
        */
       
        //Agregar bibliotecarios
        Bibliotecario nuevoBibliotecario = new Bibliotecario("emple001", "matutina", "Secretaria", "Maria", "12345545", "maria@gmail.com", "maria123", "bibliotecaria001", 'F', 30, 123123, 's');
        bibliotecarios.agregarBibliotecarios(nuevoBibliotecario);
        /*
        IDEmpleado = emple001
        Contraseña = maria123
        */
        Login inicio = new Login(bibliotecarios, estudiantes,libros);
        inicio.iniciarsesion();
        
    }
    
    /*public static void Login(){
        String usuario;
        String contraseña;
        
        if(usuario == "admin" && contraseña == "admin123"){
            //llamar al contralos de Usuario
        }
    }*/

    /*private static void usuarioPredeterminados() {
        Estudiante estudianteUno = new Estudiante("Sistemas", 3, "Ingenieria", "20200000", "David Galvez", "9824768742346", "usuario1@gmail.com", "1234", "est001",
                'M', 76892354, 20, 'S');
        estudiantes[0] = estudianteUno;
        Estudiante estudianteDos = new Estudiante("Civil", 5, "Ingenieria", "20190000", "Abner Sotz", "9824768742346", "usuario1@gmail.com", "1234", "est002",
                'M', 76892354, 22, 'C');
        estudiantes[1] = estudianteDos;
    }
    
    public static Estudiante buscarEstudiante(String usuario){
        for (int i = 0; i <estudiantes.length; i++) {
            if(estudiantes[i].getUsuario()== usuario){
                return estudiantes[i];
            }
        }
        return null;
    }
    
    public static void mostarEstudiantes(){
        for(int i=0; i<estudiantes.length;i++){
            if(estudiantes[i]!=null){
                System.out.println("El nombre del estudiante es: " + estudiantes[i].getNombre());
            }
        }
    }
    
    public static void editarNombre(Estudiante estudianteActual){
        estudianteActual.SedNombre("Luis");
    }*/
}
