package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import logica.DT.DTCategoria;
import logica.DT.DTSesion;
import logica.DT.DTUsuario;


public class Manejador {
    private static Manejador instancia;
    private List<Usuario> usuarios;
    private List<Categoria> categorias;
    private List<String> listasPorDefecto;
    
    @PersistenceContext
    EntityManager em;
    
    
    private Manejador(){
        usuarios = new ArrayList();
        categorias = new ArrayList();
        listasPorDefecto = new ArrayList();
    }
 
    public static Manejador getinstance(){
        if (instancia==null)
            instancia = new Manejador();
        return instancia;
    }
    
    public List<DTUsuario> getUsuarios() {
        List<DTUsuario> DTUsuarios = new ArrayList();
        for(Usuario u : usuarios){
            DTUsuario usu = new DTUsuario(u);
            DTUsuarios.add(usu);
        }
        return DTUsuarios;
    }
    

    public List<DTCategoria> getCategorias() {
        
        
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select c from Categoria c");

        List<Categoria> aux = (List<Categoria>) query.getResultList();
        
        ArrayList<DTCategoria> result = new ArrayList<DTCategoria>();
        
        aux.forEach(x -> {
            result.add(new DTCategoria(x.getNombre()));
        });
        
        return result;
            
    }
    

    public List<String> getListasPorDefecto() {
        return listasPorDefecto;
    }
    
    
    
    public void addUsuario(Usuario usu){
            
       /* EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //em.persist(usu.getCanal());
        em.persist(usu);
        tx.commit();*/
        //usuarios.add(usu);
    }
    
    public void addCategoria (Categoria cat){
        
        EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cat);
        tx.commit();
    }
    
    public void addLista (String lista){
        EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(lista);
        tx.commit();
        //listasPorDefecto.add(lista);
    }
    
    public Usuario buscarUsuario(String nickname){
        for (logica.Usuario usuario : usuarios) {
            if(usuario.getNickname().equals(nickname))
                return usuario;
        }
        return null;       
    }
    
    public Categoria buscarCategoria(String cat){
        for (logica.Categoria categoria : categorias) {
            if(categoria.getNombre().equals(cat))
                return categoria;
        }
        return null;
    }
    
    public ArrayList<String> listarCategorias(){
        EntityManager em = Manejador.getEntityManager();
                Query query = Manejador.getEntityManager().createQuery(
                "select c from Categoria c");
                
                
        List<Categoria> aux = (List<Categoria>) query.getResultList();
        
        ArrayList<String> result = new ArrayList<String>();
        
        aux.forEach(x -> {
            result.add(x.getNombre());
        });
        
        return result;
        
        /*
        String nombre;
        Categoria c;
        ArrayList<String> listaCategorias = new ArrayList();
        Iterator it = this.categorias.iterator();
        while(it.hasNext()){
            c = (Categoria) it.next();
            nombre = c.getNombre();
            listaCategorias.add(nombre);
        }
        return listaCategorias;
*/
    }
    
    public ArrayList<String> listarUsuarios(){
        
        String nickname;
        Usuario u;
        ArrayList<String> listaUsuarios = new ArrayList();
        Iterator it = this.usuarios.iterator();
        while(it.hasNext()){
            u = (Usuario) it.next();
            nickname = u.getNickname();
            listaUsuarios.add(nickname);
        }
        return listaUsuarios;
    }
    
    public Usuario obtenerUsuarioPorMail(String mail){
        Iterator it = usuarios.iterator();
        Usuario user;
        while(it.hasNext()){
            user = (Usuario)it.next();
            if(user.getEmail().equals(mail))
                return user;
        }
        return null;
    }
    
    public boolean nicknameLibre(String nickname){
        if(this.buscarUsuario(nickname) == null){
                return true;
        }
        return false;
    }
    
    public boolean mailLibre(String mail){
        if(this.obtenerUsuarioPorMail(mail) == null){
                return true;
        }
        return false;
    }
    
    public boolean nombreListaLibre(String nombreLista){
        Iterator it = usuarios.iterator();
        Usuario user;
        while(it.hasNext()){
            user = (Usuario)it.next();
            Canal canal = user.getCanal();
            List<Lista> listaUsuarios = canal.getListas();
            for(Lista l : listaUsuarios){
                if(l.getNombre()== nombreLista)
                    return false;
            }
        }
        return true; 
    }
    
    public boolean nombreCategoriaLibre(String nombreCategoria){
        Iterator it = categorias.iterator();
        Categoria cat;
        while(it.hasNext()){
            cat = (Categoria)it.next();
            if(cat.getNombre()== nombreCategoria){
                return false;
            }
        }
        return true;
    }
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UyTubePU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    } 
    
    public DTSesion getUserSession(String identificador, String pass) {
        DTSesion ret = null;
        Usuario u;
        Iterator it=usuarios.iterator();
        while(it.hasNext()){
            u=(Usuario) it.next();
            if((u.getNickname().equals(identificador) && (u.getContrasenia().equals(pass)))){
                ret=u.getSesion();
                break;
            }
        }
       
        return ret;
    }
    
    public DTUsuario getUserData(String identificador) {
        DTUsuario ret = null;
        Usuario u;
        Iterator it = usuarios.iterator();
        while(it.hasNext()){
            u =(Usuario) it.next();
            if(u.getNickname().equals(identificador) || u.getEmail().equals(identificador)){
                ret=new DTUsuario(u);
                break;
            }            
        }        
                
        return ret;
    }
}
