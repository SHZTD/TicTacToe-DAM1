package Juego;


public class Joc {

    private char[][] taulell;

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
    public void jugar(short fila, short columna) {
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
        int contador=0;

        for(int i=0; i < 3; i++){
            if (getTaulell()[fila][i]=='o') {
               contador++;
               if (contador==3){
                   return true;
               }
               else{
                   return false;
               }
            }
        }



        return false;

    }
}
