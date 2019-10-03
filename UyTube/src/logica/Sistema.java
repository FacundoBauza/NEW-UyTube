package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
    public void altaUsuario(DTUsuario u, DTCanal c){
        List<Lista> listas = new ArrayList();
        Manejador m = Manejador.getinstance();
        List<String> listasNombres = m.getListasPorDefecto();
        if(!listasNombres.isEmpty()){
            Lista list;
            for(String l : listasNombres){
                list = new Lista(l, true, true, null);
                listas.add(list);
            }
        }
        String nombre;
        nombre = c.getNombre();
        Canal canal = new Canal(nombre, c.getDesc(), c.isPrivado(), listas);
        Usuario usuario = new Usuario(u.getNickname(), u.getContrasenia(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNac(), u.getImagen(), canal);
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
    
    public void modificarUsuario(String nickname, String contrasenia, String nombre, String apellido, Date fechaNac, String imagen, String canal){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickname);
        u.setContrasenia(contrasenia);
        Canal c = u.getCanal();
        u.setApellido(apellido);
        u.setCanal(c);
        u.setFechaNac(fechaNac);
        u.setImagen(imagen);
        u.setNombre(nombre);
        
    }
    
    public void altaVideo(DTVideo video, String usuario){
        Manejador m = Manejador.getinstance();
        Categoria cat = null;
        if (video.getCategoria() != null)
            cat = m.buscarCategoria(video.getCategoria());
        Video v = new Video(video.getNombre(), video.getDescripcion(), video.getDuracion(),
                video.getFecha(), video.getUrl(), video.isPrivado(), cat);
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        c.addVideo(v);
    }
    
    public void modificarVideo (DTVideo video, String usuario, String nomVideo){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        Video v = c.buscarVideo(nomVideo);
        v.setNombre(video.getNombre());
        v.setDescripcion(video.getDescripcion());
        v.setDuracion(video.getDuracion());
        v.setFecha(video.getFecha());
        v.setUrl(video.getUrl());
        v.setPrivado(video.isPrivado());
        
    }

    public void altaLista(DTLista lista, String usuario){ // particular valga la redundancia
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        Lista l;
        Categoria cat = m.buscarCategoria(lista.getCategoria());
        Lista list = c.buscarLista(lista.getNombre());
        if(list == null){
            l = new Lista(lista.getNombre(), false, lista.isPrivado(), cat );
            c.addLista(l);   
        }          
    }
    
    public void altaListaPorDefecto(DTLista lista){
        Manejador m = Manejador.getinstance();
        List<DTUsuario> usuarios = m.getUsuarios();
        Usuario u;
        Lista l;
        Canal c;
        for (DTUsuario usuario : usuarios){
            u = m.buscarUsuario(usuario.getNickname());
            c = u.getCanal();
            Lista list = c.buscarLista(lista.getNombre());
            if(list == null){
                l = new Lista(lista.getNombre(), true, true, null);
                c.addLista(l);
            }
        }
        m.addLista(lista.getNombre());
    }
    
    public void modificarListaPart(String usuario, String nombreLista, String categoria, Boolean privado){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
         if (u == null)
            System.out.println("no hay usuario");
        Canal c = u.getCanal();
        if (c == null)
            System.out.println("no hay canal");
        Categoria cat = m.buscarCategoria(categoria);
         if (cat == null)
            System.out.println("no hay categoria");
        Lista listaModificar = c.buscarLista(nombreLista);
         if (listaModificar == null)
            System.out.println("no hay lista");
        listaModificar.setCategoria(cat);
        listaModificar.setPrivado(privado);
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
        //c2.addVideo(v); 
    }
    
    public void quitarVideoDeLista(String usuario, String video, String nombreLista){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal c = u.getCanal();
        c.listarListas();
        Lista listaQuitarVideo= c.buscarLista(nombreLista);
        listaQuitarVideo.listarVideosEnLista();
        Video videoQuitar = listaQuitarVideo.buscarVideoEnLista(video);
        listaQuitarVideo.removeVideo(videoQuitar);   
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
                v.isPrivado(), v.getCategoria().getNombre());  
    }    
        

    public void comentarVideo(String usuario,DTComentario comentario,String video, int padre){
        Manejador m = Manejador.getinstance();
        Usuario usuarioVideo = m.buscarUsuario(usuario);
        Canal canal = usuarioVideo.getCanal();
        List<Video> videos = canal.getVideos();
        Video v = canal.buscarVideo(video);
        Usuario usuarioCom = m.buscarUsuario(comentario.getUsuario());
        Comentario c = new Comentario(comentario.getTexto(), usuarioCom);
        Comentario comPadre = null;
        if (padre != 0)
            comPadre = v.buscarComentario(padre);
        if (comPadre != null)
            comPadre.addHijo(c);
        else
            v.addComentario(c);  
    }
    
    public void valorarVideo(String usuario,String video, DTValoracion valoracion ){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(usuario);
        Canal canal = u.getCanal();
        Video v = canal.buscarVideo(video);
        Usuario uValora = m.buscarUsuario(valoracion.getUsuario());
        Valoracion valora = new Valoracion(valoracion.isMeGusta(), uValora , v);
        uValora.addValoracion(valora);
        v.addValoracion(valora);
    }
    
    public void seguirUsuario(String nickSeguidor, String nickSeguido){
         Manejador m = Manejador.getinstance();
         Usuario seguidor = m.buscarUsuario(nickSeguidor);
         Usuario seguido = m.buscarUsuario(nickSeguido);
         if(seguidor!=null && seguido!=null){
            seguido.addSeguidor(seguidor);
            seguidor.addSeguido(seguido);
         } 
    }
    
    public void dejarDeSeguirUsuario(String nickSeguidor, String nickSeguido){
        Manejador m = Manejador.getinstance();
        Usuario seguidor = m.buscarUsuario(nickSeguidor);
        Usuario seguido = m.buscarUsuario(nickSeguido);
        if(seguidor!=null && seguido!=null){
            seguido.removeSeguidor(seguidor);
            seguidor.removeSeguido(seguido);
        }
    }
    
   
    public List<String> listarVideos(String nickUsuario){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickUsuario);
        Canal c = u.getCanal();
        return c.listarVideos();    
    } 
    
    public List<String> listarListas(String nickUsuario){
        Manejador m = Manejador.getinstance();
        Usuario u = m.buscarUsuario(nickUsuario);
        Canal c = u.getCanal();
        return c.listarListas();    
    } 
    
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
    
    
}

