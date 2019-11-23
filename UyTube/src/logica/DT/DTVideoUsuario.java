package logica.DT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


public class DTVideoUsuario {
    private String usuario;
    private String video;

    public DTVideoUsuario(){}
    
    public DTVideoUsuario(String usuario, String video) {
        this.usuario = usuario;
        this.video = video;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getVideo() {
        return video;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    
    
}
