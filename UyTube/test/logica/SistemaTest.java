/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.DT.DtCanal;
import logica.DT.DtCategoria;
import logica.DT.DtComentario;
import logica.DT.DtLista;
import logica.DT.DtUsuario;
import logica.DT.DtValoracion;
import logica.DT.DtVideo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Usuario
 */
public class SistemaTest {
    
    public SistemaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of altaUsuario method, of class Sistema.
     */
    @Test
    public void testAltaUsuario() {
        System.out.println("alta Usuario");
        String nickname = "kuki";
        String contrasenia = "1234";
        String nombre = "Eugenia";
        String apellido = "Cabrera";
        String email = "kukicabrera09@gmail.com";
        Date fechaNac = new Date("01/25/1996");
        String imagen = "imagenPerfil";
        String canalNombre = "canalKuki";
        String desc = "descripcion canal";
        Boolean privado = true;
        List<DtVideo> videos = new ArrayList();
        List<DtLista> listas = new ArrayList();
        DtCanal c = new DtCanal ( canalNombre, desc, privado, videos, listas);
        DtUsuario u = new DtUsuario( nickname, contrasenia, nombre, apellido, email, fechaNac, imagen, c, false);
      
        
        
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getUsuarios());
        int pre = L.size()+1; //+1 es por el nuevo creado
        
        s.altaUsuario(u, c);
        List L2 = new ArrayList();
        L2.addAll(m.getUsuarios());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
    @Test
    public void testAltaUsuario2() {
        System.out.println("alta Usuario");
        String nickname = "gime";
        String contrasenia = "1234";
        String nombre = "Gimena";
        String apellido = "Deleon";
        String email = "gimedeleon@gmail.com";
        Date fechaNac = new Date("01/26/1996");
        String imagen = "imagenPerfil";
        String canalNombre = "canal";
        String desc = "descripcion canal";
        Boolean privado = false;
        List<DtVideo> videos = new ArrayList();
        List<DtLista> listas = new ArrayList();
        DtCanal c = new DtCanal ( canalNombre, desc, privado, videos, listas);
        DtUsuario u = new DtUsuario( nickname, contrasenia, nombre, apellido, email, fechaNac, imagen, c, false);
        
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getUsuarios());
        int pre = L.size()+1; //+1 es por el nuevo creado
        
        s.altaUsuario(u, c);
        List L2 = new ArrayList();
        L2.addAll(m.getUsuarios());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
    @Test
    public void testAltaUsuario3() {
        System.out.println("alta Usuario");
        String nickname = "fede";
        String contrasenia = "1234";
        String nombre = "Federico";
        String apellido = "Diaz";
        String email = "fedediaz@gmail.com";
        Date fechaNac = new Date("01/26/1970");
        String imagen = "imagenPerfil";
        String canalNombre = "nombreCanal";
        String desc = "descripcion canal";
        Boolean privado = true;
        List<DtVideo> videos = new ArrayList();
        List<DtLista> listas = new ArrayList();
        DtCanal c = new DtCanal ( canalNombre, desc, privado, videos, listas);
        DtUsuario u = new DtUsuario( nickname, contrasenia, nombre, apellido, email, fechaNac, imagen, c, false);
        
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getUsuarios());
        int pre = L.size()+1; //+1 es por el nuevo creado
        
