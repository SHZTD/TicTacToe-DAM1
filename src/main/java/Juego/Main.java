package Juego;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc j = new Joc();

        while(true){
            switch (tui.mostrarMenu()) {
                case 1:
                    novaPartida(j, tui);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;

            }
            //tui.mostrarTaullel(j.getTaulell(), j.getTorn());
            //tui.recollirJugada();
            //tui.fiDePartida(j.getTorn());
            //j.novaPartida();
        }
    }

    private static void novaPartida(Joc j, TUI tui){
        j.novaPartida();
        while(true){
            tui.mostrarTaullel(j.getTaulell(), j.getTorn());
        }
    }

    private static void carregarPartida() {

    }

    private static void configuracio() {

    }

    private static void sortir() {
        System.exit(1);
    }

}