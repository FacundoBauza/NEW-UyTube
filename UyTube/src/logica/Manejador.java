package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import logica.DT.DtCanal;
import logica.DT.DtCategoria;
import logica.DT.DtSesion;
import logica.DT.DtUsuario;


public class Manejador {
    public static Manejador instancia;
    private List<Usuario> usuarios;
    private List<Categoria> categorias;
    private List<String> listasPorDefecto;
    
    @PersistenceContext
    EntityManager em;
    
    
    public Manejador(){
        usuarios = new ArrayList();
        categorias = new ArrayList();
        listasPorDefecto = new ArrayList();
    }
 
    public static Manejador getinstance(){
        if (instancia==null)
            instancia = new Manejador();
        return instancia;
    }
    
    public List<Video> getVideos() {
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select v from Video v");
        List<Video> aux = (List<Video>) query.getResultList();
        return aux;
    }
    
    public List<DtUsuario> getUsuarios() {
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select u from Usuario u");

        List<Usuario> aux = (List<Usuario>) query.getResultList();
        
        ArrayList<DtUsuario> result = new ArrayList<DtUsuario>();
        
        aux.forEach(x -> {
            DtCanal canal = new DtCanal(x.getCanal());
            result.add(new DtUsuario(x.getNickname(),x.getContrasenia(), x.getNombre(), x.getApellido(), x.getEmail(), x.getFechaNac(), x.getImagen(), canal, x.getEliminado()));
        });
        
        return result;
    }
    

    public List<DtCategoria> getCategorias() {
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select c from Categoria c");

        List<Categoria> aux = (List<Categoria>) query.getResultList();
        
        ArrayList<DtCategoria> result = new ArrayList<>();
        
        aux.forEach(x -> {
            result.add(new DtCategoria(x.getNombre()));
        });
        
        return result;
            
    }
    

    public List<String> getListasPorDefecto() {
        EntityManager em = Manejador.getEntityManager();
        boolean t = true;
        Query query = Manejador.getEntityManager().createQuery("SELECT c FROM Lista c WHERE c.porDefecto = :pDef", Lista.class);
        query.setParameter("pDef", t);
        
        List<Lista> aux = (List<Lista>) query.getResultList();
        
        ArrayList<String> result = new ArrayList<>();
        
        aux.forEach(x -> {
            result.add(x.getNombre());
        });
        
        return result;
        
    }
        
    public void addUsuario(Usuario usu){
            
        EntityManager em6 = Manejador.getEntityManager();
        EntityTransaction tx = em6.getTransaction();
        tx.begin();
        em6.persist(usu.getCanal());
        em6.persist(usu);
        tx.commit();

    }
    
    public void addCategoria (Categoria cat){
        
        EntityManager em7 = Manejador.getEntityManager();
        EntityTransaction tx = em7.getTransaction();
        tx.begin();
        em7.persist(cat);
        tx.commit();
    }
    
    public void addLista (Lista lista, String Usuario){
        EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Usuario u = buscarUsuario(Usuario);
        Canal c = u.getCanal();
        c.addLista(lista);
        
        tx.begin();
        em.merge(c);
        tx.commit();
        
    }
    
    public Usuario buscarUsuario(String nickname){
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select u from Usuario u");

        List<Usuario> aux = (List<Usuario>) query.getResultList();
        
        for(int i=0; i<aux.size(); i++)
            if(aux.get(i).getNickname().equals(nickname))
                return aux.get(i);
        return null;
    }
    
    public Usuario buscarUsuarioPorVideo(String nombreVi){
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select u from Usuario u");

        List<Usuario> aux = (List<Usuario>) query.getResultList();
        for(int i=0; i<aux.size(); i++)
        {
            Canal l = aux.get(i).getCanal();
            if(l.getVideos().size()>0)
            {
                for(int i2=0; i2<l.getVideos().size(); i2++)
                {
                    if(l.getVideos().get(i2).getNombre().equals(nombreVi))
                        return aux.get(i);

                }
            }    
        }
        return null;
    }
    
    public List<Lista> getListas(String nickname){
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("Select u From Lista u");

        List<Lista> aux = (List<Lista>) query.getResultList();
        List<Lista> auxx = new ArrayList<Lista>();
        
        for(int i=0; i<aux.size(); i++)
            if(aux.get(i).getUsuario_nickname().equals(nickname))
                auxx.add(aux.get(i));
        return auxx;
    }
    public List<Lista> getAllListas(){
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("Select u From Lista u");

        List<Lista> aux = (List<Lista>) query.getResultList();
        List<Lista> auxx = new ArrayList<Lista>();
        
        for(int i=0; i<aux.size(); i++)
            if(aux.get(i).getPrivado()==false && aux.get(i).getPorDefecto()==false)
                auxx.add(aux.get(i));
        return auxx;
    }
    
