package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="Comentario")
public class Comentario {
    public static int proxid = 1;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texto;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private Usuario usuario; 
    
    @OneToMany
    private List<Comentario> hijos;

    public Comentario() {
    }

    public Comentario(String texto, Usuario usuario) {
        this.id = proxid;
        this.texto = texto;
        this.usuario = usuario;
        this.fecha = new Date();
        this.hijos = new ArrayList<Comentario>();
        proxid++;
    }

    public int getId() {
        return id;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Comentario> getHijos() {
        return hijos;
    }

    public void addHijo (Comentario hijo) {
        this.hijos.add(hijo);
    }
    
    public Comentario buscarComentario (int id){
        for (Comentario c : hijos)
            if (c.getId() == id)
                return c;
            else 
                if (!c.getHijos().isEmpty())
                    return c.buscarComentario(id);
        return null;
    }       
    
}
