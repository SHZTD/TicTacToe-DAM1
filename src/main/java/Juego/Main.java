package Juego;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TUI tui = new TUI();
        Joc j = new Joc();
        while(true){
            switch (tui.mostrarMenu()) {
                case 1:
                    novaPartida(j, tui);
                    break;
                case 2:
                    carregarPartida(j, tui);
                    break;
                case 3:
                    configuracio(j, tui);
                    break;
                case 4:
                    sortir();
                    break;
                default:
                    System.out.println("Opció no valida, tria una opció del menú");
                    break;
            }
        }
    }

    private static void novaPartida(Joc j, TUI tui) throws IOException {
        j.novaPartida();
        boolean partidaEnCurso= true;

        while(partidaEnCurso){

            tui.mostrarTaullel(j.getTaulell(), j.getTorn());
            int[] jugada = tui.recollirJugada();
            j.jugar((short) jugada[0], (short) jugada[1]);

            if (j.jugadaGuanyadora((short) jugada[0], (short) jugada[1])){
                tui.fiDePartida(j.getTorn());
                partidaEnCurso=false;
            }
        }
    }

    private static void carregarPartida(Joc j, TUI tui) {
        tui.llistarPartides(j.visualitzarPartides());
    }

    private static void configuracio(Joc j, TUI tui) {
        tui.gestinarConfiguracio();
    }

    private static void sortir() {
        System.exit(0);
    }

}