/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.ws.Endpoint;
import logica.DT.DTCanal;
import logica.DT.DTCategoria;
import logica.DT.DTComentario;
import logica.DT.DTLista;
import logica.DT.DTListaUsuario;
import logica.DT.DTSesion;
import logica.DT.DTUsuario;
import logica.DT.DTValoracion;
import logica.DT.DTVideo;
import logica.DT.DTVideoUsuario;
import logica.Fabrica;
import logica.ISistema;
import logica.Manejador;
import logica.Video;

/**
 *
 * @author Usuario
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    
    public Publicador(){}
    
//Operaciones las cuales quiero publicar
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://192.168.1.51:1234/publicador", this);   
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    //funciones del sistema
    @WebMethod
    public void altaUsuario(DTUsuario u, DTCanal c){
        ISistema s = null;
        s = Fabrica.getInstance();
        s.altaUsuario(u, c);
    }
   
    @WebMethod
    public DTUsuario consultaUsuario(String nickname){
        ISistema s = null;
        s = Fabrica.getInstance();
        return s.consultaUsuario(nickname);
    }
    
    @WebMethod
    public void modificarUsuario(String nickname, String contrasenia, String nombre, String apellido, Date fechaNac, String imagen, String nombreCanal, String DescCanal, boolean priv){
        ISistema s = null;
        s = Fabrica.getInstance();
        s.modificarUsuario(nickname, contrasenia, nombre, apellido, fechaNac, imagen, nombreCanal, DescCanal, priv);
    }
    
    @WebMethod
    public void altaVideo(DTVideo video, String usuario){
        ISistema s = null;
        s = Fabrica.getInstance();
        s.altaVideo(video, usuario);
    }
    
    @WebMethod
    public void modificarVideo (DTVideo video, String usuario, String nomVideo) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.modificarVideo(video, usuario, nomVideo);
    }
    
    @WebMethod
    public void altaLista(DTLista lista, String usuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.altaLista(lista, usuario);
    }
    
    @WebMethod
    public void altaListaPorDefecto(DTLista lista, String usuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.altaListaPorDefecto(lista, usuario);
    }
    
    @WebMethod
    public void modificarListaPart(String Usuario, String nombreLista, String categoria, Boolean privado) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.modificarListaPart(Usuario, nombreLista, categoria, privado);
    }
    
    @WebMethod
    public void agregarVideoAlista(String usuario, String video, String usuario2, String nombreLista) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.agregarVideoAlista(usuario, video, usuario2, nombreLista);
    }
    
    @WebMethod
    public void quitarVideoDeLista(String usuario, String video, String nombreLista) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.quitarVideoDeLista(usuario, video, nombreLista);
    }
    
    @WebMethod
    public DTLista consultaLista(String usuario, String nombreLista) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return s.consultaLista(usuario, nombreLista);
    }
    
    @WebMethod
    public void altaCategoria(DTCategoria categoria) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.altaCategoria(categoria);
    }
    
    @WebMethod
    public List<DTVideoUsuario> consultaVideosPorCategoria(String categoria) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.consultaVideosPorCategoria(categoria);
    }
    
    @WebMethod
    public List<DTListaUsuario> consultaListasPorCategoria(String categoria) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.consultaListasPorCategoria(categoria);
    }
    
    @WebMethod
    public DTVideo consultarVideo(String usuario, String video) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return s.consultarVideo(usuario, video);
    }
    
    @WebMethod
    public void comentarVideo(String usuario,DTComentario comentario,String video, int padre) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.comentarVideo(usuario, comentario, video, padre);
    }
    
    @WebMethod
    public void valorarVideo(String usuario,String video, DTValoracion valoracion ) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.valorarVideo(usuario, video, valoracion);
    }
    
    @WebMethod
    public void seguirUsuario(String nickSeguidor, String nickSeguido) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.seguirUsuario(nickSeguidor, nickSeguido);
    }
    
    @WebMethod
    public void dejarDeSeguirUsuario(String nickSeguidor, String nickSeguido) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.dejarDeSeguirUsuario(nickSeguidor, nickSeguido);
    }
    
    @WebMethod
    public List<String> listarVideos(String nickUsuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.listarVideos(nickUsuario);
    }
    
    @WebMethod
    public List<String> listarListas(String nickUsuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.listarListas(nickUsuario);
    }
    
    @WebMethod
    public List<String> listarMG(String usuario, String video) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.listarMG(usuario, video);
    }
    
    @WebMethod
    public List<String> listarNMG(String usuario, String video) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.listarNMG(usuario, video);
    }
    
    @WebMethod
    public List<DTLista> listasParticulares(String usuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.listasParticulares(usuario);
    }
    
    @WebMethod
    public List<String> listarVideosLista(String usuario, String lista) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (List)s.listarVideosLista(usuario, lista);
    }
    
    @WebMethod
    public DTSesion getUserSession(String identificador, String pass) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return s.getUserSession(identificador, pass);
    }
    
    @WebMethod
    public void bajaUsuario(String nickname) {
        ISistema s = null;
        s = Fabrica.getInstance();
        s.bajaUsuario(nickname);
    }
    
    // -------------- fin funciones sistema ------------------------
}
