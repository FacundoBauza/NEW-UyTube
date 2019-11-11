package logica.DT;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Comentario;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTComentario {
    private int id;
    private String texto;
    private Date fecha;
    private String usuario;
    private List<DTComentario> hijos;

    public DTComentario(String texto, String usuario){
        this.texto = texto;
        this.usuario = usuario;
    }
   
    public DTComentario(Comentario c) {
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

    public List<DTComentario> getHijos() {
        return hijos;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }
    
    
    
    
    
    
    
}
