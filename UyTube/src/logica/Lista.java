package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import logica.DT.DTVideo;

@Entity
@Table(name="Lista")
public class Lista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private boolean porDefecto;
    private boolean privado;
    private Categoria categoria;
    
    @ManyToMany
    private List<Video> videos;

    public Lista() {
    }

    public Lista(String nombre, boolean porDefecto, boolean privado, Categoria categoria) {
        this.nombre = nombre;
        this.porDefecto = porDefecto;
        this.videos = new ArrayList();
        if (porDefecto == true){
            this.privado = true;
            this.categoria = null;
        }
        else{
            this.privado = privado;
            this.categoria = categoria;
        }
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

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Video> getVideos() {
        return videos;
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

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
    
    public void addVideo(Video video) {
        this.videos.add(video);
    }
    
    public void removeVideo(Video video) {
        this.videos.remove(video);
    }
    
    
    
    public ArrayList<String> listarVideosEnLista(){
        String nombre;
        Video v;
        ArrayList<String> videos = new ArrayList();
        Iterator it = this.videos.iterator();
        while(it.hasNext()){
            v = (Video) it.next();
            nombre = v.getNombre();
            videos.add(nombre);
        }
        return videos;
    }
    
    public Video buscarVideoEnLista(String nombre){
        for (logica.Video video : videos) {
            if(video.getNombre().equals(nombre))
                return video;
        }
        return null;       
    }
    
    
}
