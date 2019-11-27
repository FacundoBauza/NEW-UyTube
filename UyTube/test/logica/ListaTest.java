/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.DT.DtLista;
import logica.DT.DtVideo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ListaTest {
    
    public ListaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testAltaListaPart() {
        System.out.println("alta lista particular");
        String nombre= "nombreLista";
        String categoria = "nombreCategoria";
        boolean porDefecto = false;
        boolean privado= true;
        DtLista lista = new DtLista ( nombre, porDefecto, privado, categoria);
        String usuario = "kuki";
        Manejador m = Manejador.getinstance();
        Sistema s = new Sistema();
        Usuario u = m.buscarUsuario("kuki");
        Canal c = u.getCanal();
        List L = new ArrayList();
        L.addAll(c.getListas());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaLista(lista, usuario);
        List L2 = new ArrayList();
        L.addAll(c.getListas());
        int pos = L2.size();
        assertEquals(pre,pos);
    }
    
    @Test
    public void testAltaListaPart2() {
        System.out.println("alta lista particular");
        String nombre= "nombreLista2";
        String categoria = "nombreCategoria2";
        boolean porDefecto = false;
        boolean privado= true;
        DtLista lista = new DtLista ( nombre, porDefecto, privado, categoria);
        String usuario = "gime";
        Manejador m = Manejador.getinstance();
        Sistema s = new Sistema();
        Usuario u = m.buscarUsuario("gime");
        Canal c = u.getCanal();
        List L = new ArrayList();
        L.addAll(c.getListas());
        int pre = L.size()+1; //+1 es por la nueva creada
        
        s.altaLista(lista, usuario);
        List L2 = new ArrayList();
        L.addAll(c.getListas());
        int pos = L2.size();
        assertEquals(pre,pos);
    }
    
}
