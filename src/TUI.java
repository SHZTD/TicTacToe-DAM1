import java.util.Scanner;

public class TUI {

    private int menu;
    private boolean sortir;

    public int getMenu() {
        return menu;
    }

    public boolean isSortir() {
        return sortir;
    }

    Scanner sc = new Scanner(System.in);

    public TUI(int menu, boolean sortir) {
        this.menu = sc.nextInt();
        this.sortir = sc.nextBoolean();
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
                default:
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
