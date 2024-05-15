package Juego;

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

    public void loadPartides() {

    }

}
