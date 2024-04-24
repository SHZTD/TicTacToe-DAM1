public class TUI {
    int menu;
    boolean sortir;

    public TUI(int menu, boolean sortir) {
        this.menu = menu;
        this.sortir = sortir;
    }

    protected void menuM(int menu, boolean sortir) {

        while (sortir) {
            switch (menu) {
                case 1:
                    sortir = false;
                    novaPartida();
                    break;
                case 2:
                    sortir = false;
                    carregaPartida();
                    break;
                case 3:
                    sortir = false;
                    configuracio();
                    break;
                case 4:
                    sortir= true;
                    break;
            }
        }

    }
    protected  void novaPartida () {
        System.out.println();
    }
    protected void carregaPartida () {
        System.out.println();
    }

    protected  void configuracio () {
        System.out.println();
    }
}
