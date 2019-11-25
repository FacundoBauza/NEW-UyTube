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
import logica.*;
import logica.DT.*;
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
         endpoint = Endpoint.publish("http://localhost:1234/publicador", this);   //ipkuki 192.168.1.52
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    
    //funciones del sistema
    @WebMethod
    public void altaUsuario(DTUsuario u, DTCanal c){
        
        ISistema s = new Sistema();
        s.altaUsuario(u, c);
    }
   
    @WebMethod
    public DTUsuario consultaUsuario(String nickname){
        ISistema s = new Sistema();
        return s.consultaUsuario(nickname);
    }
    
    @WebMethod
    public void modificarUsuario(String nickname, String contrasenia, String nombre, String apellido, Date fechaNac, String imagen, String nombreCanal, String DescCanal, boolean priv){
        ISistema s = new Sistema();
        s.modificarUsuario(nickname, contrasenia, nombre, apellido, fechaNac, imagen, nombreCanal, DescCanal, priv);
    }
    
    @WebMethod
    public void altaVideo(DTVideo video, String usuario){
        ISistema s = new Sistema();
        
        s.altaVideo(video, usuario);
    }
    
    @WebMethod
    public void modificarVideo (DTVideo video, String usuario, String nomVideo) {
        ISistema s = new Sistema();
        s.modificarVideo(video, usuario, nomVideo);
    }
    
    @WebMethod
    public void altaLista(DTLista lista, String usuario) {
        ISistema s = new Sistema();
        s.altaLista(lista, usuario);
    }
    
    @WebMethod
    public void altaListaPorDefecto(DTLista lista, String usuario) {
        ISistema s = new Sistema();
        s.altaListaPorDefecto(lista, usuario);
    }
    
    @WebMethod
    public void modificarListaPart(String Usuario, String nombreLista, String categoria, Boolean privado) {
        ISistema s = new Sistema();
        s.modificarListaPart(Usuario, nombreLista, categoria, privado);
    }
    
    @WebMethod
    public void agregarVideoAlista(String usuario, String video, String usuario2, String nombreLista) {
        ISistema s = new Sistema();
        s.agregarVideoAlista(usuario, video, usuario2, nombreLista);
    }
    
    @WebMethod
    public void quitarVideoDeLista(String usuario, String video, String nombreLista) {
        ISistema s = new Sistema();
        s.quitarVideoDeLista(usuario, video, nombreLista);
    }
    
    @WebMethod
    public DTLista consultaLista(String usuario, String nombreLista) {
        ISistema s = new Sistema();
        return s.consultaLista(usuario, nombreLista);
    }
    
    @WebMethod
    public void altaCategoria(DTCategoria categoria) {
        ISistema s = new Sistema();
        s.altaCategoria(categoria);
    }
    
    @WebMethod
    public ArrayList<DTVideoUsuario> consultaVideosPorCategoria(String categoria) {
        ISistema s = new Sistema();
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
        ISistema s = new Sistema();
        return s.consultarVideo(usuario, video);
    }
    
    @WebMethod
    public void comentarVideo(String usuario,DTComentario comentario,String video, int padre) {
        ISistema s = new Sistema();
        s.comentarVideo(usuario, comentario, video, padre);
    }
    
    @WebMethod
    public void valorarVideo(String usuario,String video, DTValoracion valoracion ) {
        ISistema s = new Sistema();
        s.valorarVideo(usuario, video, valoracion);
    }
    
    @WebMethod
    public void seguirUsuario(String nickSeguidor, String nickSeguido) {
        ISistema s = new Sistema();
        s.seguirUsuario(nickSeguidor, nickSeguido);
    }
    
    @WebMethod
    public void dejarDeSeguirUsuario(String nickSeguidor, String nickSeguido) {
        ISistema s = new Sistema();
        s.dejarDeSeguirUsuario(nickSeguidor, nickSeguido);
    }
    
    @WebMethod
    public ArrayList<String> listarVideos(String nickUsuario) {
        ISistema s = new Sistema();
        return (ArrayList)s.listarVideos(nickUsuario);
    }
    
    @WebMethod
    public ArrayList<String> listarListas(String nickUsuario) {
        ISistema s = new Sistema();
        return (ArrayList)s.listarListas(nickUsuario);
    }
    
    @WebMethod
    public ArrayList<String> listarMG(String usuario, String video) {
        ISistema s = new Sistema();
        return (ArrayList)s.listarMG(usuario, video);
    }
    
    @WebMethod
    public ArrayList<String> listarNMG(String usuario, String video) {
        ISistema s = new Sistema();
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
        ISistema s = new Sistema();
        return (ArrayList)s.listarVideosLista(usuario, lista);
    }
    
    @WebMethod
    public DTSesion getUserSession(String identificador, String pass) {
        ISistema s = new Sistema();
        return s.getUserSession(identificador, pass);
        
    }
    
    @WebMethod
    public void bajaUsuario(String nickname) {
        ISistema s = new Sistema();
        s.bajaUsuario(nickname);
    }
    
    // -------------- fin funciones sistema ------------------------

    
    // ------------- funciones manejador  ------------------------
    @WebMethod
    public ArrayList<Video> getVideos() {
        
        Manejador m = new Manejador();
        return (ArrayList)m.getVideos();
    }
    
    @WebMethod
    public ArrayList<DTUsuario> getUsuarios() {
        Manejador m = new Manejador();
        return (ArrayList)m.getUsuarios();
    }
    
    @WebMethod
    public ArrayList<DTCategoria> getCategorias() {
        Manejador m = new Manejador();
        return (ArrayList)m.getCategorias();
    }
    
    @WebMethod
    public ArrayList<String> getListasPorDefecto() {
        Manejador m = new Manejador();
        return (ArrayList)m.getListasPorDefecto();
    }
    
    @WebMethod
    public void addUsuario(Usuario usu) {
        Manejador m = new Manejador();
        m.addUsuario(usu);
    }
    
    @WebMethod
    public void addCategoria (Categoria cat) {
        Manejador m = new Manejador();
        m.addCategoria(cat);
    }
    
    @WebMethod
    public void addLista (Lista lista, String Usuario) {
        Manejador m = new Manejador();
        m.addLista(lista, Usuario);
    }
    
    @WebMethod
    public Usuario buscarUsuario(String nickname) {
        Manejador m = new Manejador();
        return m.buscarUsuario(nickname);
    }
    
    @WebMethod
    public ArrayList<Lista> getListas(String nickname) {
        Manejador m = new Manejador();
        return (ArrayList)m.getListas(nickname);
    }
    
    @WebMethod
    public ArrayList<Lista> getAllListas() {
        Manejador m = new Manejador();
        return (ArrayList)m.getAllListas();
    }
    
    @WebMethod
    public Categoria buscarCategoria(String cat) {
        Manejador m = new Manejador();
        return m.buscarCategoria(cat);
    }
    
    @WebMethod
    public Lista buscarLista(String nombre, String nickname) {
        Manejador m = new Manejador();
        return m.buscarLista(nombre, nickname);
    }
    
    @WebMethod
    public ArrayList<String> listarCategorias() {
        Manejador m = new Manejador();
        return (ArrayList)m.listarCategorias();
    }
    
    @WebMethod
    public ArrayList<String> listarVidesPorUsuario(String Usuario) {
        Manejador m = new Manejador();
        return (ArrayList)m.listarVidesPorUsuario(Usuario);
    }
    
    @WebMethod
    public ArrayList<String> listarUsuarios() {
        Manejador m = new Manejador();
        return (ArrayList)m.listarUsuarios();
    }
    
    @WebMethod
    public Usuario obtenerUsuarioPorMail(String mail) {
        Manejador m = new Manejador();
        return m.obtenerUsuarioPorMail(mail);
    }
    
    @WebMethod
    public Usuario obtenerUsuarioPorNickname(String nickname) {
        Manejador m = new Manejador();
        return m.obtenerUsuarioPorNickname(nickname);
    }
    
    @WebMethod
    public boolean nicknameLibre(String nickname) {
        Manejador m = new Manejador();
        return m.nicknameLibre(nickname);
    }
    
    @WebMethod
    public boolean mailLibre(String mail) {
        Manejador m = new Manejador();
        return m.mailLibre(mail);
    }
    
    @WebMethod
    public boolean nombreListaLibre(String nombreLista) {
        Manejador m = new Manejador();
        return m.nombreListaLibre(nombreLista);
    }
    
    @WebMethod
    public boolean nombreCategoriaLibre(String nombreCategoria) {
        Manejador m = new Manejador();
        return m.nombreCategoriaLibre(nombreCategoria);
    }
    
    @WebMethod
    public DTUsuario getUserData(String identificador) {
        Manejador m = new Manejador();
        return m.getUserData(identificador);
    }
    
    @WebMethod
    public Usuario buscarUsuarioPorVideo(String nombreVi) {
        Manejador m = new Manejador();
        return m.buscarUsuarioPorVideo(nombreVi);
    }
    // -------- fin funciones manejador
    
    //////////////////////Funciones que no retornan nada, solo para incluir los .java
    @WebMethod
    public DTCanal dtCanal(){
        return null;
    }
    
    @WebMethod
    public DTCategoria dtCategoria(){
        return null;
    }
    
    @WebMethod
    public DTComentario dtComentario(){
        return null;
    }
    
    @WebMethod
    public DTLista dtLista(){
        return null;
    }
    
    @WebMethod
    public DTListaUsuario dtListaUsuario(){
        return null;
    }
    
    @WebMethod
    public DTSesion dtSesion(){
        return null;
    }
    
    @WebMethod
    public DTUsuario dtUsuario(){
        return null;
    }
    
    @WebMethod
    public DTValoracion dtValoracion(){
        return null;
    }
    
    @WebMethod
    public DTVideo dtVideo(){
        return null;
    }
    
    @WebMethod
    public DTVideoUsuario dtVideoUsuario(){
        return null;
    }
}