    public Categoria buscarCategoria(String cat){
        /*for (logica.Categoria categoria : categorias) {
            if(categoria.getNombre().equals(cat))
                return categoria;
        }*/
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select c from Categoria c");

        List<Categoria> aux = (List<Categoria>) query.getResultList();
        
         for(int i=0; i<aux.size(); i++)
             if(aux.get(i).getNombre().equalsIgnoreCase(cat))
                 return aux.get(i);
        return null;
    }
    
    public Lista buscarLista(String nombre, String nickname){
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("Select l From Lista l", Lista.class);
 
        List<Lista> aux = query.getResultList();
        
        for(int i=0; i<aux.size(); i++)
        {   
            System.out.print(aux.get(i).getUsuario_nickname());
            System.out.print(nickname);
            if(aux.get(i).getUsuario_nickname().equals(nickname))
            {
                System.out.print("Entra");
                if(aux.get(i).getNombre().equals(nombre))
                    return aux.get(i);
                
            }
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
   
     public ArrayList<String> listarVidesPorUsuario(String Usuario){
        EntityManager em = Manejador.getEntityManager();
        Usuario u = this.buscarUsuario(Usuario);
        Query query;
        //query = em.createQuery("select v FROM Video v, canal_video cv "
        //        + "where v.id = videos_id AND cv.Canal_Nombre = :nom");
        
        String nom = u.getCanal().getNombre();
        query = em.createQuery("select c from Canal c where c.nombre = :nom");
        query.setParameter("nom", nom);
        
        List<Canal> c = (List<Canal>) query.getResultList();
        
        Canal canal = c.get(0);
        List<Video> aux  = canal.getVideos();
        
        ArrayList<String> result = new ArrayList<>();
        
        aux.forEach(x -> {
            result.add(x.getNombre());
        });
        
        return result;
    }
    
    public ArrayList<String> listarUsuarios(){
        /*String nickname;
        Usuario u;
        ArrayList<String> listaUsuarios = new ArrayList();
        Iterator it = this.usuarios.iterator();
        while(it.hasNext()){
            u = (Usuario) it.next();
            nickname = u.getNickname();
            listaUsuarios.add(nickname);
        }
        return listaUsuarios;*/
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select u from Usuario u");

        List<Usuario> aux = (List<Usuario>) query.getResultList();
        
        ArrayList<String> result = new ArrayList<String>();
        
        aux.forEach(x -> {
            result.add(x.getNickname());
        });
        
        return result;
    }
    
    public Usuario obtenerUsuarioPorMail(String mail){
        /*Iterator it = usuarios.iterator();
        Usuario user;
        while(it.hasNext()){
            user = (Usuario)it.next();
            if(user.getEmail().equals(mail))
                return user;
        }*/
        EntityManager em1 = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select u from Usuario u");

        List<Usuario> aux = (List<Usuario>) query.getResultList();
        
         for(int i=0; i<aux.size(); i++)
             if(aux.get(i).getEmail().equals(mail))
                 return aux.get(i);
        return null;
    }
    
    public Usuario obtenerUsuarioPorNickname(String nickname){
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select u from Usuario u");

        List<Usuario> aux = (List<Usuario>) query.getResultList();
        
         for(int i=0; i<aux.size(); i++)
             if(aux.get(i).getNickname().equals(nickname))
                 return aux.get(i);
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
        EntityManager em = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("SELECT u FROM Lista u", Lista.class);
        
        List<Lista> aux = (List<Lista>)query.getResultList();
        
        for(int i=0; i<aux.size(); i++)
        {
            if(aux.get(i).getUsuario_nickname().equals(nombreLista))
                return false;
        }
        return true;
        
    }
    
    public boolean nombreCategoriaLibre(String nombreCategoria){
        /*Iterator it = categorias.iterator();
        Categoria cat;
        while(it.hasNext()){
            cat = (Categoria)it.next();
            if(cat.getNombre()== nombreCategoria){
                return false;
            }
        }
        return true;*/
        EntityManager em1 = Manejador.getEntityManager();
        Query query = Manejador.getEntityManager().createQuery("select c from Categoria c");

        List<Categoria> aux = (List<Categoria>) query.getResultList();
        
         for(int i=0; i<aux.size(); i++)
         {
             if(aux.get(i).getNombre().equals(nombreCategoria))
                return false;
         } 
        return true;
    }
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UyTubePU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    } 
    
    public DtSesion getUserSession(String identificador, String pass) {
        DtSesion ret = null;
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
    
    public DtUsuario getUserData(String identificador) {
        DtUsuario ret = null;
        Usuario u;
        Iterator it = usuarios.iterator();
        while(it.hasNext()){
            u =(Usuario) it.next();
            if(u.getNickname().equals(identificador) || u.getEmail().equals(identificador)){
                ret=new DtUsuario(u);
                break;
            }            
        }        
                
        return ret;
    }
}
