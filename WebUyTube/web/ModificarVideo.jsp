<%@page import="WSDL_generado.VideoArray"%>
<%@page import="WSDL_generado.Video"%>
<%@page import="WSDL_generado.Canal"%>
<%@page import="WSDL_generado.Usuario"%>
<%@page import="WSDL_generado.DtCategoria"%>
<%@page import="WSDL_generado.DtCategoriaArray"%>
<%@page import="WSDL_generado.Publicador"%>
<%@page import="WSDL_generado.PublicadorService"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Servlets.Login"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    
    DtCategoriaArray cat1 = port.getCategorias();
    List<DtCategoria> DtCat = cat1.getItem();
    Usuario usr = Login.getUsuarioLogueado(request);
    
    if (usr == null){
         out.println("<html><body onload=\"alert ('Debes iniciar sesion')\"></body></html>");
        request.getRequestDispatcher("login.jsp").include(request, response);
    }
    else{
        
    Canal c = usr.getCanal();
    String nomVideo = request.getParameter("v");
    VideoArray videosA = port.getVideos();
    List<Video> videos = videosA.getItem();
    Video video = null;
    for (Video v : videos){
        if (v.getNombre().equals(nomVideo))
            video = v;
    }
    
    String cat = video.getCategoria().getNombre();
    
    Date f = new Date();
    f.setDate(video.getFecha().getDay());
    f.setMonth(video.getFecha().getMonth());
    f.setYear(video.getFecha().getYear());
  
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(f);
%> 

<!DOCTYPE html>
<html>
    <head>
        <!--FONT AWESOME-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- GOOGLE FONT-->
        <link href="https://fonts.googleapis.com/css?family=Be+Vietnam&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./resources/css/css.css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Video</title>
        <style>
            body{
                background-color: #686869;
            }
        </style>
    </head>
    <body>
        
        <header>
            <nav class="navbar navbar-light bg-light ">
                <img class="logo" src="./imagenes/logo2.png">
                <form class="form-inline mx-auto" method="POST" action="BusVideos">
                    <input name="TextoFiltro" class="form-control mr-sm-2" type="search" placeholder="video, lista, canal" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">buscar</button>
                    <select class="btn btn-outline-success my-2 my-sm-0" name="ComboOpciones" id="ComboCatego" style='margin: 4px; width:150px; height:40px'>
                        <option value="SinFiltro">Sin Filtro</option>
                        <option value="Categoria">Categoría</option>
                        <option value="ListReproduccion">Lista de Reproducción</option>
                        <option value="Canal">Canal</option>
                    </select>
                </form> 
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%= usr.getNickname() %>
                    </button>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="MiPerfil">Mi perfil</a>
                        <a class="dropdown-item" href="/WebUyTube/ModificarUsuario.jsp">Modificar datos de usuario</a>
                        <a class="dropdown-item" href="BajaUsuario">Darse de baja</a>
                        <a class="dropdown-item" href="Logout">Cerrar sesión</a>
                    </div>
                </div>     
            </nav>   
        </header>

                    
        
                    
        <div class="contenedorGeneral">
            <!--       menu      -->
            <div class="menu">

                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">USUARIOS:</li>
                        <li class="list-group-item"><a href="/WebUyTube/consultausuario.jsp" role="button">Consulta de usuario</a></li>
                    </ul>
                </div>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">VIDEOS:</li>
                        <li class="list-group-item"><a href="/WebUyTube/altaVideo.jsp" role="button">Subir video</a></li>
                        <li class="list-group-item"><a href="#" role="button">Ver videos</a></li>
                    </ul>
                </div>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">LISTAS:</li>
                        <li class="list-group-item"><a href="#" role="button">Crear lista</a></li>  
                        <li class="list-group-item"><a href="#" role="button">Ver más tarde</a></li>
                        <li class="list-group-item"><a href="#" role="button">Me gusta</a></li>
                        <li class="list-group-item"><a href="#" role="button">Música para estudiar</a></li>
                    </ul>
                </div>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">CATEGORÍAS:</li>
                        <li class="list-group-item"><a href="#" role="button">Consulta de categoría</a></li>
                        <li class="list-group-item"><a href="#" role="button">listar categorias existentes</a></li>

                    </ul>
                </div>
            </div>
            <div class="contenedorInfo">
                <h3><% out.println(video.getNombre());%></h3>
                    <form action="ModificarVideo" method="POST">
                        <input name="nomVideo" type="hidden" value=<% out.println(video.getNombre());%>>
                        <div class="form-group">
                            <input id="nombre" type="text" name='nombre' placeholder="Nombre" class='form-control' autofocus required value=<%out.println(video.getNombre()); %>>
                        </div>
                        <div class="form-group">
                            <input id="descripcion" type="text" name='descripcion' placeholder="Descripcion" class='form-control' required value=<%out.println(video.getDescripcion()); %>> 
                        </div>
                        <div class="form-group">
                            <input type="text" name='duracion' placeholder="Duracion" class='form-control' required value=<%out.println(video.getDuracion()); %>>
                        </div>
                        <div class="form-group">
                            <input type="date" name='fecha' placeholder="Fecha" class='form-control' required value=<%out.print(date);%>>
                        </div>
                        <div class="form-group">
                            <input type="url" name='url' placeholder="URL" class='form-control' required value=<%out.println(video.getUrl()); %>>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="privado" value="privado" <%if(video.isPrivado()) out.print("checked");%>> Privado <br>
                        </div> 
                        <div class="form-group">
                            <select name="ComboCat" id="ComboCatego" style='width:200px; height:50px'>
                                <%
                              if(DtCat != null){
                                  for(DtCategoria dc: DtCat){
                                      %> 
                                      <option value="<%=dc.getNombre()%>" <%if(dc.getNombre().equals(cat)) out.print("selected");%> ><%=dc.getNombre()%></option>
                                      <%
                                  }
                              }%>
                              </select>
                        </div>
                        <div class="form-group">
                            <input id="botonConfirmar" type="submit" value="Confirmar" class='button'>
                        </div>
                    </form>
            </div>

        <footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
    </body>
</html>
<%}%>