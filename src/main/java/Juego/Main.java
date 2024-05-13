package Juego;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        TUI tui = new TUI();
        tui.mostrarMenu();
        Joc j = new Joc();
        j.novaPartida();
        j.guardarPartida();
    }
}