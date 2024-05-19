package Juego;

import java.io.File;
import java.util.Scanner;

public class TUI {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.print(
                """
                        ╔══════════════════════════╗
                        ║ Benvingut a tic tac toe! ║
                        ║------------------------- ║
                        ║ 1. Nova partida          ║
                        ║------------------------- ║
                        ║ 2. Carregar partida      ║
                        ║------------------------- ║
                        ║ 3. Configuració          ║
                        ║------------------------- ║
                        ║ 4. Sortir                ║
                        ╚══════════════════════════╝
                        Selecciona l'opció que vols: """);

        return sc.nextInt();
    }

    public void mostrarTaullel(char [][] taulell, int torn){
        for(int i=0; i < 3 ; i++){
            for(int j=0; j < 3; j++){
                System.out.print(taulell[i][j]);
            }
            System.out.println();
        }
        System.out.println("Torn del jugador: "+ torn);
    }

    public int[] recollirJugada(){

        System.out.println("Introdueix la fila: ");
        int fila= sc.nextInt();

        System.out.println("Introdueix la columna: ");
        int columna= sc.nextInt();

        return new int[]{fila, columna};
    }

    public void fiDePartida(int guanyador){

        System.out.println("El guañador de la partida es: " + guanyador + "!");
    }


    public int mostrarConfiguracio()
    {
        System.out.print(
                """
                        ╔══════════════════════════╗
                        ║ Configuració             ║
                        ║------------------------- ║
                        ║ 1. Configurar tamany     ║
                        ║------------------------- ║
                        ║ 2. Enrere                ║
                        ╚══════════════════════════╝
                        Selecciona l'opció que vols: """);
        return sc.nextInt();
    }

    public void gestinarConfiguracio(){

        while(true){
            switch (mostrarConfiguracio()){
                case 1:
                    configurarTamany();
                    break;
                case 2:
                    //El return es para volver al Menu Principal
                    return;
                default:
                    break;
            }
        }
    }

    public int demanarTamany(){

        System.out.println("Selecciona el tamany que vols del taullel: ");
        return sc.nextInt();

    }

    public void configurarTamany(){
     int midaTaulell = demanarTamany();

    }

    public void llistarPartides(File[] numPartides) {
        System.out.println("Selecciona la partida que vols");
        for (int i = 0; i < numPartides.length; i++) {
            System.out.print("[ " + i + " ] " + numPartides[i].getName() + "\n");
        }
        int select = sc.nextInt();
    }


}
