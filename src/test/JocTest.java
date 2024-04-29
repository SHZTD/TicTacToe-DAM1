package test;

import Juego.Joc;
import org.junit.jupiter.api.Assertions;
public class JocTest {
    @org.junit.jupiter.api.Test
    void testJugar() {
        Joc joc = new Joc();
        // obten el tablero
        int cx = 0, cy = 0;
        char[][] taulellObtenido= joc.getTaulell(); // obten el estatus del taulell
        Assertions.assertArrayEquals( new char[3][3] , taulellObtenido);
        // comprova q no hi ha res a la casella (0,0)
        // getTurno(); int j1 = o -> j2 = x
        // asumim q en aquest cas el taulell esta buit
        // if (taulellObtenido[0][0] != 'x' || taulellObtenido[0][0] != 'o') { }
        taulellObtenido[cx][cy] = 'o';
        taulellObtenido[cx][cy] = 'x';
    }
}
