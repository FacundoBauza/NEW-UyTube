package logica.DT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;



public class DTListaUsuario {
    private String usuario;
    private String lista;
    
    public DTListaUsuario(){}
    public DTListaUsuario(String usuario, String lista) {
        this.usuario = usuario;
        this.lista = lista;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getLista() {
        return lista;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    
}
