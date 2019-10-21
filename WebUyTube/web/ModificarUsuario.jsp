
<%@page import="logica.DT.DTLista"%>
<%@page import="logica.DT.DTVideo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.DT.DTCanal"%>
<%@page import="logica.DT.DTUsuario"%>

<%
    //DTUsuario usuario = (DTUsuario) request.getAttribute("userInfo");
    //DTCanal canal = usuario.getCanal();
    logica.DT.DTCanal canal = new DTCanal("canal", "desc", true, null, null);
    
    DTUsuario usuario = new DTUsuario("Gime", "123", "gimena", "Deleon", "gime@gmail.com", new Date(), "", canal, false);

%>

<%
    List<DTVideo> videos = canal.getVideos();
    List<DTLista> listas = canal.getListas();
    List<String> seguidores = usuario.getSeguidores();
    List<String> seguidos = usuario.getSeguidos();
    
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
        <script src="resources/js/pestanas.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% //out.println(usuario.getNickname()); %></title>
    </head>
    <body>
        
        <header>
            <nav class="navbar navbar-light bg-light ">
                <img class="logo" src="./imagenes/logo.png">
                <form class="form-inline mx-auto">
                    <input class="form-control mr-sm-2" type="search" placeholder="video, lista, canal" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">buscar</button>
                </form>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${UserNick}
                    </button>
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
                        <li class="list-group-item"><a href="#" role="button">Subir video</a></li>
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
                    <h2>Datos Usuario</h2>
                    <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar rounded-circle img-thumbnail" alt="avatar">
                    <h6>Cambiar foto</h6>
                    <input type="file" class="text-center center-block file-upload">
                </div></hr><br>
                <div>
                   <form action="ModificarUsuario" method="POST">
                                <div class="form-group">
                                    <%out.println("<p> Nickname: " + usuario.getNickname()+ "</p>");%>
                                </div>
                                <div class="form-group">
                                    <%out.println("<p>Email: " + usuario.getEmail()+ "</p>");%>
                                </div>
                                <div class="form-group">
                                    <label>Contraseña: <input type="password" id="contra" name='pass' class='form-control' value = <%out.println(usuario.getContrasenia());%> required onkeyup="HabilitarBoton();"> </label>
                                </div>
                                <div class="form-group">
                                    <label>Confirmar contraseña: <input type="password" id="contra2" name='confirmacion_contraseña' class='form-control' value = <%out.println(usuario.getContrasenia());%> required onkeyup="HabilitarBoton();"> </label> <div id="passMatch"> </div>
                                </div>
                                <div class="form-group">
                                    <label>Nombre: <input type="text" id="Nombre" class="form-control" name='Nombre' value= <%out.println(usuario.getNombre()); %> ></label>
                                </div>
                                <div class="form-group">
                                    <label>Apellido: <input type="text" id="Apellido" class="form-control" name='Apellido' value= <%out.println(usuario.getApellido()); %> ></label>
                                </div>
                                <div class="form-group">
                                    <label>Fecha: <input type="date" id="Fecha" class="form-control" name='Fecha' date= <%usuario.getFechaNac(); %> ></label>
                                </div>
                                <div class="form-group">
                                    <h4>Canal</h4>
                                </div>
                                 <div class="form-group">
                                    <label>Nombre: <input type="text" id="NombreCanal" class="form-control" name='NombreCanal' value= <%out.println(usuario.getCanal().getNombre()); %>></label>
                                </div>
                                <div class="form-group">
                                    <label>Descripcion: <input type="text" id="DescCanal" class="form-control" name='DescCanal' value= <%out.println(usuario.getCanal().getDesc()); %>></label>
                                </div>
                                <div class="form-group">
                                    <label>Privado <input type="checkbox" id="privado" name="privado" class="form-control" <%if (usuario.getCanal().isPrivado()) out.println("checked"); %> ></label>
                                </div> 
                                <div class="form-group">
                                    <button class= "button">Confirmar</button>
                                </div> 
                            </form>
                    <div class="tabs">
                        <ul class="tab-links">
                            <li class="active"><a href="#tab1">Videos</a></li>
                            <li><a href="#tab2">Listas</a></li>
                            <li><a href="#tab3">Seguidores</a></li>
                            <li><a href="#tab4">Seguidos</a></li>
                        </ul>

                        <div class="tab-content">
                            <div id="video" class="tab active">
                                <ul>
                                    <%if (videos != null && videos.size() > 0) {%>
                                    <%for (DTVideo v : videos) {%>  
                                    <h6><% out.print(v.getUrl()); %></h6>
                                    <% } %>
                                    <% } else { %>
                                    <h1>No se encontraron videos</h1>
                                    <% } %>
                                </ul>
                                
                                <p>Donec pulvinar neque sed semper lacinia. Curabitur lacinia ullamcorper nibh; quis imperdiet velit eleifend ac. Donec blandit mauris eget aliquet lacinia! Donec pulvinar massa interdum risus ornare mollis.</p>
                            </div>

                            <div id="tab2" class="tab">
                                <p>Tab #2 content goes here!</p>
                                <p>Donec pulvinar neque sed semper lacinia. Curabitur lacinia ullamcorper nibh; quis imperdiet velit eleifend ac. Donec blandit mauris eget aliquet lacinia! Donec pulvinar massa interdum risus ornare mollis. In hac habitasse platea dictumst. Ut euismod tempus hendrerit. Morbi ut adipiscing nisi. Etiam rutrum sodales gravida! Aliquam tellus orci, iaculis vel.</p>
                            </div>

                            <div id="tab3" class="tab">
                                <p>Tab #3 content goes here!</p>
                                <p>Donec pulvinar neque sed semper lacinia. Curabitur lacinia ullamcorper nibh; quis imperdiet velit eleifend ac. Donec blandit mauris eget aliquet lacinia! Donec pulvinar massa interdum ri.</p>
                            </div>

                            <div id="tab4" class="tab">
                                <p>Tab #4 content goes here!</p>
                                <p>Donec pulvinar neque sed semper lacinia. Curabitur lacinia ullamcorper nibh; quis imperdiet velit eleifend ac. Donec blandit mauris eget aliquet lacinia! Donec pulvinar massa interdum risus ornare mollis. In hac habitasse platea dictumst. Ut euismod tempus hendrerit. Morbi ut adipiscing nisi. Etiam rutrum sodales gravida! Aliquam tellus orci, iaculis vel.</p>
                            </div>
                        </div>
                    </div>
                </div>

        <footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
    </body>
</html>
