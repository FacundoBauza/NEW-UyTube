package logica.DT;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Comentario;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtComentario {
    private int id;
    private String texto;
    private Date fecha;
    private String usuario;
    private List<DtComentario> hijos;

    public DtComentario(){
    }
    
    public void setear (String texto, String usuario){
        this.texto = texto;
        this.usuario = usuario;
    }
    
    public DtComentario(String texto, String usuario){
        this.texto = texto;
        this.usuario = usuario;
    }
   
    public DtComentario(Comentario c) {
        this.id = c.getId();
        this.texto = c.getTexto();
        this.fecha = c.getFecha();
        this.usuario = c.getUsuario().getNickname();
        //this.hijos = c.getHijos();
    }

    public String getTexto() {
        return texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<DtComentario> getHijos() {
        return hijos;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setHijos(List<DtComentario> hijos) {
        this.hijos = hijos;
    }
    
    
    
    
    
    
    
}
