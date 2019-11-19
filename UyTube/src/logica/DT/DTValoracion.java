package logica.DT;

import logica.Valoracion;

public class DTValoracion {
    private boolean meGusta;
    private String usuario;
    private String video;

    public DTValoracion(boolean meGusta, String usuario, String video) {
        this.meGusta = meGusta;
        this.usuario = usuario;
        this.video = video;
    }

    public DTValoracion(Valoracion v) {
        this.meGusta = v.isMeGusta();
        this.usuario = v.getUsuario().getNickname();
        this.video = v.getVideo().getNombre();
    }
    
    public boolean isMeGusta() {
        return meGusta;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getVideo() {
        return video;
    }
    
    
}
