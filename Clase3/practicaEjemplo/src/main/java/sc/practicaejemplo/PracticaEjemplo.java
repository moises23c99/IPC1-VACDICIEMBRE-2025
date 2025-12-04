package sc.practicaejemplo;

import java.util.Scanner;

public class PracticaEjemplo {

    private static Scanner sc = new Scanner(System.in);
    private static final int Filas = 20;
    private static final int Columnas = 10;
    private static int[][] tablero = new int[Filas][Columnas];

    private static int[][] piezaI = {
        {0, 1, 0, 0},
        {0, 1, 0, 0},
        {0, 1, 0, 0},
        {0, 1, 0, 0}
    };

    private static int[][] piezaT = {
        {0, 1, 0, 0},
        {1, 1, 1, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };

    private static int[][] piezaO = {
        {1, 1, 0, 0},
        {1, 1, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };

    public static void main(String[] args) {
        boolean salir = false;
        int inicioFila = 0;
        int inicioColumna = 4;

        int ejex = inicioColumna;
        int ejey = inicioFila;

        iniciarTablero();
        colocarPiezaEnTablero(piezaI, inicioColumna, inicioFila);
        mostrarTablero();

        do {
            System.out.println("Comandos A/D(izq/der) W/S(arri/abajo");
            System.out.print("Ingrese un comnado: ");
            String entrada = sc.nextLine();

            if (entrada.equals("a")) {
                ejex -= 1;
            } else if (entrada.equals("d")) {
                ejex += 1;
            } else if (entrada.equals("w")) {
                ejey -= 1;
            } else if (entrada.equals("s")) {
                ejey += 1;
            } else if (entrada.equals("l")) {
                salir = true;
            }

            iniciarTablero();
            colocarPiezaEnTablero(piezaI, ejex, ejey);
            mostrarTablero();
        } while (!salir);
        /*mostrarTablero();
        iniciarTablero();
        colocarPiezaEnTablero(piezaI, 4, 0);
        mostrarTablero();
        
        iniciarTablero();
        colocarPiezaEnTablero(piezaI, 4, 10);
        mostrarTablero();*/

    }

    public static void iniciarTablero() {
        for (int i = 0; i < Filas; i++) {
            for (int j = 0; j < Columnas; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public static void mostrarTablero() {
        System.out.print(" +");
        for (int i = 0; i < Columnas; i++) {
            System.out.print("--");
        }
        System.out.println("+");

        for (int j = 0; j < Filas; j++) {
            System.out.print("|");
            for (int x = 0; x < Columnas; x++) {
                if (tablero[j][x] == 0) {
                    System.out.print(" .");
                } else if (tablero[j][x] == 1) {
                    System.out.print(" =");
                } else {
                    System.out.print(" ^");
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
                if(pieza[i][j]==1){
                    if(j<minCol){
                        minCol=j;
                    }
                    if(j>maxCol){
                        maxCol=j;
                    }
                    if(i<minFil){
                        minFil = i;
                    }
                    if(i>maxFil){
                        maxFil=i;
                    }
                }
            }
        }
        
        if(columna + minCol <0){
            columna =-minCol;
        }
        
        if(columna + maxCol >=Columnas){
            columna = Columnas-1-maxCol;
        }
        
        if(fila + minFil <0){
            fila =-minFil;
        }
        if(fila + maxFil >=Filas){
            fila= Filas-1-maxFil;
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
