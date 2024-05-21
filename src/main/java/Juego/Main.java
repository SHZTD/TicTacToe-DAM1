package Juego;

import java.io.FileNotFoundException;
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
        initPartida(j, tui);
    }

    private static void carregarPartida(Joc j, TUI tui) throws IOException {
        tui.llistarPartides(j.visualitzarPartides());
        j.selectPartida(tui.game); // ????? (dubte a resoldre)
        initPartida(j, tui);
    }

    private static void configuracio(Joc j, TUI tui) {
        tui.gestinarConfiguracio();
    }

    private static void sortir() {
        System.exit(0);
    }

    // extraccio de metode
    private static void initPartida(Joc j, TUI tui) throws IOException {
        boolean partidaEnCurso= true;

        while(partidaEnCurso){
            tui.mostrarTaullel(j.getTaulell(), j.getTorn());
            int[] jugada = tui.recollirJugada();
            j.jugar((short) jugada[0], (short) jugada[1]);

            if (j.jugadaGuanyadora((short) jugada[0], (short) jugada[1])){
                tui.mostrarTaullel(j.getTaulell(), j.getTorn());
                tui.fiDePartida(j.getTorn());
                partidaEnCurso=false;
            }

            if (jugada[0] == -1 && jugada[1] == -1) {
                partidaEnCurso = false;
                tui.partidaGuardada();
            }
        }
    }
}