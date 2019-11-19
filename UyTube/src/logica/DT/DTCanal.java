package logica.DT;

import java.util.List;
import logica.Canal;

public class DTCanal {
    private String nombre;
    private String desc;
    private boolean privado;
    
    private List<DTVideo> videos;
    private List<DTLista> listas;

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

}
