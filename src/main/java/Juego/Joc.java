package Juego;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Joc {


    public static final String SAVEDGAMES = "savedgames";
    public static final String Config = "config";
    private char[][] taulell;

    public void setTaulell(char[][] taulell) {
        this.taulell = taulell;
    }

    public char[][] getTaulell() {

        return taulell;
    }

    private short torn;

    public void setTorn(short torn) {
        this.torn = torn;
    }

    public short getTorn() {
        return torn;
    }

    public void novaPartida() {
        //Esto es para inicializar el tablero como un 3x3
        taulell = new char[3][3];
        //Esto es para rellenarlo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                taulell[i][j] = '#';
            }
        }
        //Aqui lo que hacemos es poner el turno como 0 para que se reinicie al comenzar una partida
        torn = 0;
    }

    // empezamos a escribir los chars en nuestro tablero
    public void jugar(short fila, short columna) throws IOException {
        if(fila == -1 && columna == -1) {
            guardarPartida();
        }
        switch (torn) {
            case 0:
                taulell[fila][columna] = 'x';
                torn = 1;
                break;
            case 1:
                taulell[fila][columna] = 'o';
                torn = 0;
                break;
        }
    }

    /*
    jugadaGuanyadora: donada una fila i columna, simula si es tracta d’una jugada guanyadora;
    en acabar, el taulell i el torn no queden alterats.
     */
    public boolean jugadaGuanyadora(short fila, short columna) {

        //Si el turno es == 0 es que le toca al jugador 1, por lo tanto, será 'o' si no es turno == 0 entonces es el turno del jugador 2, pues, será 'x'

        char jugador = (torn == 0) ? 'o' : 'x';
        int contador = 0;

        //Aqui verificamos si hay las posiciones de forma vertical es decir las filas para ver si hay una jugada ganadora

        for (int i = 0; i < 3; i++) {
            if (getTaulell()[fila][i] == jugador) {
                contador++;
            }
        }
        //Si el contador es igual a 3 indica que hay jugada ganadora y, por lo tanto, devuelve un true
        if (contador == 3) {
            return true;
        }

        //Aqui verificamos si hay las posiciones de forma horizontal es decir las filas para ver si hay una jugada ganadora

        for (int i = 0; i < 3; i++) {
            if (getTaulell()[i][columna] == jugador) {
                contador++;
            }
        }

        if (contador == 3) {
            return true;
        }

        //Verificamos las diagonales del tablero

        for (int i = 0; i < 3; i++) {
            if (getTaulell()[i][i] == jugador) {
                contador++;
            }
        }

        if (contador == 3) {
            return true;
        }

        //Esta suma la hacemos para comprobar la diagonal de derecha a izquierda desde arriba

        /*
        El condicional está creado para verificar si nos encontramos dentro de esta diagonal, y va de la siguiente manera:

        Para entenderlo hay que ver que cuando vemos esta diagonal hay que ver que las posicion de estas diagonales da un total 2.
        Un ejemplo es, la posicion '0,2' la suma da 2, la posicion '1,1' la suma da 2 y asi con la última. Es por eso, por lo que
        está el condicional.
         */

        if (fila + columna == 2) {

            for (int i = 0; i < 3; i++) {
                if (getTaulell()[i][2 - i] == jugador) {
                    contador++;
                }
            }

            if (contador == 3) {
                return true;
            }
        }

        //Si da falso significa que el metodo no ha encontrado jugada ganadora
        return false;
    }

    // llogica de gestio de fitxers a FULL

    public boolean crearCarpeta(String path) {
        File carpeta = new File(path);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        return false;
    }

    public void guardarPartida() throws IOException
    {
        if (!crearCarpeta(Joc.SAVEDGAMES)) { crearCarpeta(Joc.SAVEDGAMES); }
        Date date = new Date();
        SimpleDateFormat dataGuardar = new SimpleDateFormat("yyyyMMddhhmmss");
        String path = "savedgames";
        String nom = dataGuardar.format(date) + ".txt";
        FileWriter archiu = new FileWriter(path + "/" + nom);
        String metadata = getTorn() + "\n" + Arrays.deepToString(getTaulell());
        archiu.write(metadata);
        archiu.close();
    }

    public File[] visualitzarPartides() {
        if (crearCarpeta(Joc.SAVEDGAMES)) {
            // instancia i llista si existeixen partides, sino res.
            File partides = new File(Joc.SAVEDGAMES);
            File[] arxius = partides.listFiles();
            if (arxius.length != 0) {
               return arxius;
            }
        }

        return new File[0];
    }

    public int carregarPartida() {
        return 69;
    }

    public int recogerConfiguracion(int opciones)  {
       
        switch (opciones){
           case 1:
               configurarTamany();
               break;
           case 2: 
               break;
       }
       
       return opciones;
    }


    public void configurarTamany() {


        if(!crearCarpeta(Joc.Config)){
            crearCarpeta(Joc.Config);
        }
        String path = "config";
        String nom = "config.txt";
        FileWriter archivo = new FileWriter(path + nom);
        
    }



}
