package logica.DT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Valoracion;
import logica.Video;


public class DTVideo {
   
    private String nombre;
    private String descripcion;
    private String duracion;
    private Date fecha;
    private String url;
    private boolean privado;
    private String categoria;
    private List<DTComentario> comentarios;
    private List<DTValoracion> valoraciones;
    
    public DTVideo(){}

    public DTVideo(String nombre, String descripcion, String duracion, Date fecha, String url, boolean privado, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fecha = fecha;
        this.url = url;
        this.privado = privado;
        this.categoria = categoria;        
    }
    
    public DTVideo(Video v){
        
        this.nombre = v.getNombre();
        this.descripcion = v.getDescripcion();
        this.duracion = v.getDuracion();
        this.fecha = v.getFecha();
        this.url = v.getUrl();
        this.privado = v.isPrivado();
        this.categoria = v.getCategoria().getNombre();
        List<DTValoracion> valoraciones = new ArrayList();
        if (v.getValoraciones() != null)
        for (Valoracion val : v.getValoraciones()){
            DTValoracion valoracion = new DTValoracion(val);
            valoraciones.add(valoracion);
        }
        this.valoraciones = valoraciones;        
    }

    public List<DTValoracion> getValoraciones() {
        return valoraciones;
    }

    public String getCategoria() {
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

    public List<DTComentario> getComentarios() {
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setComentarios(List<DTComentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void setValoraciones(List<DTValoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }
    
    
    
}
