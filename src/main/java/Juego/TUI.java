package Juego;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                System.out.print(taulell[i][j]+ " ");
            }
            System.out.println();
        }

        String jugador;
        if (torn == 0){
            jugador = "x";
        }else {
            jugador = "o";
        }

        System.out.println("Torn del jugador: "+ jugador );
    }

    public int[] recollirJugada(){

        System.out.println("Introdueix la fila: ");
        int fila= sc.nextInt();

        System.out.println("Introdueix la columna: ");
        int columna= sc.nextInt();

        return new int[]{fila, columna};
    }

    public void fiDePartida(int guanyador){

        System.out.println("El guanyador de la partida es: " + (guanyador == 0 ? "o" : "x") + "!");
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

        System.out.println("Selecciona el tamany que vols del taullel. Recorda que ha de ser entre 3 i 10 : ");
        return sc.nextInt();

    }

    public void configurarTamany(){
        int midaTaulell = demanarTamany();
        if(midaTaulell >=3 && midaTaulell <=10){
            try{
                FileWriter tamany = new FileWriter("config.txt");
                tamany.write(Integer.toString(midaTaulell));
                tamany.close();
            }
            catch (IOException e) {
                System.out.println("Error en la configuració de la mida ");
            }
        }
        else {
            System.out.println("La mida del taulell ha de ser entre 3 i 10");
        }
    }

    public void llistarPartides(File[] numPartides) {
        System.out.println("Selecciona la partida que vols");
        for (int i = 0; i < numPartides.length; i++) {
            System.out.print("[ " + i + " ] " + numPartides[i].getName() + "\n");
        }
        int select = sc.nextInt();
    }


}
