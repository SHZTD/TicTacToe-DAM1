import Juego.Joc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JocTest {
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
}
