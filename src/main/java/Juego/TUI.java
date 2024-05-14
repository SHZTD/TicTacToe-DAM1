package Juego;

import java.util.Scanner;

public class TUI {
    private Scanner sc = new Scanner(System.in);

    public int choice;
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
        choice = sc.nextInt();
        return choice;
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
    }

    public void mostrarTaulell(char[][] taulell, short torn) {
        return;
    }

    public short[] recollirJugada() {
        return new short[1];
    }

    public void fiDePartida(short guanyador) {
        return;
    }

}
