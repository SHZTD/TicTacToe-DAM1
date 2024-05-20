package Juego;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TUI {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.print(
                """
                        ╔══════════════════════════╗
                        ║ Benvingut a tic tac toe! ║
                        ║------------------------- ║
                        ║ 1. Nova partida          ║
                        ║------------------------- ║
                        ║ 2. Carregar partida      ║
                        ║------------------------- ║
                        ║ 3. Configuració          ║
                        ║------------------------- ║
                        ║ 4. Sortir                ║
                        ╚══════════════════════════╝
                        Selecciona l'opció que vols: """);

        return sc.nextInt();
    }

    /*
    Lo que hace este metodo se encarga de imprimir el estado del tablero y de mostrar de quien es el turno actual.

    Esto se hace de la siguiente manera: Primero hacemos un bucle niado para recorrer cada posicion del tablero.
    Después se imprime cada posición del tablero.

    Por último se utiliza la variable jugador para determinar el turno actual
     */
    public void mostrarTaullel(char [][] taulell, int torn){
        for(int i=0; i < 3 ; i++){
            for(int j=0; j < 3; j++){
                System.out.print(taulell[i][j]+ " ");
            }
            System.out.println();
        }

        String jugador;
        if (torn == 0){
            jugador = "x";
        }else {
            jugador = "o";
        }

        System.out.println("Torn del jugador: " + jugador );
    }


    //Este metodo se encarga de pedir y almanecar donde quiere poner el jugador la ficha
    public int[] recollirJugada(){

        System.out.println("Introdueix la fila: ");
        int fila= sc.nextInt();

        System.out.println("Introdueix la columna: ");
        int columna= sc.nextInt();

        return new int[]{fila, columna};
    }

    //Este metodo sirve para mostrar un mensaje de que jugador ha ganado la partida
    public void fiDePartida(int guanyador){

        System.out.println("El guanyador de la partida es: " + (guanyador == 0 ? "o" : "x") + "!");
    }

    //Este metodo lo que hace mostar el menu dentro del menu de configuración y devuelve la opción que elige el usuario
    public int mostrarConfiguracio()
    {
        System.out.print(
                """
                        ╔══════════════════════════╗
                        ║ Configuració             ║
                        ║------------------------- ║
                        ║ 1. Configurar tamany     ║
                        ║------------------------- ║
                        ║ 2. Enrere                ║
                        ╚══════════════════════════╝
                        Selecciona l'opció que vols: """);
        return sc.nextInt();
    }

    //Este metodo se encarga de mostrar diferentes escenarios dependiendo de la elección del usuario
    public void gestinarConfiguracio(){

        while(true){
            switch (mostrarConfiguracio()){
                case 1:
                    configurarTamany();
                    break;
                case 2:
                    //El return es para volver al Menu Principal
                    return;
                default:
                    break;
            }
        }
    }

    //Simplemente, pide al usuario el tamaño que desea y lo lee.
    public int demanarTamany(){

        System.out.println("Selecciona el tamany que vols del taullel. Recorda que ha de ser entre 3 i 10 : ");
        return sc.nextInt();

    }

    /*
    Este metodo se encarga de configurar el tamaño del tablero.

    Esto lo hace de la siguiente manera:
    Primero pide al usuario el nuevo tamaño del tablero, luego verifica que este dentro del limite establecido.
    Si es asi guarda el valor dicho por el usuario en un fichjero llamado "config.txt".
     */
    public void configurarTamany(){
        //llamada de metodo para obtener el tamaño del tablero que el usuario quiere
        int midaTaulell = demanarTamany();
        //verifica si esta dentro del limite
        if(midaTaulell >=3 && midaTaulell <=10){
            try{
                FileWriter tamany = new FileWriter("config.txt"); // Intancias el archivo
                tamany.write(Integer.toString(midaTaulell)); //Escribe el tamaño en el archivo
                tamany.close(); //cierra el archivo
            }
            catch (IOException e) {
                // Si hay una excepción en el bloque anterior salta este texto
                System.out.println("Error en la configuració de la mida ");
            }
        }
        else {
            System.out.println("La mida del taulell ha de ser entre 3 i 10");
        }
    }

    public void llistarPartides(File[] numPartides) {
        System.out.println("Selecciona la partida que vols");
        for (int i = 0; i < numPartides.length; i++) {
            System.out.print("[ " + i + " ] " + numPartides[i].getName() + "\n");
        }
        int select = sc.nextInt();
    }
}
