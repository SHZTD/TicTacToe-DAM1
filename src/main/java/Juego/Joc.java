package Juego;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

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
    public void jugar(short fila, short columna){
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
        contador=0;
        for (int i = 0; i < 3; i++) {
            if (getTaulell()[i][i] == jugador) {
                contador++;
            }
        }

        if (contador == 3) {
            return true;
        }


        contador=0;
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

    // logica de gestio de fitxers a FULL

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
        File partides = new File(Joc.SAVEDGAMES);
        if (partides.exists()) {
            // instancia i llista si existeixen partides, sino res.
            File[] arxius = partides.listFiles();
            if (arxius.length != 0) {
               return arxius;
            }
        }

        return new File[0];
    }

    public void carregarPartida(int partida) {

    }

    public int llegeixTamany() throws FileNotFoundException {
        // busca el arxiu config
        File tamany = new File("config.txt");
        // llegeix el contingut del arxiu amb l'escaner
        Scanner sc = new Scanner(tamany);
        // variable on guardarem el valor del taulell
        int j = 0;
        // si el codi te una linia que es un numero (considerem que no sera string)
        if (sc.hasNextLine()) {
            j = sc.nextInt(); // guarda el int
            sc.close();
            return j;
        } else {
            j = 3; // significa que no hi ha res o no es un numero
            sc.close();
            return j;
        }
    }

}
