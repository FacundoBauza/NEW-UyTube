
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import logica.DT.DTCanal;
import logica.DT.DTSesion;
import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    private String nickname;
    
    private String contrasenia;
    private String nombre;
    private String apellido;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    private String imagen;
    @OneToOne
    private Canal canal;
    private boolean Eliminado;
    
    @OneToMany
    private List<Usuario> seguidos;
    
    @OneToMany
    private List<Usuario> seguidores;
    
    @OneToMany
    private List<Valoracion> valoraciones;

    public Usuario() {
        
    }
    
    public Usuario(String nickname, String contrasenia, String nombre, String apellido, String email, Date fechaNac, String imagen, Canal canal, boolean Eliminado) {
        this.nickname = nickname;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.imagen = imagen;
        this.seguidores = new ArrayList();
        this.seguidos = new ArrayList();
        this.canal = canal;
        this.valoraciones = new ArrayList();
        this.Eliminado = Eliminado;
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

    public List<Usuario> getSeguidores() {
        return seguidores;
    }
    
    public List<Usuario> getSeguidos() {
        return seguidores;
    }

    public Canal getCanal() {
        return canal;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }
    
    public DTSesion getSesion(){
        DTSesion sesion = new DTSesion(this.getNickname(), this.getContrasenia());
        return sesion;
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
    
    public void addSeguidor(Usuario seguidor) {
        this.seguidores.add(seguidor);
    }
    
    public void removeSeguidor(Usuario seguidor) {
        this.seguidores.remove(seguidor);
      
    }
    
    public void addSeguido(Usuario seguido) {
        this.seguidos.add(seguido);
    }
    
    public void removeSeguido(Usuario seguido) {
        this.seguidos.remove(seguido);
    }
    
    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public void addValoracion(Valoracion valoracion) {
        this.valoraciones.add(valoracion);
    }
    
    public ArrayList<String> listarSeguidores(){
        String nickname;
        Usuario u;
        ArrayList<String> listaSeg = new ArrayList();
        Iterator it = this.seguidores.iterator();
        while(it.hasNext()){
            u = (Usuario) it.next();
            nickname = u.getNickname();
            listaSeg.add(nickname);
        }
        return listaSeg;
    }
    
    public ArrayList<String> listarSeguidos(){
        String nickname;
        Usuario u;
        ArrayList<String> listaSeg = new ArrayList();
        Iterator it = this.seguidos.iterator();
        while(it.hasNext()){
            u = (Usuario) it.next();
            nickname = u.getNickname();
            listaSeg.add(nickname);
        }
        return listaSeg;
    }
    
    
    
}
