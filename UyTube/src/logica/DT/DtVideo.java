package logica.DT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Categoria;
import logica.Valoracion;
import logica.Video;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtVideo {
   
    private String nombre;
    private String descripcion;
    private String duracion;
    private Date fecha;
    private String url;
    private boolean privado;
    private Categoria categoria;
    private List<DtComentario> comentarios;
    private List<DtValoracion> valoraciones;
    
    public DtVideo(){}
    
    public void setear (String nombre, String descripcion, String duracion, Date fecha, String url, boolean privado, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fecha = fecha;
        this.url = url;
        this.privado = privado;
        this.categoria = categoria;        
    }

    public DtVideo(String nombre, String descripcion, String duracion, Date fecha, String url, boolean privado, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fecha = fecha;
        this.url = url;
        this.privado = privado;
        this.categoria = categoria;        
    }
    
    public DtVideo(Video v){
        
        this.nombre = v.getNombre();
        this.descripcion = v.getDescripcion();
        this.duracion = v.getDuracion();
        this.fecha = v.getFecha();
        this.url = v.getUrl();
        this.privado = v.isPrivado();
        this.categoria = v.getCategoria();
        List<DtValoracion> valoraciones = new ArrayList();
        if (v.getValoraciones() != null)
        for (Valoracion val : v.getValoraciones()){
            DtValoracion valoracion = new DtValoracion(val);
            valoraciones.add(valoracion);
        }
        this.valoraciones = valoraciones;        
    }

    public List<DtValoracion> getValoraciones() {
        return valoraciones;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getUrl() {
        return url;
    }

    public boolean isPrivado() {
        return privado;
    }

    public List<DtComentario> getComentarios() {
        return comentarios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setComentarios(List<DtComentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void setValoraciones(List<DtValoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }
    
    
    
}
