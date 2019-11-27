package logica.DT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Categoria;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategoria {
    private String nombre;

    public DtCategoria(){
    }
    public DtCategoria(String nombre) {
        this.nombre = nombre;
    }
    
    public DtCategoria(Categoria cat) {
        this.nombre = cat.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
