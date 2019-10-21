package logica;

import java.util.Date;
import java.util.List;
import logica.DT.*;

public interface ISistema {
    public abstract void altaUsuario(DTUsuario u, DTCanal c);
    public abstract void altaVideo(DTVideo video, String usuario);
    public abstract void altaCategoria(DTCategoria categoria);
    public abstract void altaLista(DTLista lista, String usuario);
    public abstract void altaListaPorDefecto(DTLista lista, String usuario);
    public abstract void comentarVideo(String usuario,DTComentario comentario,String video, int padre);
    public abstract void valorarVideo(String usuario,String video, DTValoracion valoracion );
    public abstract void modificarVideo (DTVideo video, String usuario, String nomVideo);
    public abstract void modificarUsuario(String nickname, String contrasenia, String nombre, String apellido, Date fechaNac, String imagen, String nombreCanal, String DescCanal, boolean priv);
    public abstract void modificarListaPart(String usuario, String nombreLista, String categoria, Boolean privado);
    public abstract void agregarVideoAlista(String usuario, String video, String usuario2, String nombreLista);
    public abstract void quitarVideoDeLista(String usuario, String video, String nombreLista);
    public abstract DTVideo consultarVideo(String usuario, String video);
    public abstract DTLista consultaLista(String usuario, String nombreLista);
    public abstract DTUsuario consultaUsuario(String nickname);
    public abstract List<String> listarVideos(String nickUsuario);
    public abstract List<String> listarListas(String nickUsuario);
    public abstract List<DTLista> listasParticulares(String usuario);
    public abstract List<String> listarVideosLista(String usuario, String lista);
    public abstract void seguirUsuario(String nickSeguidor, String nickSeguido);
    public abstract void dejarDeSeguirUsuario(String nickSeguidor, String nickSeguido);
    public abstract List<DTListaUsuario> consultaListasPorCategoria(String categoria);
    public abstract List<DTVideoUsuario> consultaVideosPorCategoria(String categoria);
    public abstract List<String> listarMG(String usuario, String video);
    public abstract List<String> listarNMG(String usuario, String video);

    public DTSesion getUserSession(String nickname, String contrasenia);

}