        s.altaUsuario(u, c);
        List L2 = new ArrayList();
        L2.addAll(m.getUsuarios());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
    /**
     * Test of altaCategoria method, of class Sistema.
     */
    @Test
    public void testAltaCategoria() {
        System.out.println("altaCategoria");
        String nombreCategoria = "nombreCategoria";
        DtCategoria categoria = new DtCategoria(nombreCategoria);
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getCategorias());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaCategoria(categoria);
        List L2 = new ArrayList();
        L2.addAll(m.getCategorias());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
     /**
     * Test of altaCategoria method, of class Sistema.
     */
    @Test
    public void testAltaCategoria2() {
        System.out.println("altaCategoria");
        String nombreCategoria = "nombreCategoria2";
        DtCategoria categoria = new DtCategoria(nombreCategoria);
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getCategorias());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaCategoria(categoria);
        List L2 = new ArrayList();
        L2.addAll(m.getCategorias());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
     /**
     * Test of altaCategoria method, of class Sistema.
     */
    @Test
    public void testAltaCategoria3() {
        System.out.println("altaCategoria");
        String nombreCategoria = "nombreCategoria3";
        DtCategoria categoria = new DtCategoria(nombreCategoria);
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getCategorias());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaCategoria(categoria);
        List L2 = new ArrayList();
        L2.addAll(m.getCategorias());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
     /**
     * Test of altaCategoria method, of class Sistema.
     */
    @Test
    public void testAltaCategoria4() {
        System.out.println("altaCategoria");
        String nombreCategoria = "nombreCategoria4";
        DtCategoria categoria = new DtCategoria(nombreCategoria);
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getCategorias());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaCategoria(categoria);
        List L2 = new ArrayList();
        L2.addAll(m.getCategorias());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
     /**
     * Test of altaCategoria method, of class Sistema.
     */
    @Test
    public void testAltaCategoria5() {
        System.out.println("altaCategoria");
        String nombreCategoria = "nombreCategoria5";
        DtCategoria categoria = new DtCategoria(nombreCategoria);
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getCategorias());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaCategoria(categoria);
        List L2 = new ArrayList();
        L2.addAll(m.getCategorias());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
     /**
     * Test of altaCategoria method, of class Sistema.
     */
    @Test
    public void testAltaCategoria6() {
        System.out.println("altaCategoria");
        String nombreCategoria = "nombreCategoria6";
        DtCategoria categoria = new DtCategoria(nombreCategoria);
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        List L = new ArrayList();
        L.addAll(m.getCategorias());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaCategoria(categoria);
        List L2 = new ArrayList();
        L2.addAll(m.getCategorias());
        int pos = L2.size();
        assertEquals(pre,pos);
        
    }
    
    
    @Test
    public void testAltaVideo() {
        System.out.println("alta Video");
        String nombre= "nombreVideo";
        String descripcion = "descripcion";
        String duracion = "1";
        Date fecha = new Date();
        String url="urlVideo";
        boolean privado= true;
        Categoria categoria1 = null;
        
        DtVideo video = new DtVideo ( nombre, descripcion, duracion, fecha, url, privado, categoria1);
        
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        Usuario u = m.buscarUsuario("kuki");
        String usuario = u.getNickname();
        if ( u == null)
            System.out.println("No hay usuario nieri");
        Canal c = u.getCanal();
        List L = new ArrayList();
        L.addAll(c.getVideos());
        int pre = L.size()+1; //+1 es por el nuevo creado
        
        s.altaVideo(video, usuario);
        List L2 = new ArrayList();
        L2.addAll(c.getVideos());
        int pos = L2.size();
        assertEquals(pre,pos);
    }
    
    @Test
    public void testAltaVideo2() {
        System.out.println("alta Video");
        String nombre= "nombreVideo2";
        String descripcion = "descripcion2";
        String duracion = "0";
        Date fecha = new Date();
        String url="urlVideo2";
        boolean privado= true;
        Categoria categoria2 = null;
        DtVideo video = new DtVideo ( nombre, descripcion, duracion, fecha, url, privado, categoria2);
        
        Manejador m = Manejador.getinstance();
        ISistema s = Fabrica.getInstance();
        Usuario u = m.buscarUsuario("gime");
        String usuario = u.getNickname();
        Canal c = u.getCanal();
        List L = new ArrayList();
        L.addAll(c.getVideos());
        int pre = L.size()+1; //+1 es por el nuevo creado
        
        s.altaVideo(video, usuario);
        List L2 = new ArrayList();
        L2.addAll(c.getVideos());
        int pos = L2.size();
        assertEquals(pre,pos);
    }
    
    
}
