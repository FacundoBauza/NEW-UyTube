package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Valoracion")
public class Valoracion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean meGusta;
    private Usuario usuario;
    private Video video;

    public Valoracion(boolean meGusta, Usuario usuario, Video video) {
        this.meGusta = meGusta;
        this.usuario = usuario;
        this.video = video;
    }

    public Valoracion() {
        
    }
    
    public boolean isMeGusta() {
        return meGusta;
    }

    public void setMeGusta(boolean meGusta) {
        this.meGusta = meGusta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }


}