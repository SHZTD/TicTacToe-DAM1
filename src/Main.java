public class Main extends TUI {

    public Main(int menu, boolean sortir) {
        super(menu, sortir);
    }

    public static void main(String[] args) {
        int menu = 4;
        boolean sortir = true;

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

        System.out.print("\nSelecciona l'opció que vols: ");
        TUI tui = new TUI(menu, sortir);
    }
}