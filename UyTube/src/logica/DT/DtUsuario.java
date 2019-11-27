package logica.DT;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import logica.Canal;
import logica.Usuario;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtUsuario {
    private String nickname;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNac;
    private String imagen;
    private List<String> seguidores;
    private List<String> seguidos;
    private DtCanal canal;
    private List<DtValoracion> valoraciones;
    private boolean Eliminado;

    public DtUsuario(){}
    
    public void setear (String nickname, String contrasenia, String nombre, String apellido, String email, Date fechaNac, String imagen, DtCanal canal, boolean Eliminado) {
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
    
    public DtUsuario(String nickname, String contrasenia, String nombre, String apellido, String email, Date fechaNac, String imagen, DtCanal canal, boolean Eliminado) {
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

    public DtUsuario(Usuario u){
        this.nickname = u.getNickname();
        this.contrasenia = u.getContrasenia();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
        this.fechaNac = u.getFechaNac();
        this.imagen = u.getImagen();
        this.canal = new DtCanal (u.getCanal());
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

    public DtCanal getCanal() {
        return canal;
    }

    public List<DtValoracion> getValoraciones() {
        return valoraciones;
    }

    public boolean isEliminado() {
        return Eliminado;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setSeguidores(List<String> seguidores) {
        this.seguidores = seguidores;
    }

    public void setSeguidos(List<String> seguidos) {
        this.seguidos = seguidos;
    }

    public void setCanal(DtCanal canal) {
        this.canal = canal;
    }

    public void setValoraciones(List<DtValoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    
    
    
    
}
