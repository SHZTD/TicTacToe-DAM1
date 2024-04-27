import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Joc {

    private char[] taulell;

    public char[] getTaulell() {
        return taulell;
    }

    private short torn;

    public short getTorn() {
        return torn;
    }

    public void NovaPartida(){
        throw new NotImplementedException();
    }

    public void jugar(short fila, String columna){
        throw new NotImplementedException();
    }

    public boolean jugadaGuanyadora(short fila, String columna){
        throw new NotImplementedException();
    }
}
