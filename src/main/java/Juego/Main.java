package Juego;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc j = new Joc();
        while( true){
            //mostrar los menus
            switch (tui.mostrarMenu()){
                case 1:
                    j.novaPartida();
                    break;
                case 2:
                    j.carregarPartida();
                    break;
                case 3:
                    if(tui.configuracio()==1){
                       j.recogerConfiguracion();
                    }else if (tui.configuracio()==2){
                        break;
                    }
                    break;
                default:
                    break;
            }

        }
    }
}