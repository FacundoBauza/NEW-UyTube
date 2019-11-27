/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
         endpoint = Endpoint.publish("http://192.168.1.52:1234/publicador", this);   //ipkuki 192.168.1.52
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    
    //funciones del sistema
    
    @WebMethod
    public DtUsuario SetUsuario(String nickname, String contrasenia, String nombre, String apellido, String email, String fecha, String imagen, DtCanal canal, boolean Eliminado) throws ParseException{
        DtUsuario usu = new DtUsuario();
        SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
        Date date = null;
        date = simple.parse(fecha);
        usu.setear(nickname, contrasenia, nombre, apellido, email, date, imagen, canal, Eliminado);
        return usu;
    }
    
    @WebMethod
    public DtCanal SetCanal (String nombre, String desc, boolean privado){
        DtCanal c = new DtCanal();
        c.setear(nombre, desc, privado);
        return c;
    }
    
    @WebMethod
    public DtCategoria SetCategoria (String nombre){
        DtCategoria c = new DtCategoria();
        c.setNombre(nombre);
        return c;
    }
    
    @WebMethod
    public DtComentario SetComentario (String texto, String usuario){
        DtComentario c = new DtComentario();
        c.setear(texto, usuario);
        return c;
    }
    
    @WebMethod
    public DtLista SetLista (String nombre, boolean porDefecto, boolean privado, String categoria) {
        DtLista lis = new DtLista();
        lis.setear(nombre, porDefecto, privado, categoria);
        return lis;
    }
     
    @WebMethod
    public DtListaUsuario SetListaUsuario (String usuario, String lista) {
        DtListaUsuario lu = new DtListaUsuario();
        lu.setear(usuario, lista);
        return lu;
    }
    
    @WebMethod
    public DtSesion SetSesion (String nick, String contrasenia) {
        DtSesion s = new DtSesion();
        s.setear(nick, contrasenia);
        return s;
    }
    
    @WebMethod
    public DtValoracion SetValoracion (boolean meGusta, String usuario, String video){
        DtValoracion v = new DtValoracion();
        v.setear(meGusta, usuario, video);
        return v;
    }
    
    @WebMethod
    public DtVideo SetVideo (String nombre, String descripcion, String duracion, String fecha, String url, boolean privado, Categoria categoria) throws ParseException{
        DtVideo v = new DtVideo();
        SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
        Date date = null;
        date = simple.parse(fecha);
        v.setear(nombre, descripcion, duracion, date, url, privado, categoria);
        return v;
    }
    
    public DtVideoUsuario SetVideoUsuario (String usuario, String video){
        DtVideoUsuario v = new DtVideoUsuario();
        v.setear(usuario, video);
        return v;
    }
    
    @WebMethod
    public void altaUsuario(DtUsuario u, DtCanal c){
        
        ISistema s = new Sistema();
        s.altaUsuario(u, c);
    }
   
    @WebMethod
    public DtUsuario consultaUsuario(String nickname){
        ISistema s = new Sistema();
        return s.consultaUsuario(nickname);
    }
    
    @WebMethod
    public void modificarUsuario(String nickname, String contrasenia, String nombre, String apellido, String fechaNac, String imagen, String nombreCanal, String DescCanal, boolean priv) throws ParseException{
        ISistema s = new Sistema();
        SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
        Date date = null;
        date = simple.parse(fechaNac);
        s.modificarUsuario(nickname, contrasenia, nombre, apellido, date, imagen, nombreCanal, DescCanal, priv);
    }
    
    @WebMethod
    public void altaVideo(DtVideo video, String usuario){
        ISistema s = new Sistema();
        
        s.altaVideo(video, usuario);
    }
    
    @WebMethod
    public void modificarVideo (DtVideo video, String usuario, String nomVideo) {
        ISistema s = new Sistema();
        s.modificarVideo(video, usuario, nomVideo);
    }
    
    @WebMethod
    public void altaLista(DtLista lista, String usuario) {
        ISistema s = new Sistema();
        s.altaLista(lista, usuario);
    }
    
    @WebMethod
    public void altaListaPorDefecto(DtLista lista, String usuario) {
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
    public DtLista consultaLista(String usuario, String nombreLista) {
        ISistema s = new Sistema();
        return s.consultaLista(usuario, nombreLista);
    }
    
    @WebMethod
    public void altaCategoria(DtCategoria categoria) {
        ISistema s = new Sistema();
        s.altaCategoria(categoria);
    }
    
    @WebMethod
    public DtVideoUsuario[] consultaVideosPorCategoria(String categoria) {
        ISistema s = new Sistema();
        ArrayList<DtVideoUsuario> v = (ArrayList)s.consultaVideosPorCategoria(categoria);
        DtVideoUsuario[] videos = null;
        return v.toArray(videos);
    }
    
    @WebMethod
    public DtListaUsuario[] consultaListasPorCategoria(String categoria) {
        ISistema s = null;
        s = Fabrica.getInstance();
        ArrayList<DtListaUsuario> l = (ArrayList)s.consultaListasPorCategoria(categoria);
        DtListaUsuario[] lis = {};
        return l.toArray(lis);
    }
    
    @WebMethod
    public DtVideo consultarVideo(String usuario, String video) {
        ISistema s = new Sistema();
        return s.consultarVideo(usuario, video);
    }
    
    @WebMethod
    public void comentarVideo(String usuario,DtComentario comentario,String video, int padre) {
        ISistema s = new Sistema();
        s.comentarVideo(usuario, comentario, video, padre);
    }
    
    @WebMethod
    public void valorarVideo(String usuario,String video, DtValoracion valoracion ) {
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
    public String[] listarVideos(String nickUsuario) {
        ISistema s = new Sistema();
        ArrayList<String> v = (ArrayList)s.listarVideos(nickUsuario);
        String[] videos = {};
        return v.toArray(videos);
    }
    
    @WebMethod
    public String[] listarListas(String nickUsuario) {
        ISistema s = new Sistema();
        ArrayList<String> l = (ArrayList)s.listarListas(nickUsuario);
        String[] lis = {};
        return l.toArray(lis);
    }
    
    @WebMethod
    public String[] listarMG(String usuario, String video) {
        ISistema s = new Sistema();
        ArrayList<String> mg = (ArrayList)s.listarMG(usuario, video);
        String[] listamg = {};
        return mg.toArray(listamg);
    }
    
    @WebMethod
    public String[] listarNMG(String usuario, String video) {
        ISistema s = new Sistema();
        ArrayList<String> nmg = (ArrayList)s.listarNMG(usuario, video);
        String[] listaNmg = {};
        return nmg.toArray(listaNmg);
    }
    
    @WebMethod
    public DtLista[] listasParticulares(String usuario) {
        ISistema s = null;
        s = Fabrica.getInstance();
        ArrayList<DtLista> l = (ArrayList)s.listasParticulares(usuario);
        DtLista[] lis = {};
        return l.toArray(lis);
    }
        
    
    @WebMethod
    public String[] listarVideosLista(String usuario, String lista) {
        ISistema s = new Sistema();
        ArrayList<String> v = (ArrayList)s.listarVideosLista(usuario, lista);
        String[] videos = {};
        return v.toArray(videos);
    }
    
    @WebMethod
    public DtSesion getUserSession(String identificador, String pass) {
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
    public Video[] getVideos() {
        Manejador m = new Manejador();
        ArrayList<Video> v = (ArrayList)m.getVideos();
        Video[] videos = null;
        return v.toArray(videos);
    }
    
    @WebMethod
    public DtUsuario[] getUsuarios() {
        Manejador m = new Manejador();
        ArrayList<DtUsuario> u = (ArrayList)m.getUsuarios();
        DtUsuario[] usu = {};
        return u.toArray(usu);
    }
    
    @WebMethod
    public DtCategoria[] getCategorias() {
        Manejador m = new Manejador();
        ArrayList<DtCategoria> c = (ArrayList)m.getCategorias();
        DtCategoria[] cat = {};
        return c.toArray(cat);
    }
    
    @WebMethod
    public String[] getListasPorDefecto() {
        Manejador m = new Manejador();
        ArrayList<String> l = (ArrayList)m.getListasPorDefecto();
        String[] lis = {};
        return l.toArray(lis);
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
    public Lista[] getListas(String nickname) {
        Manejador m = new Manejador();
        ArrayList<Lista> l = (ArrayList)m.getListas(nickname);
        Lista[] listas = {};
        return l.toArray(listas);
    }
    
    @WebMethod
    public Lista[] getAllListas() {
        Manejador m = new Manejador();
        ArrayList<Lista> l = (ArrayList)m.getAllListas();
        Lista[] listas = {};
        return l.toArray(listas);
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
    public String[] listarCategorias() {
        Manejador m = new Manejador();
        ArrayList<String> c = (ArrayList)m.listarCategorias();
        String[] cat = {};
        return c.toArray(cat);
    }
    
    @WebMethod
    public String[] listarVidesPorUsuario(String Usuario) {
        Manejador m = new Manejador();
        ArrayList<String> v = (ArrayList)m.listarVidesPorUsuario(Usuario);
        String[] videos = {};
        return v.toArray(videos);
    }
    
    @WebMethod
    public String[] listarUsuarios() {
        Manejador m = new Manejador();
        ArrayList<String> u = (ArrayList)m.listarUsuarios();
        String[] usu = {};
        return u.toArray(usu);
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
    public DtUsuario getUserData(String identificador) {
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
    public DtCanal DtCanal(){
        return null;
    }
    
    @WebMethod
    public DtCategoria DtCategoria(){
        return null;
    }
    
    @WebMethod
    public DtComentario DtComentario(){
        return null;
    }
    
    @WebMethod
    public DtLista DtLista(){
        return null;
    }
    
    @WebMethod
    public DtListaUsuario DtListaUsuario(){
        return null;
    }
    
    @WebMethod
    public DtSesion DtSesion(){
        return null;
    }
    
    @WebMethod
    public DtUsuario DtUsuario(){
        return null;
    }
    
    @WebMethod
    public DtValoracion DtValoracion(){
        return null;
    }
    
    @WebMethod
    public DtVideo DtVideo(){
        return null;
    }
    
    @WebMethod
    public DtVideoUsuario DtVideoUsuario(){
        return null;
    }
}
