package logica.DT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTListaUsuario {
    private String usuario;
    private String lista;

    // Debe tener un constructor vacío
    public DTListaUsuario() {
    }
    
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
