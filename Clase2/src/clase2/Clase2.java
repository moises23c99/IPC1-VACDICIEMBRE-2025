package clase2;
import java.util.Scanner;
        
public class Clase2 {
    public static void main(String[] args) {
        // Esto es un comentario de una sola linea
        
        /*
        Esto es un comentario 
        multinlinea 
        */
        
        /*
        ==========VARIABLES============
        */
        
        int edad = 20;
        double altura = 1.70;
        boolean esEstudiante = true;
        char mi_Inicial = 'M';
        
        System.out.println("Tu edad es: " + edad + ", y tu altura: " + altura +
                "¿Eres estudiante? " + esEstudiante + " tu inicial: "+ mi_Inicial);
        
        
        /*
        ==========CAS TEOS============
        */
        
        double edadNuevo = edad;
        int alturaNueva = (int)altura;
        
        System.out.println("Los datos con CAS TEOS SON: ");
        System.out.println("Edad: " + edadNuevo + " Altura: " + alturaNueva);
        
        /*
        ==========Operaciones============
        */

        System.out.println("Sumar 5 a la edad: " + (edad + 5)); 
        System.out.println("Restar 2 a la edad: "+ (edad - 5));
        System.out.println("Multiplicar la edad por dos: " + (edad * 2));
        
        
        // Relaciones
        boolean mayorEdad = edad >= 18;
        boolean esIgual = edad==20;
        
        System.out.println("El estudiante es mayor de edad: "+ mayorEdad);
        System.out.println("¿Su edad es igual a 20? " + esIgual);
        /*
            ENTRADA DE TEXTO 
        */        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("\nIngrese su nombre completo: ");
        String nombreCompleto = entrada.nextLine();
        
        System.out.println("El usuario ingreso el siguiente nombre: " + nombreCompleto);
        
        boolean salir = false;
        
        while(!salir){
            System.out.println("======= Menu principal ========");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Mejor puntaje ");
            System.out.println("3. Estadistica general");
            System.out.println("4. Salir");
            
            System.out.print("Ingrese una opcion valida");
            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1:
                    iniciaJuego();
                    break;
                case 2:
                    mostrarPunteo();
                    break;
                case 3:
                    estadisticasGenerales();
                    break;
                case 4:
                    salir = true;
                default:
                    System.out.println("Ingrese una opcion validad");
            }
        }
    }
    
    public static void iniciaJuego(){
        System.out.println("Logica del punteo ");
    }
        
    public static void mostrarPunteo(){
        System.out.println("Logica del punteo ");
    }
    
    public static void estadisticasGenerales(){
        System.out.println("Mostrar las estadisicas generales");
    }
}
