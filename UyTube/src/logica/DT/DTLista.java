package logica.DT;

import java.util.ArrayList;
import java.util.List;
import logica.Lista;

public class DTLista {
    private String nombre;
    private boolean porDefecto;
    private boolean privado;
    private String categoria;

    public DTLista(String nombre, boolean porDefecto, boolean privado, String categoria) {
        this.nombre = nombre;
        this.porDefecto = porDefecto;
        this.privado = privado;
        this.categoria = categoria;
    }

    public DTLista(Lista l) {
        this.nombre = l.getNombre();
        this.porDefecto = l.isPorDefecto();
        this.privado = l.isPrivado();
        this.categoria = l.getCategoria().getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPorDefecto() {
        return porDefecto;
    }

    public boolean isPrivado() {
        return privado;
    }

    public String getCategoria() {
        return categoria;
    }
    
    
}
