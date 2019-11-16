package logica.DT;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Canal;

@XmlAccessorType(XmlAccessType.FIELD) //Define el modo en que se serializan los tipos definidos en XML
public class DTCanal {
    private String nombre;
    private String desc;
    private boolean privado;
    
    private List<DTVideo> videos;
    private List<DTLista> listas;

    // Debe tener un constructor vacío
    public DTCanal() {
    }
    
    public DTCanal(String nombre, String desc, boolean privado, List<DTVideo> videos, List<DTLista> listas) {
        this.nombre = nombre;
        this.desc = desc;
        this.privado = privado;
        this.videos = videos;
        this.listas = listas;
    }
    
    public DTCanal(Canal c) {
        this.nombre = c.getNombre();
        this.desc = c.getDesc();
        this.privado = c.isPrivado();
        //this.videos = c.getVideos();
        //this.listas = c.getListas();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isPrivado() {
        return privado;
    }

    public List<DTVideo> getVideos() {
        return videos;
    }

    public List<DTLista> getListas() {
        return listas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public void setVideos(List<DTVideo> videos) {
        this.videos = videos;
    }

    public void setListas(List<DTLista> listas) {
        this.listas = listas;
    }
    
    
}
