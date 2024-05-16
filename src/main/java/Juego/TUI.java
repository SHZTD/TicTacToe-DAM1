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

    }

    public void fiDePartida(int guanyador){

        if()
    }


    public void configuracio()
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
        switch (sc.nextInt()){
            case 1:
                configurarTamany();
                break;
            case 2:
                System.out.println("Tornem al menú principal");
                break;
        }
    }

    public int configurarTamany(){
        return 1;
    }

    public void cargarPartides(File[] numPartides) {
        System.out.println("Selecciona la partida que vols");
        for (int i = 0; i < numPartides.length; i++) {
            System.out.print("[ " + i + " ] " + numPartides[i].getName() + "\n");
        }
        int select = sc.nextInt();
    }


}
