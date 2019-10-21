package logica.DT;

import java.util.Date;
import java.util.List;
import logica.Canal;
import logica.Usuario;

public class DTUsuario {
    private String nickname;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String imagen;
    private List<String> seguidores;
    private List<String> seguidos;
    private DTCanal canal;
    private List<DTValoracion> valoraciones;
    private boolean Eliminado;

    public DTUsuario(String nickname, String contrasenia, String nombre, String apellido, String email, Date fechaNac, String imagen, DTCanal canal) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen; 
        this.canal = canal;
        this.Eliminado = Eliminado;
    }

    public DTUsuario(Usuario u){
        this.nickname = u.getNickname();
        this.contrasenia = u.getContrasenia();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
        this.fechaNac = u.getFechaNac();
        this.imagen = u.getImagen();
        this.canal = new DTCanal (u.getCanal());
        this.seguidores = u.listarSeguidores();
        this.seguidos = u.listarSeguidos();
        this.Eliminado = u.getEliminado();
    }

    public boolean getEliminado() {
        return Eliminado;
    }

    public void setEliminado(boolean Eliminado) {
        this.Eliminado = Eliminado;
    }

    

    public String getNickname() {
        return nickname;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public String getImagen() {
        return imagen;
    }

    public List<String> getSeguidores() {
        return seguidores;
    }
    
    public List<String> getSeguidos() {
        return seguidos;
    }

    public DTCanal getCanal() {
        return canal;
    }

    public List<DTValoracion> getValoraciones() {
        return valoraciones;
    }

    
    
    
    
}
