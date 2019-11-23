package logica;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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

public class Sistema implements ISistema{

    public Sistema() {
    }
    @Override
    public void altaUsuario(DTUsuario u, DTCanal c){
        List<Lista> listas = new ArrayList();
        Manejador m = Manejador.getinstance();
        List<String> listasNombres = m.getListasPorDefecto();
        if(!listasNombres.isEmpty()){
            Lista list;
            for(String l : listasNombres){
                list = new Lista(l, true, true, null, u.getNickname());
                listas.add(list);
            }
        }
        String nombre;
        nombre = c.getNombre();
        Canal canal = new Canal(nombre, c.getDesc(), c.isPrivado(), listas);
        Usuario usuario = new Usuario(u.getNickname(), u.getContrasenia(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen(), canal, u.getEliminado());
        m.addUsuario(usuario);
        
    }
    
    public DTUsuario consultaUsuario(String nickname){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickname);
        if (u!= null)
            return new DTUsuario(u);
                     
        else
            return null;
    }
    
    @Override
    public void modificarUsuario(String nickname, String contrasenia, String nombre, String apellido, Date fechaNac, String imagen, String nombreCanal, String DescCanal, boolean priv){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickname);
        if(u != null)
        {
            //Canal c = u.getCanal();
            Canal c = new Canal();
            c.setDesc(DescCanal);
            c.setNombre(nombreCanal);
            c.setPrivado(priv);
           
            u.setContrasenia(contrasenia);
            u.setApellido(apellido);
            u.setCanal(c);
            u.setFechaNac(fechaNac);
            u.setImagen(imagen);
            u.setNombre(nombre);
            EntityManager em = Manejador.getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(c);
            em.merge(u);
            tx.commit();
        }
        
    }
    
    public void altaVideo(DTVideo video, String usuario){
        Manejador m = Manejador.getinstance();
        Categoria cat = null;
       
        Video v = new Video(video.getNombre(), video.getDescripcion(), video.getDuracion(),
                video.getFecha(), video.getUrl(), video.isPrivado(), video.getCategoria());
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        c.addVideo(v);
        EntityManager em5 = Manejador.getEntityManager();
        EntityTransaction tx = em5.getTransaction();
        tx.begin();
        em5.persist(v);
        em5.merge(c);
        tx.commit();
        /*Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        c.addVideo(v);*/
        
    }
    
    public void modificarVideo (DTVideo video, String usuario, String nomVideo){
        Manejador m = Manejador.getinstance();
        EntityManager em5 = Manejador.getEntityManager();
        EntityTransaction tx = em5.getTransaction();
        
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        Video v = c.buscarVideo(nomVideo);
        v.setNombre(video.getNombre());
        v.setDescripcion(video.getDescripcion());
        v.setDuracion(video.getDuracion());
        v.setFecha(video.getFecha());
        v.setUrl(video.getUrl());
        v.setPrivado(video.isPrivado());
        v.setCategoria(m.buscarCategoria(video.getCategoria().getNombre()));
        
        tx.begin();
        em5.merge(v);
        tx.commit();
        
    }

    public void altaLista(DTLista lista, String usuario){ // particular valga la redundancia
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        //Canal_Lista cl = new Canal_Lista();
        Lista l;
        Categoria cat = m.buscarCategoria(lista.getCategoria());
        Lista list = m.buscarLista(lista.getNombre(), usuario);
        if(list == null){
            l = new Lista(lista.getNombre(), lista.isPorDefecto(), lista.isPrivado(), cat, u.getNickname());
            m.addLista(l, usuario);
        }
        
    }
    
    public void altaListaPorDefecto(DTLista lista, String usuario){
        Manejador m = Manejador.getinstance();
       //Usuario u = m.buscarUsuario(usuario);
        Lista l;
        Categoria cat = m.buscarCategoria(lista.getCategoria());
        Lista list = m.buscarLista(lista.getNombre(), usuario);
        if(list == null){
            List<DTUsuario> l1 = m.getUsuarios();
            
            for(int x=0; x<l1.size(); x++)
            {
               l = new Lista(lista.getNombre(), lista.isPorDefecto(), lista.isPrivado(), cat, l1.get(x).getNickname());
               m.addLista(l, usuario);
            }
        }        
    }
    
    public void modificarListaPart(String Usuario, String nombreLista, String categoria, Boolean privado){
        Manejador m = Manejador.getinstance();
       
        Lista c1 = m.buscarLista(nombreLista, Usuario);
        if(categoria.length() != 0)
        {
            Categoria cat = m.buscarCategoria(categoria);
            c1.setCategoria(cat);
        }
        
        if(privado)
        {
            c1.setPorDefecto(false);
            c1.setPrivado(true);
        }
        else
        {
            c1.setPorDefecto(true);
            c1.setPrivado(false);
        }
        
        EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(c1);
        tx.commit();
    }
    
    public void agregarVideoAlista(String usuario, String video, String usuario2, String nombreLista){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        Video v = c.buscarVideo(video);
        Usuario u2 = m.buscarUsuario(usuario2);
        Canal c2 = u2.getCanal();
        Lista listaAgregarVideo = c2.buscarLista(nombreLista);
        listaAgregarVideo.addVideo(v);
       
        EntityManager em5 = Manejador.getEntityManager();
        EntityTransaction tx = em5.getTransaction();
        tx.begin();
        em5.merge(listaAgregarVideo);
        tx.commit();
        
        //c2.addVideo(v); 
    }
    
    public void quitarVideoDeLista(String usuario, String video, String nombreLista){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        c.listarListas();
        Lista listaQuitarVideo = c.buscarLista(nombreLista);
        //listaQuitarVideo.listarVideosEnLista();
        Video videoQuitar = listaQuitarVideo.buscarVideoEnLista(video);
        listaQuitarVideo.removeVideo(videoQuitar);
        EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(listaQuitarVideo);
        tx.commit();
    }
    
    public DTLista consultaLista(String usuario, String nombreLista){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        c.listarListas();
        Lista listaConsultar = c.buscarLista(nombreLista);
        
        return new DTLista(listaConsultar.getNombre(),listaConsultar.isPorDefecto(),listaConsultar.isPrivado(), listaConsultar.getCategoria().getNombre());
        
    }
    
    public void altaCategoria(DTCategoria categoria){
        Categoria cat = new Categoria(categoria.getNombre());
        Manejador m = Manejador.getinstance();
        m.addCategoria(cat);
    }
    
    public List<DTVideoUsuario> consultaVideosPorCategoria(String categoria){
        Manejador m = Manejador.getinstance();
        List <DTVideoUsuario> listaVideos = new ArrayList();
        for (DTUsuario usu : m.getUsuarios()){
            Usuario u = m.buscarUsuario(usu.getNickname());
            for(Video v : u.getCanal().getVideos()){
                if (v.getCategoria().getNombre().equals(categoria)){
                    DTVideoUsuario video = new DTVideoUsuario(u.getNickname(), v.getNombre());
                    listaVideos.add(video);
                }
            }
                
        }
        if (listaVideos.isEmpty())
            return null;
        else
            return listaVideos;
    }
    
    public List<DTListaUsuario> consultaListasPorCategoria(String categoria){
        Manejador m = Manejador.getinstance();
        List <DTListaUsuario> listaListas = new ArrayList();
        for (DTUsuario usu : m.getUsuarios()){
            Usuario u = m.buscarUsuario(usu.getNickname());
            for(Lista l : u.getCanal().getListas()){
                if (l.getCategoria().getNombre().equals(categoria)){
                    DTListaUsuario lista = new DTListaUsuario(u.getNickname(), l.getNombre());
                    listaListas.add(lista);
                }
            }
                
        }
        if (listaListas.isEmpty())
            return null;
        else
            return listaListas;
    }
    
     public DTVideo consultarVideo(String usuario, String video){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal canal = u.getCanal();
        Video v = canal.buscarVideo(video);
        
        return new DTVideo (v.getNombre(), v.getDescripcion(), v.getDuracion(), v.getFecha(), v.getUrl(), 
                v.isPrivado(), v.getCategoria());  
    }    
        

    @Override
    public void comentarVideo(String usuario,DTComentario comentario,String video, int padre){
        EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Manejador m = Manejador.getinstance();
        System.out.print("Llega");
        Usuario usuarioVideo = m.buscarUsuario(usuario);
        Canal canal = usuarioVideo.getCanal();
        Video v = canal.buscarVideo(video);
        Usuario usuarioCom = m.buscarUsuario(comentario.getUsuario());
        Comentario c = new Comentario(comentario.getTexto(), usuarioCom);
        Comentario comPadre = null;
        if (padre != 0)
        {
            if(usuarioVideo != null && canal != null && usuarioCom != null && c != null)
            {
                System.out.print("Entra");
                comPadre = v.buscarComentario(padre);
                if (comPadre != null)
                {
                    comPadre.addHijo(c);
                    tx.begin();
                    em.persist(c);
                    em.merge(comPadre);
                    tx.commit();
                }
            }
            else
                System.out.print("No esta persistiendo");
            
        }
        else
        {
            v.addComentario(c);
            tx.begin();
            em.persist(c);
            em.merge(v);
            tx.commit();
        }
       
    }
    
    @Override
    public void valorarVideo(String usuario,String video, DTValoracion valoracion ){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal canal = u.getCanal();
        Video v = canal.buscarVideo(video);
        Usuario uValora = m.buscarUsuario(valoracion.getUsuario());
        Valoracion valora = new Valoracion(valoracion.isMeGusta(), uValora , v);
      
        uValora.addValoracion(valora);    
        v.addValoracion(valora);
        
        EntityManager em = Manejador.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(v);
        em.merge(uValora);
        tx.commit();
    }
    
    @Override
    public void seguirUsuario(String nickSeguidor, String nickSeguido){
        Manejador m = Manejador.getinstance();
        Usuario seguidor = m.buscarUsuario(nickSeguidor);
        Usuario seguido = m.buscarUsuario(nickSeguido);
        
        if(seguidor!=null && seguido!=null){
           System.out.print(seguido.getNickname() + seguidor.getNickname());
           seguido.addSeguidor(seguidor);
           seguidor.addSeguido(seguido);
           EntityManager em = Manejador.getEntityManager();
           EntityTransaction tx = em.getTransaction();
           tx.begin();
           em.merge(seguido);
           em.merge(seguidor);
           tx.commit();
        }
        else
            System.out.print("No reconoce al Usuario wey");
    }
    
    public void dejarDeSeguirUsuario(String nickSeguidor, String nickSeguido){
        Manejador m = Manejador.getinstance();
        Usuario seguidor = m.buscarUsuario(nickSeguidor);
        Usuario seguido = m.buscarUsuario(nickSeguido);
        if(seguidor!=null && seguido!=null){
            seguido.removeSeguidor(seguidor);
            seguidor.removeSeguido(seguido);
            EntityManager em = Manejador.getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            String Consulta = "Delete From Usuario_Usuario u "
                    + "Where u.usuario_nickname = ? "
                    + "and u.seguidos_nickname = ?";
            Query q = em.createNativeQuery(Consulta);
            q.setParameter(1, nickSeguidor);
            q.setParameter(2, nickSeguido);
            
            int rowCount = q.executeUpdate();
            
            String Consulta2 = "Delete From Usuario_Usuario u "
                    + "Where u.usuario_nickname = ? "
                    + "and u.seguidores_nickname = ?";
            Query q2 = em.createNativeQuery(Consulta2);
            q2.setParameter(1, nickSeguido);
            q2.setParameter(2, nickSeguidor);
            
            int rowCount2 = q2.executeUpdate();
            tx.commit();
            
            //https://wiki.eclipse.org/EclipseLink/UserGuide/JPA/Basic_JPA_Development/Querying/Native#Native_SQL_query_examples
        }
    }
    
   
    public List<String> listarVideos(String nickUsuario){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickUsuario);
        Canal c = u.getCanal();
        //System.out.print(c.getVideos().size());
        return c.listarVideos();    
    } 
    
    @Override
    public List<String> listarListas(String nickUsuario){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickUsuario);
        Canal c = u.getCanal();
        return c.listarListas();    
    } 
    
    @Override
    public List<String> listarMG(String usuario, String video){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        Video v = c.buscarVideo(video);
        return v.listaMG();
    }
    
    public List<String> listarNMG(String usuario, String video){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        Video v = c.buscarVideo(video);
        return v.listaNMG();
    }
    
    public List<DTLista> listasParticulares(String usuario){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        return c.listasParticulares();
    }
    
    public List<String> listarVideosLista(String usuario, String lista){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        Lista l = c.buscarLista(lista);
        return l.listarVideosEnLista();
    }
    
    public DTSesion getUserSession(String identificador, String pass){
        Manejador M=Manejador.getinstance();
        return M.getUserSession(identificador, pass);
    } 
    
    public void bajaUsuario(String nickname){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickname);
        if(u != null){
            u.setEliminado(true);
            EntityManager em = Manejador.getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(u);
            tx.commit();
        }
    }
    
    
    public boolean nicknameLibre(String nickname){
        Manejador M=Manejador.getinstance();
        return M.nicknameLibre(nickname);
    }
    
    
    public boolean mailLibre(String mail){
        Manejador M=Manejador.getinstance();
        return M.mailLibre(mail);
    }
}

