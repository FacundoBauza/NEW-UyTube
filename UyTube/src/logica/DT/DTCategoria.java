package logica.DT;

import logica.Categoria;

public class DTCategoria {
    private String nombre;

    public DTCategoria(String nombre) {
        this.nombre = nombre;
    }
    
    public DTCategoria(Categoria cat) {
        this.nombre = cat.getNombre();
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
