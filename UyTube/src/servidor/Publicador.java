/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.ws.Endpoint;
import logica.Categoria;
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
import logica.Lista;
import logica.Manejador;
import logica.Usuario;
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
    public ArrayList<DTVideoUsuario> consultaVideosPorCategoria(String categoria) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.consultaVideosPorCategoria(categoria);
    }
    
    @WebMethod
    public ArrayList<DTListaUsuario> consultaListasPorCategoria(String categoria) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.consultaListasPorCategoria(categoria);
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
    public ArrayList<String> listarVideos(String nickUsuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.listarVideos(nickUsuario);
    }
    
    @WebMethod
    public ArrayList<String> listarListas(String nickUsuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.listarListas(nickUsuario);
    }
    
    @WebMethod
    public ArrayList<String> listarMG(String usuario, String video) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.listarMG(usuario, video);
    }
    
    @WebMethod
    public ArrayList<String> listarNMG(String usuario, String video) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.listarNMG(usuario, video);
    }
    
    @WebMethod
    public ArrayList<DTLista> listasParticulares(String usuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.listasParticulares(usuario);
    }
    
    @WebMethod
    public ArrayList<String> listarVideosLista(String usuario, String lista) {
        ISistema s = null;
        s = Fabrica.getInstance();
        return (ArrayList)s.listarVideosLista(usuario, lista);
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

    
    // funciones manejador 
    @WebMethod
    public ArrayList<Video> getVideos() {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.getVideos();
    }
    
    @WebMethod
    public ArrayList<DTUsuario> getUsuarios() {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.getUsuarios();
    }
    
    @WebMethod
    public ArrayList<DTCategoria> getCategorias() {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.getCategorias();
    }
    
    @WebMethod
    public ArrayList<String> getListasPorDefecto() {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.getListasPorDefecto();
    }
    
    @WebMethod
    public void addUsuario(Usuario usu) {
        Manejador m = Manejador.getinstance();
        m.addUsuario(usu);
    }
    
    @WebMethod
    public void addCategoria (Categoria cat) {
        Manejador m = Manejador.getinstance();
        m.addCategoria(cat);
    }
    
    @WebMethod
    public void addLista (Lista lista, String Usuario) {
        Manejador m = Manejador.getinstance();
        m.addLista(lista, Usuario);
    }
    
    @WebMethod
    public Usuario buscarUsuario(String nickname) {
        Manejador m = Manejador.getinstance();
        return m.buscarUsuario(nickname);
    }
    
    @WebMethod
    public ArrayList<Lista> getListas(String nickname) {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.getListas(nickname);
    }
    
    @WebMethod
    public ArrayList<Lista> getAllListas() {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.getAllListas();
    }
    
    @WebMethod
    public Categoria buscarCategoria(String cat) {
        Manejador m = Manejador.getinstance();
        return m.buscarCategoria(cat);
    }
    
    @WebMethod
    public Lista buscarLista(String nombre, String nickname) {
        Manejador m = Manejador.getinstance();
        return m.buscarLista(nombre, nickname);
    }
    
    @WebMethod
    public ArrayList<String> listarCategorias() {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.listarCategorias();
    }
    
    @WebMethod
    public ArrayList<String> listarVidesPorUsuario(String Usuario) {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.listarVidesPorUsuario(Usuario);
    }
    
    @WebMethod
    public ArrayList<String> listarUsuarios() {
        Manejador m = Manejador.getinstance();
        return (ArrayList)m.listarUsuarios();
    }
    
    @WebMethod
    public Usuario obtenerUsuarioPorMail(String mail) {
        Manejador m = Manejador.getinstance();
        return m.obtenerUsuarioPorMail(mail);
    }
    
    @WebMethod
    public Usuario obtenerUsuarioPorNickname(String nickname) {
        Manejador m = Manejador.getinstance();
        return m.obtenerUsuarioPorNickname(nickname);
    }
    
    @WebMethod
    public boolean nicknameLibre(String nickname) {
        Manejador m = Manejador.getinstance();
        return m.nicknameLibre(nickname);
    }
    
    @WebMethod
    public boolean mailLibre(String mail) {
        Manejador m = Manejador.getinstance();
        return m.mailLibre(mail);
    }
    
    @WebMethod
    public boolean nombreListaLibre(String nombreLista) {
        Manejador m = Manejador.getinstance();
        return m.nombreListaLibre(nombreLista);
    }
    
    @WebMethod
    public boolean nombreCategoriaLibre(String nombreCategoria) {
        Manejador m = Manejador.getinstance();
        return m.nombreCategoriaLibre(nombreCategoria);
    }
    
    @WebMethod
    public DTUsuario getUserData(String identificador) {
        Manejador m = Manejador.getinstance();
        return m.getUserData(identificador);
    }
    
    // -------- fin funciones manejador
    
}
