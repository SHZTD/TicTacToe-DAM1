import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Juego.Joc;

public class NovaPartidaTest {

    @Test
    void testTaulell() {
        Joc joc = new Joc();

        /*Lo que hemos hemos hecho a sido decir que el tablero que queremos obetener en este caso es un 3x3,
        compararlo con el tablero obtenido y como en este caso el 3x3 creado esta vacio si no lo esta dara uin error.
         */

        char[][] taulellVacio = joc.getTaulell();
        Assertions.assertArrayEquals(taulellVacio, joc.getTaulell());
    }

    @Test
    void testTurnoJuagador(){
        Joc joc = new Joc();
        short tornObtenido = 0;
        Assertions.assertEquals(tornObtenido, joc.getTorn());
    }


}
