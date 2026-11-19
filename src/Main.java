import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int MAX_FIL_YODA = 10;
    static final int MAX_COL_YODA = 10;
    static final int MAX_FIL_DM = 10;
    static final int MAX_COL_DM = 10;

    static final char LIBRE = 'L';
    static final char MURO = 'M';
    static final char VADER = 'V';
    static final char POCIMA = 'P';


    static void rellenarTablero(char[][] tablero){
        for (int i = 0; i < MAX_FIL_YODA; i++) {
            for (int j = 0; j < MAX_COL_YODA; j++) {
                tablero[i][j] = LIBRE;
            }
        }
    }


    static void imprimirTablero (char[][] tablero){
        for (int i = 0; i < MAX_FIL_YODA; i++) {
            for (int j = 0; j < MAX_COL_YODA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int aleatorio(){
        Random num = new Random();
        int numeroRandom = num.nextInt(10);
        return numeroRandom;
    }

    static void rellenarMuros(char[][] tableroM){
        int filaAl = -1;
        int colAl = -1;
        for (int i = 0; i < 10; i++) {
            do{
                filaAl = aleatorio();
                colAl = aleatorio();
            }while(tableroM[filaAl][colAl]!=LIBRE);
            tableroM[filaAl][colAl] = MURO;
        }

    }

    static void rellenarVader(char[][] tableroV){
        int filaAl = -1;
        int colAl = -1;
        for (int i = 0; i < 7; i++) {
            do{
                filaAl = aleatorio();
                colAl = aleatorio();
            }while(tableroV[filaAl][colAl]!=LIBRE);
            tableroV[filaAl][colAl] = VADER;
        }
    }

    static void rellenarPocimas(char[][] tableroP){
        int filaAl;
        int colAl;
        for (int i = 0; i < 5; i++) {
            do{
                filaAl = aleatorio();
                colAl = aleatorio();
            }while(tableroP[filaAl][colAl]!=LIBRE);
            tableroP[filaAl][colAl] = POCIMA;
        }
    }
    static int moverJugador



    public static void main(String[] args) {
        char YODA = 'Y';

        char DM = 'D';


        char[][] tableroYoda = new char[MAX_FIL_YODA][MAX_COL_YODA];
        char[][] tableroDM = new char[MAX_FIL_DM][MAX_COL_DM];




        rellenarTablero(tableroYoda);



        imprimirTablero(tableroYoda);



        // 1 YODA


        int filaAl = -1;
        int colAl = -1;
        int filaOficialYoda = -1;
        int columnaOficialYoda = -1;

        do{
            filaAl = aleatorio();
            colAl = aleatorio();
        }while(tableroYoda[filaAl][colAl]!=LIBRE);
        tableroYoda[filaAl][colAl] = YODA;




        // OFICIALIZO LAS POSICIONES DE MI YODA
        filaOficialYoda = filaAl;
        columnaOficialYoda = colAl;




        // FIN

        rellenarMuros(tableroYoda);


        rellenarVader(tableroYoda);

        rellenarPocimas(tableroYoda);






        imprimirTablero(tableroYoda);
        // EMPIEZA EL JUEGO !!!
        int vidas = 10;
        Scanner lector = new Scanner(System.in);
        do {
            System.out.println("EMPIEZA EL JUEGO!!");
            System.out.println("Te mueves en WASD");
            System.out.println("Dime una letra de movimiento !!");
            char mov = lector.next().charAt(0);
            int filaAnteriorYoda = filaOficialYoda;
            int colAnteriorYoda = columnaOficialYoda;
            switch (mov){ // W, A, S o D
                case 'W':
                    filaOficialYoda = filaOficialYoda - 1;
                    break;
                case 'A':
                    columnaOficialYoda = columnaOficialYoda - 1;
                    break;
                case 'S':
                    filaOficialYoda = filaOficialYoda + 1;
                    break;
                case 'D':
                    columnaOficialYoda = columnaOficialYoda + 1;
                    break;
            }
            // Y SI YODA SE SALE DEL TABLERO ??????????????????
            if(
                    filaOficialYoda < 0 ||
                            filaOficialYoda > 9 ||
                            columnaOficialYoda < 0 ||
                            columnaOficialYoda > 9
            ){
                System.out.println("EHHHHHHHH!!!!!!!!!!!!");
                System.out.println("LÍMITE DE TABLERO!!!!!!");
                filaOficialYoda = filaAnteriorYoda;
                columnaOficialYoda = colAnteriorYoda;
            }else{
                if(tableroYoda[filaOficialYoda][columnaOficialYoda] == MURO){
                    System.out.println("NO PUEDES PASAR!!!!!");
                    filaOficialYoda = filaAnteriorYoda;
                    columnaOficialYoda = colAnteriorYoda;
                }else if(tableroYoda[filaOficialYoda][columnaOficialYoda] == POCIMA){
                    tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                    tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                    vidas++;
                }else if(tableroYoda[filaOficialYoda][columnaOficialYoda] == VADER){
                    tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                    tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                    vidas--;
                }else if(tableroYoda[filaOficialYoda][columnaOficialYoda] == LIBRE){
                    tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                    tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                }

            }

        }while(vidas>0);










    }


}