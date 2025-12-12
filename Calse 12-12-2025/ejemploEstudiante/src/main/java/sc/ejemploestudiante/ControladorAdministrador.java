package sc.ejemploestudiante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import sc.ejemploestudiante.modelos.Libro;

public class ControladorAdministrador {
    private RepositorioBibliotecario bibliotecarios;
    private RepositorioEstudiante estudiantes;
    private RepositorioLibro libros;

    public ControladorAdministrador(RepositorioBibliotecario bibliotecarios, RepositorioEstudiante estudiantes, RepositorioLibro libros) {
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
        this.libros = libros;
    }
    
    public void menuPrincipal(){
        System.out.println("Dentro del menu del administrador");
        estudiantes.mostrarEstudiante("estudiante1");
        cargarLibros();

    }
    
        private void cargarLibros() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            System.out.println("Archivo elegido: " + archivoSeleccionado.getAbsolutePath());
            leerCSVLibros(archivoSeleccionado);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    private void leerCSVLibros(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");


                if (columnas[0].equalsIgnoreCase("ISBN")) {
                    continue;
                }

                String ISBN = columnas[0];
                String titulo = columnas[1];
                String autor = columnas[2];
                String editorial = columnas[3];
                int anioPublicacion = Integer.parseInt(columnas[4]);
                String categoria = columnas[5];
                int cantidad = Integer.parseInt(columnas[6]);
                String ubicacion = columnas[7];
                String descripcion = columnas[8];

                Libro nuevoLibro = new Libro(ISBN, titulo, autor, editorial, anioPublicacion, categoria, cantidad, ubicacion, descripcion);
                libros.agregarLibro(nuevoLibro);
                contador++;
            }
            System.out.println("Se cargaron " + contador + " libros exitosamente.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de los datos: " + e.getMessage());
        }
    }
    
}
