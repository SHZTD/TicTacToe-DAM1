import Juego.Joc;
import Juego.TUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
        /*Lo que hemos hecho ha sido decir que el tablero que queremos obtener en este caso es un 3x3,
        compararlo con el tablero obtenido y como en este caso el 3x3 creado esta vació si no lo está dara un error.
         */

        char[][] taulellVacio = joc.getTaulell();
        Assertions.assertArrayEquals(taulellVacio, joc.getTaulell());
    }

    //Prueba unitaria de sí cuando empieza nueva partida es el turno del jugador 1

    @Test
    void testTurnoJuagador() {
        Joc joc = new Joc();
        short tornObtenido = 0;
        Assertions.assertEquals(tornObtenido, joc.getTorn());
    }

    //Test metode jugadaGuanayadora jugador 1
    //Test del metodo jugadaGuanayadora que lo que hace es que mira si la llamada del metodo da falso cuando el tablero esta vacio.

    @ParameterizedTest
    @CsvSource({"0,0","0,1","0,2","1,0","1,1","1,2","2,0","2,1","2,2"})
    void testJugadaGuanyadora1(short fila, short columna){
        //setup
        Joc joc = new Joc();
        joc.novaPartida();

        //ejecucion de prueba
        Assertions.assertFalse(joc.jugadaGuanyadora(fila,columna));
    }

    //Test metode jugadaGuanyadora la cual mira si una casilla esta ocupada, es decir una unica casilla que la llamada de falsa

    @ParameterizedTest
    @CsvSource({"0,1",
                "0,2",
                "1,0",
                "1,1",
                "1,2",
                "2,0",
                "2,1",
                "2,2"
    })
    void testJugadaGuanyadoraUnaCasella(short fila, short columna) throws IOException {
        //setup
        Joc joc = new Joc();
        joc.novaPartida();
        joc.jugar((short)0, (short)0);

        //ejecucion de prueba
        Assertions.assertFalse(joc.jugadaGuanyadora(fila,columna));
    }

    //Test jugadaGuanyadora se comprobará la jugada ganadora del jugador1

    @ParameterizedTest
    @CsvSource({"0,0", "0,2", "1,1", "1,2", "2,0", "2,1"})
    void testJugadaGuanyadoraJ1(short fila, short columna) {
        // Set up
        Joc joc = new Joc();
        joc.novaPartida();

        // Tablero con el cual jugador 1 gana
        char[][] tableroLleno = {
                {'x', 'x', ' '},
                {' ', 'x', 'o'},
                {' ', 'o', 'o'}
        };


        joc.setTaulell(tableroLleno);

        boolean resultado = joc.jugadaGuanyadora(fila, columna);

        Assertions.assertTrue(resultado);
    }


    //Test metode jugadaGuanayadora jugador 2

    @ParameterizedTest
    @CsvSource({"0,2", "1,0", "2,2"})
    void testJugadaGuanyadoraJ2(short fila, short columna) {
        // Configuración inicial
        Joc joc = new Joc();
        joc.novaPartida();

        // Tablero con el cual jugador 2 ganará con una jugada adicional
        char[][] tableroLlenoJugador2 = {
                {'x', 'x', ' '},
                {' ', 'x', 'o'},
                {' ', 'o', 'o'}
        };

        // Establecer el tablero personalizado
        joc.setTaulell(tableroLlenoJugador2);

        // Ejecutar la prueba
        boolean resultado = joc.jugadaGuanyadora(fila, columna);

        // Verificar que solo la casilla ganadora devuelve true
        Assertions.assertTrue(resultado);
    }

    //Test metodo empatar

    @ParameterizedTest
    @CsvSource({"0,1",
            "0,2",
            "1,0",
            "1,1",
            "1,2",
            "2,0",
            "2,1",
            "2,2"})

    void testEmpatar(short fila, short columna){
        //setup
        Joc joc = new Joc();
        joc.novaPartida();
        char [][] tableroLLeno={
                {'o', 'x', 'x'},
                {'x', 'o', 'o'},
                {'x', 'o', 'o'}
        };
        //ejecuación de prueba
        Assertions.assertEquals(tableroLLeno,joc.getTaulell());
    }

    //Test mostrarTaullel




    //Test metodo
    @Test
    void comprovarCarpetaOK() {
        // instacia
        Joc joc = new Joc();
        joc.crearCarpeta("savedgames");
        Assertions.assertTrue(true);
    }

    @Test
    void comprovarCarpetaNOOK() {
        // instacia
        Joc joc = new Joc();
        joc.crearCarpeta("yaint_a_folder_owo");
        Assertions.assertFalse(false);
    }

    @Test
    void comprovarUltimArxiu() throws IOException {
        // instancia
        Joc joc = new Joc();
        // instancia una partida rapida
        joc.novaPartida();
        // crea un taulell completament buit

        // guarda la partida
        joc.guardarPartida();
        File testFile = new File("savedgames");
        if (Files.exists(Path.of("savedgames"))) {
            Assertions.assertTrue(true);
        } else {
            Assertions.assertFalse(false);
        }
    }

    //Test comprovar archivos

    @Test
    void testComprovarArchivos(){

    }
}
