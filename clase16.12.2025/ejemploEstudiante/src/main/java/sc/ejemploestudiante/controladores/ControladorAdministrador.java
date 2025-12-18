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

    public void agregarEstudiante(Estudiante nuevoEstudiante) {
        estudiantes.agregarEstudiante(nuevoEstudiante);
    }

    public void cerrarSesion() {
        controladorPrincipal.mostrarLogin();
    }

    public Estudiante buscarEstudiantePorCarnet(String carnet) {
        return estudiantes.retornarEstudiante(carnet);
    }

    public boolean actualizarEstudiante(String carnet, Estudiante estudianteNuevo) {
        return estudiantes.actualizarEstudiante(carnet, estudianteNuevo);
    }

    public boolean alternarEstadoEstudiante(String carnet) {
        return estudiantes.alternarEstado(carnet);
    }
    // =================== MÉTODOS DE ORDENAMIENTO ===================
    public Libro[] ordenarLibros_ISBN_Burbuja() {
        Libro[] lista = copiarLibrosSinVacios();
        burbujaPorISBN(lista);
        return lista;
    }

    public Libro[] ordenarLibros_Titulo_Seleccion() {
        Libro[] lista = copiarLibrosSinVacios();
        seleccionPorTitulo(lista);
        return lista;
    }

    public Libro[] ordenarLibros_Autor_Insercion() {
        Libro[] lista = copiarLibrosSinVacios();
        insercionPorAutor(lista);
        return lista;
    }

    public Libro[] ordenarLibros_Editorial_QuickSort() {
        Libro[] lista = copiarLibrosSinVacios();
        quickSortPorEditorial(lista, 0, lista.length - 1);
        return lista;
    }

    public Libro[] ordenarLibros_Anio_MergeSort() {
        Libro[] lista = copiarLibrosSinVacios();
        mergeSortPorAnio(lista);
        return lista;
    }

// ---------- copiar arreglo sin null ----------
    private Libro[] copiarLibrosSinVacios() {
        Libro[] todos = libros.todosLosLibros(); 
        int cantidad = 0;

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                cantidad++;
            }
        }

        Libro[] copia = new Libro[cantidad];
        int pos = 0;

        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                copia[pos] = todos[i];
                pos++;
            }
        }

        return copia;
    }

    private void intercambiar(Libro[] lista, int i, int j) {
        Libro aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

// ===================== 1) BURBUJA POR ISBN =====================
    private void burbujaPorISBN(Libro[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            boolean huboCambio = false;

            for (int j = 0; j < lista.length - 1 - i; j++) {
                String isbn1 = lista[j].getISBN();
                String isbn2 = lista[j + 1].getISBN();

                if (isbn1.compareToIgnoreCase(isbn2) > 0) {
                    intercambiar(lista, j, j + 1);
                    huboCambio = true;
                }
            }

            if (!huboCambio) {
                break;
            }
        }
    }

// ===================== 2) SELECCIÓN POR TÍTULO =====================
    private void seleccionPorTitulo(Libro[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int posMenor = i;

            for (int j = i + 1; j < lista.length; j++) {
                String t1 = lista[j].getTitulo();
                String t2 = lista[posMenor].getTitulo();

                if (t1.compareToIgnoreCase(t2) < 0) {
                    posMenor = j;
                }
            }

            if (posMenor != i) {
                intercambiar(lista, i, posMenor);
            }
        }
    }

// ===================== 3) INSERCIÓN POR AUTOR =====================
    private void insercionPorAutor(Libro[] lista) {
        for (int i = 1; i < lista.length; i++) {
            Libro actual = lista[i];
            int j = i - 1;

            while (j >= 0 && lista[j].getAutor().compareToIgnoreCase(actual.getAutor()) > 0) {
                lista[j + 1] = lista[j];
                j--;
            }

            lista[j + 1] = actual;
        }
    }

// ===================== 4) QUICKSORT POR EDITORIAL =====================
    private void quickSortPorEditorial(Libro[] lista, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int p = partirPorEditorial(lista, inicio, fin);

        quickSortPorEditorial(lista, inicio, p - 1);
        quickSortPorEditorial(lista, p + 1, fin);
    }

    private int partirPorEditorial(Libro[] lista, int inicio, int fin) {
        Libro pivote = lista[fin];
        String editorialPivote = pivote.getEditorial();

        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            String editorialActual = lista[j].getEditorial();

            if (editorialActual.compareToIgnoreCase(editorialPivote) <= 0) {
                i++;
                intercambiar(lista, i, j);
            }
        }

        intercambiar(lista, i + 1, fin);
        return i + 1;
    }

// ===================== 5) MERGESORT POR AÑO =====================
    private void mergeSortPorAnio(Libro[] lista) {
        Libro[] auxiliar = new Libro[lista.length];
        mergeSortPorAnio(lista, auxiliar, 0, lista.length - 1);
    }

    private void mergeSortPorAnio(Libro[] lista, Libro[] auxiliar, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }

        int mitad = (izquierda + derecha) / 2;

        mergeSortPorAnio(lista, auxiliar, izquierda, mitad);
        mergeSortPorAnio(lista, auxiliar, mitad + 1, derecha);

        mezclarPorAnio(lista, auxiliar, izquierda, mitad, derecha);
    }

    private void mezclarPorAnio(Libro[] lista, Libro[] auxiliar, int izquierda, int mitad, int derecha) {
        int i = izquierda;
        int j = mitad + 1;
        int k = izquierda;

        while (i <= mitad && j <= derecha) {
            int anio1 = lista[i].getAnioPublicacion();
            int anio2 = lista[j].getAnioPublicacion();

            if (anio1 <= anio2) {
                auxiliar[k] = lista[i];
                i++;
            } else {
                auxiliar[k] = lista[j];
                j++;
            }
            k++;
        }

        while (i <= mitad) {
            auxiliar[k] = lista[i];
            i++;
            k++;
        }

        while (j <= derecha) {
            auxiliar[k] = lista[j];
            j++;
            k++;
        }

        for (int x = izquierda; x <= derecha; x++) {
            lista[x] = auxiliar[x];
        }
    }

}
