package Juego;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        System.out.print("╔══════════════════════════╗\n" +
                         "║ Benvingut a tic tac toe! ║\n" +
                         "║------------------------- ║\n" +
                         "║ 1. Nova partida          ║\n" +
                         "║------------------------- ║\n" +
                         "║ 2. Carregar partida      ║\n" +
                         "║------------------------- ║\n" +
                         "║ 3. Configuració          ║\n" +
                         "║------------------------- ║\n" +
                         "║ 4. Sortir                ║\n" +
                         "╚══════════════════════════╝");

        Scanner sc = new Scanner(System.in);
        System.out.print("\nSelecciona l'opció que vols: ");
        int num= sc.nextInt();
    }
}