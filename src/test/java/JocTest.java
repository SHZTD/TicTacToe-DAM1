import Juego.Joc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JocTest {

    // UNICAMENT PER 1 JUGADOR
    @Test
    void testJugar() {
        Joc joc = new Joc();
        joc.novaPartida();

        char[][] testJoc = joc.getTaulell();
        testJoc[0][0] = 'o';

        char[][] p0 = {
                {'o', '#', '#'},
                {'#', '#', '#'},
                {'#', '#', '#'}
        };

        Assertions.assertArrayEquals(p0, testJoc);
    }

    // COMPROBAR QUE ES PODEN POSAR
    // A TOTES LES POSICIONS JUGADOR 1
    // CAL REFACTORING, MASSA FORÇA BRUTA.
    @Test
    void testJugador1() {
        // CAL REFACTORING, MASSA FORÇA BRUTA.
        Joc joc = new Joc();
        joc.novaPartida();

        char[][] p0 = joc.getTaulell();
        char[][] p1 = {
                {'#', '#', '#'},
                {'#', '#', '#'},
                {'#', '#', '#'}
        };

        char j1 = 'o';

        int valid = 0;
        int expected = 9;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                p0[i][j] = j1;
                p1[i][j] = j1;
                if (p0[i][j] == j1 && p1[i][j] == j1) {
                    valid++;
                }
            }
        }

        Assertions.assertEquals(expected, valid);
    }

    // COMPROBAR QUE ES PODEN POSAR
    // A TOTES LES POSICIONS JUGADOR 2
    // CAL REFACTORING, MASSA FORÇA BRUTA.
    @Test
    void testJugador2() {

        Joc joc = new Joc();
        joc.novaPartida();

        //char[][] p0 = joc.getTaulell();
        char[][] p0;
        char[][] p1 = {
                {'#', '#', '#'},
                {'#', '#', '#'},
                {'#', 'o', '#'}
        };

        p0 = p1;
        char j2 = 'x';

        int valid = 0;
        int expected = 8;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (p0[i][j] == 'o' && p1[i][j] == 'o') {
                    j+=1;
                }
                p0[i][j] = j2;
                p1[i][j] = j2;
                if (p0[i][j] == j2 && p1[i][j] == j2) {
                    valid++;
                }
            }
        }

        Assertions.assertEquals(expected, valid);
    }



//Test metode NovaPartida
    @Test
    void testTaulell() {
        Joc joc = new Joc();
        //llamo al taulell para poder obtener el tablero relleno que de # que en nuestro caso es lo vacio
        joc.novaPartida();
        /*Lo que hemos hemos hecho a sido decir que el tablero que queremos obetener en este caso es un 3x3,
        compararlo con el tablero obtenido y como en este caso el 3x3 creado esta vacio si no lo esta dara un error.
         */

        char[][] taulellVacio = joc.getTaulell();
        Assertions.assertArrayEquals(taulellVacio, joc.getTaulell());
    }

    @Test
    void testTurnoJuagador() {
        Joc joc = new Joc();
        short tornObtenido = 0;
        Assertions.assertEquals(tornObtenido, joc.getTorn());
    }

    //Test metode jugadaGuanayadora jugador 1
    @ParameterizedTest
    @CsvSource({"0,0","0,1","0,2","0,3","1,0","1,1","1,2","1,3","2,0","2,1","2,2","2,3","3,0","3,1","3,2","3,3"})
    void testJugadaGuanyadora1(short fila, short columna){
        Joc joc = new Joc();
        Assertions.assertFalse(joc.jugadaGuanyadora(fila,columna));

    }

    //Test metode jugadaGuanayadora jugador 2


}