package logica.DT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    
}
