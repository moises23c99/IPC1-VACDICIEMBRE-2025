package sc.ejemploestudiante.controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sc.ejemploestudiante.modelos.Bibliotecario;
import sc.ejemploestudiante.modelos.Estudiante;
import sc.ejemploestudiante.modelos.RepositorioBibliotecario;
import sc.ejemploestudiante.modelos.RepositorioEstudiante;
import sc.ejemploestudiante.modelos.RepositorioLibro;
import sc.ejemploestudiante.modelos.Libro;

public class ControladorAdministrador {

    private ControladorPrincipal controladorPrincipal;
    private RepositorioBibliotecario bibliotecarios;
    private RepositorioEstudiante estudiantes;
    private RepositorioLibro libros;

    public ControladorAdministrador(ControladorPrincipal controladorPrincipal,
            RepositorioBibliotecario bibliotecarios,
            RepositorioEstudiante estudiantes,
            RepositorioLibro libros) {
        this.controladorPrincipal = controladorPrincipal;
        this.bibliotecarios = bibliotecarios;
        this.estudiantes = estudiantes;
        this.libros = libros;
    }

    // ================= CARGA DE LIBROS =======================
    public void cargarLibros() {
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
            JOptionPane.showMessageDialog(null, "Carga completada total: " + contador);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de los datos: " + e.getMessage());
        }
    }

    //============= CARGA DE ESTUDIANTES
    public void cargarEstudiantes() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            System.out.println("Archivo elegido: " + archivoSeleccionado.getAbsolutePath());
            leerCSVEstudiantes(archivoSeleccionado);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    private void leerCSVEstudiantes(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                }

                String[] columnas = linea.split(",");

                // Saltar encabezado si existe (primera columna = "carrera")
                if (columnas[0].equalsIgnoreCase("carrera")) {
                    continue;
                }

                // Validar columnas necesarias
                if (columnas.length < 13) {
                    System.err.println("Línea inválida (faltan columnas): " + linea);
                    continue;
                }

                // Orden esperado:
                // carrera, semestre, facultad, carne, nombre, CUI, correo, contrasena, usuario, genero, telefono, edad, estadoCivil
                String carrera = columnas[0].trim();
                int semestre = Integer.parseInt(columnas[1].trim());
                String facultad = columnas[2].trim();
                String carne = columnas[3].trim();
                String nombre = columnas[4].trim();
                String CUI = columnas[5].trim();
                String correo = columnas[6].trim();
                String contrasena = columnas[7].trim();
                String usuario = columnas[8].trim();
                char genero = columnas[9].trim().charAt(0);
                int telefono = Integer.parseInt(columnas[10].trim());
                int edad = Integer.parseInt(columnas[11].trim());
                char estadoCivil = columnas[12].trim().charAt(0);

                Estudiante cargaEstudiante = new Estudiante(
                        carrera, semestre, facultad, carne,
                        nombre, CUI, correo, contrasena, usuario,
                        genero, telefono, edad, estadoCivil
                );

                estudiantes.agregarEstudiante(cargaEstudiante);
                contador++;
            }

            JOptionPane.showMessageDialog(null, "Carga completada total: " + contador);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de los datos numéricos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }

    //=============== CARGAR DE BIBLIOTECARIOS
    public void cargarBibliotecarios() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos CSV", "csv");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            System.out.println("Archivo elegido: " + archivoSeleccionado.getAbsolutePath());
            leerCSVBibliotecarios(archivoSeleccionado);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    private void leerCSVBibliotecarios(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                }

                String[] columnas = linea.split(",");

                // Saltar encabezado si existe
                if (columnas[0].equalsIgnoreCase("IDEmpleado")) {
                    continue;
                }

                // Validar columnas necesarias
                if (columnas.length < 12) {
                    System.err.println("Línea inválida (faltan columnas): " + linea);
                    continue;
                }

                // IDEmpleado, turno, areaTrabajo, nombre, CUI, correo, contrasena, usuario, genero, telefono, edad, estadoCivil
                String IDEmpleado = columnas[0].trim();
                String turno = columnas[1].trim();
                String areaTrabajo = columnas[2].trim();
                String nombre = columnas[3].trim();
                String CUI = columnas[4].trim();
                String correo = columnas[5].trim();
                String contrasena = columnas[6].trim();
                String usuario = columnas[7].trim();
                char genero = columnas[8].trim().charAt(0);
                int telefono = Integer.parseInt(columnas[9].trim());
                int edad = Integer.parseInt(columnas[10].trim());
                char estadoCivil = columnas[11].trim().charAt(0);

                Bibliotecario cargaBibliotecario = new Bibliotecario(
                        IDEmpleado, turno, areaTrabajo,
                        nombre, CUI, correo, contrasena, usuario,
                        genero, telefono, edad, estadoCivil
                );

                bibliotecarios.agregarBibliotecarios(cargaBibliotecario);
                contador++;
            }

            JOptionPane.showMessageDialog(null, "Carga completada total: " + contador);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato de los datos numéricos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }

    public Estudiante[] obtenerEstudiantes() {
        return estudiantes.todosLosEstudiantes();
    }

    public Bibliotecario[] obtenerBibliotecarios() {
        return bibliotecarios.todosBibliotecarios();
    }

    public Libro[] obtenerCatalogoLibros() {
        return libros.todosLosLibros();
    }
    
    public void agregarEstudiante(Estudiante nuevoEstudiante){
        estudiantes.agregarEstudiante(nuevoEstudiante);
    }

    public void cerrarSesion() {
        controladorPrincipal.mostrarLogin();
    }

}
