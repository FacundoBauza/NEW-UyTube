package logica.DT;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Canal;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCanal {
    private String nombre;
    private String desc;
    private boolean privado;
    private List<DtVideo> videos;
    private List<DtLista> listas;
    
    public DtCanal(){
    }
    
    public void setear (String nombre, String desc, boolean privado) {
        this.nombre = nombre;
        this.desc = desc;
        this.privado = privado;
        this.videos = null;
        this.listas = null;
    }

    public DtCanal(String nombre, String desc, boolean privado, List<DtVideo> videos, List<DtLista> listas) {
        this.nombre = nombre;
        this.desc = desc;
        this.privado = privado;
        this.videos = videos;
        this.listas = listas;
    }
    
    public DtCanal(Canal c) {
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

    public List<DtVideo> getVideos() {
        return videos;
    }

    public List<DtLista> getListas() {
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

    public void setVideos(List<DtVideo> videos) {
        this.videos = videos;
    }

    public void setListas(List<DtLista> listas) {
        this.listas = listas;
    }
    

}
