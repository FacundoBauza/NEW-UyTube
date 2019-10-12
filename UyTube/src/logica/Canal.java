package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import logica.DT.DTLista;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Canal")
public class Canal {
    @Id   
    private String nombre;
    
    private String descripcion;
    
    private boolean privado;
    
    @OneToMany
    private List<Video> videos;
    
    @OneToMany
    private List<Lista> listas;

    public Canal(String nombre, String desc, boolean privado, List<Lista> listas) {
        this.nombre = nombre;
        this.descripcion = desc;
        this.privado = privado;
        this.videos = new ArrayList();
        this.listas = listas;
    }
    
    public Canal() {
        
    }

    public Canal(String nombre, String desc, boolean privado, List<Video> videos, List<Lista> listas) {
        this.nombre = nombre;
        this.descripcion = desc;
        this.privado = privado;
        this.videos = new ArrayList();
        this.listas = listas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return descripcion;
    }

    public void setDesc(String desc) {
        this.descripcion = desc;
    }

    public boolean isPrivado() {
        return privado;
    }
    
    public boolean getPrivado() {
        return privado;
    }
    
    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }

    public List<Lista> getListas() {
        return listas;
    }

    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }
    
    public void addLista(Lista lista) {
        this.listas.add(lista);
    }
    
    public Video buscarVideo(String nombre){
        for (logica.Video video : videos) {
            if(video.getNombre().equals(nombre))
                return video;
        }
        return null;       
    }
    
    
    
    public List<DTLista> listasParticulares(){
        DTLista lista;
        Lista l;
        List<DTLista> listaPart = new ArrayList();
        Iterator it = this.listas.iterator();
        while(it.hasNext()){
            l = (Lista) it.next();
            if(l.isPorDefecto()== false){
                lista = new DTLista(l);
                listaPart.add(lista);
            }
        }
        return listaPart;
    }
    
    public ArrayList<String> listarVideos(){
        String nombre;
        Video v;
        ArrayList<String> videos = new ArrayList();
        //System.out.print("La cantidad de videos es: " + videos.size());
        Iterator it = this.videos.iterator();
        while(it.hasNext()){
            v = (Video) it.next();
            nombre = v.getNombre();
            videos.add(nombre);
        }
        return videos;
    }
    
    public ArrayList<String> listarListas(){
        String nombre;
        Lista lista;
        ArrayList<String> listas = new ArrayList();
        Iterator it = this.listas.iterator();
        while(it.hasNext()){
            lista = (Lista) it.next();
            nombre = lista.getNombre();
            listas.add(nombre);
        }
        return listas;
    }
    
    
    public Lista buscarLista(String nombre){
        for (logica.Lista lista : listas) {
            if(lista.getNombre().equals(nombre))
                return lista;
        }
        return null;
               
    }
    
    
}
