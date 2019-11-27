package logica.DT;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Lista;


@XmlAccessorType(XmlAccessType.FIELD)
public class DtLista {
    private String nombre;
    private boolean porDefecto;
    private boolean privado;
    private String categoria;
    
    public DtLista (){}
    
    public void setear(String nombre, boolean porDefecto, boolean privado, String categoria) {
        this.nombre = nombre;
        this.porDefecto = porDefecto;
        this.privado = privado;
        this.categoria = categoria;
    }
    
    public DtLista(String nombre, boolean porDefecto, boolean privado, String categoria) {
        this.nombre = nombre;
        this.porDefecto = porDefecto;
        this.privado = privado;
        this.categoria = categoria;
    }

    public DtLista(Lista l) {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPorDefecto(boolean porDefecto) {
        this.porDefecto = porDefecto;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
