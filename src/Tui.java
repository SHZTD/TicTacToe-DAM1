public class Tui {
    public int xsize = 0, ysize = 0;

    public void tuiGraphics(int xsize, int ysize) {
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                System.out.print("[+]");
            }
            System.out.print("\n");
        }
    }
}
