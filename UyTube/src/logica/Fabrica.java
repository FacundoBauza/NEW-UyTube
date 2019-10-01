package logica;

public class Fabrica {
    private static Sistema instancia;

    public static ISistema getInstance(){
        if (instancia == null){
            instancia = new Sistema();
        }
        return instancia;
}

}
