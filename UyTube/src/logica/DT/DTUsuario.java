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
    private String canal;
    private List<DTValoracion> valoraciones;

    public DTUsuario(String nickname, String contrasenia, String nombre, String apellido, String email, Date fechaNac, String imagen, String canal) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen; 
        this.canal = canal;
    }

    public DTUsuario(Usuario u){
        this.nickname = u.getNickname();
        this.contrasenia = u.getContrasenia();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
        this.fechaNac = u.getFechaNac();
        this.imagen = u.getImagen();
        this.canal = u.getCanal().getNombre();
        this.seguidores = u.listarSeguidores();
        this.seguidos = u.listarSeguidos();
    }

    public DTUsuario(String facu95, String facundoBauza25, String facundo, String bauza_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getCanal() {
        return canal;
    }

    public List<DTValoracion> getValoraciones() {
        return valoraciones;
    }

    
    
    
    
}
