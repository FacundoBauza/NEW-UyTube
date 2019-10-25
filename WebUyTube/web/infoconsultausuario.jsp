<%-- 
    Document   : infoconsultausuario
    Created on : 30/09/2019, 08:01:53 PM
    Author     : Usuario
--%>

<%@page import="Servlets.Login"%>
<%@page import="logica.Lista"%>
<%@page import="logica.Video"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="logica.Canal"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <script src="resources/js/pestanas.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info usuario</title>
    </head>
    <body>
    <%

        Usuario usuario = (Usuario) request.getAttribute("usuario");
        Canal canal = usuario.getCanal();
        List<Video> videos = canal.getVideos(); 
        List<Lista> listas = canal.getListas();
        List<Usuario> seguidores = usuario.getSeguidores();
        List<Usuario> seguidos = usuario.getSeguidos();


    %>
        
        <header>
            <nav class="navbar navbar-light bg-light ">
                <img class="logo" src="./imagenes/logo.png">
                <form class="form-inline mx-auto">
                    <input class="form-control mr-sm-2" type="search" placeholder="video, lista, canal" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">buscar</button>
                </form>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%= usuario.getNickname() %>
                    </button>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="MiPerfil">Mi perfil</a>
                        <a class="dropdown-item" href="ModificarUsuario.jsp">Modificar usuario</a>
                        <a class="dropdown-item" href="#">Darse de baja</a>
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
                        <li class="list-group-item"><a href="ListarUsuarios" role="button">Consulta de usuario</a></li>
                    </ul>
                </div>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">VIDEOS:</li>
                        <li class="list-group-item"><a href="altaVideo.jsp" role="button">Subir video</a></li>
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
                
                <div class="text-center">
                    <% if(request.getSession().getAttribute(usuario.getNickname())!= null) {%>
                    <div class="botonesSeguir">
                        <a href="#" class="btn btn-success btn-lg active" role="button" aria-pressed="true">Seguir</a>
                        <a href="#" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Dejar de seguir</a>
                    </div>  
                    <% } %>
                        
                    <h1>Datos Usuario</h1>
                    <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar rounded-circle img-thumbnail" alt="avatar">
                    <h6>Cambiar foto</h6>
                    <input type="file" class="text-center center-block file-upload">
                </div></hr><br>
                <div>
                    <ul>
                        <%
                            out.println("<li>Nick: " + usuario.getNickname() + "</li>");
                            out.println("<li>Nombre: " + usuario.getNombre() + "</li>");
                            out.println("<li>Apellido: " + usuario.getApellido() + "</li>");
                            out.println("<li>Canal: " + usuario.getCanal().getNombre() + "</li>");
                            out.println("<li>Canal descripcion: " + usuario.getCanal().getDesc() + "</li>");
                        %>
                    </ul>

                    <h3>Videos</h3>
                    <div>
                        <ul>
                            <%if (videos != null && videos.size() > 0) {%>
                            <%for (Video v : videos) {%>  
                            <h6><% out.print(v.getUrl()); %></h6>
                            <% } %>
                            <% } else { %>
                            <h5>No se encontraron videos</h5>
                            <% }%>
                        </ul>
                    </div>
                    <h3>Listas</h3>
                    <div>
                        <ul>
                            <%if (listas != null && listas.size() > 0) {%>
                            <%for (Lista l : listas) {%>  
                            <h6><% out.print(l.getNombre()); %></h6>
                            <% } %>
                            <% } else { %>
                            <h5>No se encontraron listas</h5>
                            <% } %>
                        </ul>
                    </div>
                    <h3>Seguidores</h3>
                    <div>
                        <ul>
                            <%if (seguidores != null && seguidores.size() > 0) {%>
                            <%for (Usuario s : seguidores) {%>  
                            <h6><% out.print(s.getNickname()); %></h6>
                            <% } %>
                            <% } else { %>
                            <h5>No se encontraron seguidores</h5>
                            <% }%>
                        </ul>
                    </div>
                    <h3>Seguidos</h3>
                    <div>
                        <ul>
                            <%if (seguidos != null && seguidos.size() > 0) {%>
                            <%for (Usuario seguido : seguidos) {%>  
                            <h6><% out.print(seguido.getNickname()); %></h6>
                            <% } %>
                            <% } else { %>
                            <h5>No se encontraron seguidos</h5>
                            <% }%>
                        </ul>
                    </div>
                </div>
                    
                    
                    

        
        
        
    
    <footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
    </body>
</html>
