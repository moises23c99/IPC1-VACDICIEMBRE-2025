import java.util.Scanner;
import java.util.Random;

public class ejemplo {

    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();
    private static final int Filas = 20;
    private static final int Columnas = 10;
    private static int[][] tablero = new int[Filas][Columnas];

    private static int[][] piezaI = {
            { 0, 1, 0, 0 },
            { 0, 1, 0, 0 },
            { 0, 1, 0, 0 },
            { 0, 1, 0, 0 }
    };

    private static int[][] piezaT = {
            { 0, 1, 0, 0 },
            { 1, 1, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }
    };

    private static int[][] piezaO = {
            { 1, 1, 0, 0 },
            { 1, 1, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }
    };

    private static int[][][] todasLasPiezas = { piezaI, piezaO, piezaT };

    public static void main(String[] args) {
        boolean salir = false;
        int inicioFila = 0;
        int inicioColumna = 4;

        int ejex = inicioColumna;
        int ejey = inicioFila;

        int[][] piezaActual = obtenerPieza();

        iniciarTablero();
        // colocarPiezaEnTablero(piezaActual, inicioColumna, inicioFila);
        mostrarTablero(piezaActual, ejex, ejey);

        do {
            System.out.println("Comandos A/D(izq/der) W/S(arri/abajo");
            System.out.print("Ingrese un comnado: ");
            String entrada = sc.nextLine();

            int anteriorX = ejex;
            int anterioY = ejey;

            if (entrada.equals("a")) {
                ejex -= 1;
            } else if (entrada.equals("d")) {
                ejex += 1;
            } else if (entrada.equals("w")) {
                piezaActual=rotarPieza(piezaActual);
            } else if (entrada.equals("s")) {
                ejey += 1;
            } else if (entrada.equals("l")) {
                salir = true;
            } else if (entrada.equals(" ")) {
                while (esMovimientoValido(piezaActual, ejex, ejey + 1)) {
                    ejey++;
                }

                fijarPieza(piezaActual, ejex, ejey);
                piezaActual = obtenerPieza();
                ejex=inicioColumna;
                ejey=inicioFila;

                mostrarTablero(piezaActual, ejex, ejey);
                continue;
            }else if(entrada.equals("esc")){
                salir=true;
                continue;
            }

            if (!esMovimientoValido(piezaActual, ejex, ejey)) {
                ejex = anteriorX;
                ejey = anterioY;

                if(entrada.equals("s")){
                    fijarPieza(piezaActual, ejex, ejey);
                    piezaActual = obtenerPieza();
                    ejex=inicioColumna;
                    ejey=inicioFila;   

                    //Aqui Finaliza el juevo

                }

            }

            mostrarTablero(piezaActual, ejex, ejey);

        } while (!salir);

    }

    public static int[][] rotarPieza(int[][] pieza){
        int[][] nuevaPieza = new int[4][4];

        //Copiar pieza
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nuevaPieza[j][i]=pieza[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                int temp = nuevaPieza[i][j];
                nuevaPieza[i][j]=nuevaPieza[i][3-j];
                nuevaPieza[i][3-j]= temp;
            }
        }

        return nuevaPieza;

    }

    public static void fijarPieza(int[][] pieza, int columna, int fila){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(pieza[i][j]==1){
                    int nuevaFila = fila + i;
                    int nuevaColuma = columna + j;
                    if(nuevaFila >=0 && nuevaFila <Filas && nuevaColuma >=0 && nuevaColuma<Columnas){
                        tablero[nuevaFila][nuevaColuma]=2;
                    }
                }
            }
        }
    }

    public static boolean esMovimientoValido(int[][] pieza, int columna, int fila) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (pieza[i][j] == 1) {
                    int nuevaFila = fila + i;
                    int nuevaColuma = columna + j;

                    if (nuevaColuma < 0 || nuevaColuma >= Columnas) {
                        return false;
                    }
                    if (nuevaFila < 0 || nuevaFila >= Filas) {
                        return false;
                    }

                    if (tablero[nuevaFila][nuevaColuma] == 2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[][] obtenerPieza() {
        int indiceAleatorio = random.nextInt(todasLasPiezas.length);
        return todasLasPiezas[indiceAleatorio];
    }

    public static void iniciarTablero() {
        for (int i = 0; i < Filas; i++) {
            for (int j = 0; j < Columnas; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public static void mostrarTablero(int[][] piezaActual, int columna, int fila) {

        int[][] tableroTemporal = new int[Filas][Columnas];

        // Ralizamos la copia del tablero
        for (int i = 0; i < Filas; i++) {
            for (int j = 0; j < Columnas; j++) {
                tableroTemporal[i][j] = tablero[i][j];
            }
        }

        // Piezas al tablero temporal
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (piezaActual[i][j] == 1) {
                    int nuevaFila = fila + i;
                    int nuevaColuma = columna + j;
                    if (nuevaFila >= 0 && nuevaFila < Filas && nuevaColuma >= 0 && nuevaColuma < Columnas) {
                        tableroTemporal[nuevaFila][nuevaColuma] = 1;
                    }
                }
            }
        }

        System.out.print(" +");
        for (int i = 0; i < Columnas; i++) {
            System.out.print("--");
        }
        System.out.println("+");

        for (int j = 0; j < Filas; j++) {
            System.out.print("|");
            for (int x = 0; x < Columnas; x++) {
                if (tableroTemporal[j][x] == 0) {
                    System.out.print(" .");
                } else if (tableroTemporal[j][x] == 1) {
                    System.out.print(" =");
                } else if (tableroTemporal[j][x] == 2) {
                    System.out.print(" #");
                }
            }
            System.out.println(" |");
        }

        System.out.print(" +");
        for (int i = 0; i < Columnas; i++) {
            System.out.print("--");
        }
        System.out.println("+");
    }

    public static void colocarPiezaEnTablero(int[][] pieza, int columna, int fila) {
        int minCol = 4, maxCol = -1;
        int minFil = 4, maxFil = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (pieza[i][j] == 1) {
                    if (j < minCol) {
                        minCol = j;
                    }
                    if (j > maxCol) {
                        maxCol = j;
                    }
                    if (i < minFil) {
                        minFil = i;
                    }
                    if (i > maxFil) {
                        maxFil = i;
                    }
                }
            }
        }

        if (columna + minCol < 0) {
            columna = -minCol;
        }

        if (columna + maxCol >= Columnas) {
            columna = Columnas - 1 - maxCol;
        }

        if (fila + minFil < 0) {
            fila = -minFil;
        }
        if (fila + maxFil >= Filas) {
            fila = Filas - 1 - maxFil;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (pieza[i][j] == 1) {
                    tablero[fila + i][columna + j] = 1;
                }

            }
        }
    }

}