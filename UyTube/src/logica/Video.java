package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="Video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String duracion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String url;
    private boolean privado;
    private Categoria categoria;
    
    @OneToMany
    private List<Comentario> comentarios;
    @OneToMany
    private List<Valoracion> valoraciones;

    public Video(String nombre, String descripcion, String duracion, Date fecha, String url, boolean privado, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fecha = fecha;
        this.url = url;
        this.privado = privado;
        this.categoria = categoria;
        this.comentarios = new ArrayList();
        this.valoraciones = new ArrayList();
    }
    
    public Video() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }
    
    public void addValoracion(Valoracion valoracion) {
        this.valoraciones.add(valoracion);
    }
    
    public Comentario buscarComentario (int id){
        for (Comentario c : comentarios)
            if (c.getId() == id)
                return c;
            else 
                return c.buscarComentario(id);
        return null;
    } 
    
    
    public ArrayList<String> listaMG(){
        String nickname;
        Valoracion v;
        ArrayList<String> listaMG = new ArrayList();
        Iterator it = this.valoraciones.iterator();
        while(it.hasNext()){
            v = (Valoracion) it.next();
            if(v.isMeGusta()== true){
               nickname = v.getUsuario().getNickname();
               listaMG.add(nickname);
            }
        }
        return listaMG;
    }
    
    public ArrayList<String> listaNMG(){
        String nickname;
        Valoracion v;
        ArrayList<String> listaNMG = new ArrayList();
        Iterator it = this.valoraciones.iterator();
        while(it.hasNext()){
            v = (Valoracion) it.next();
            if(v.isMeGusta()== false){
               nickname = v.getUsuario().getNickname();
               listaNMG.add(nickname);
            }
        }
        return listaNMG;
    }

    public ArrayList<Integer> listarComentarios(){
        Integer id;
        Comentario c;
        ArrayList<Integer> listaComentarios = new ArrayList<Integer>();
        Iterator iter = comentarios.iterator();
        while(iter.hasNext()){
            c = (Comentario) iter.next();
            id = c.getId();
            listaComentarios.add(id);   
        }
         return listaComentarios;
    }        
    
    
    
    
    
    
}   

   

