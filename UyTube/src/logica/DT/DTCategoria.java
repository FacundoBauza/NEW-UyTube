package logica.DT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Categoria;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTCategoria {
    private String nombre;
    
    // Debe tener un constructor vacío
    public DTCategoria() {
    }

    public DTCategoria(String nombre) {
        this.nombre = nombre;
    }
    
    public DTCategoria(Categoria cat) {
        this.nombre = cat.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
