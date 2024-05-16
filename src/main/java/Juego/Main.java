package Juego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc j = new Joc();

        while(true){
            tui.mostrarMenu();
            tui.mostrarTaullel(j.getTaulell(), j.getTorn());
            tui.recollirJugada();
            j.novaPartida();
        }
    }
    private void novaPartida2(){
        while(true){

        }
    }

}