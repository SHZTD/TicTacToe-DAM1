package test;

import Juego.Joc;
import org.junit.jupiter.api.Assertions;

public class JocTest {
    @org.junit.jupiter.api.Test
    void testJugar() {
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short)0, (short)0);

        char[][] p0 = {
                {'x', '#', '#'},
                {'#', '#', '#'},
                {'#', '#', '#'}
        };

        Assertions.assertArrayEquals(p0, joc.getTaulell());
    }
}
