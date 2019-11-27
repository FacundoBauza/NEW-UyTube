<%-- 
    Document   : homeLogIn
    Created on : 01/10/2019, 04:24:44 PM
    Author     : Usuario
--%>

<%@page import="WSDL_generado.Usuario"%>
<%@page import="WSDL_generado.StringArray"%>
<%@page import="WSDL_generado.VideoArray"%>
<%@page import="WSDL_generado.Video"%>
<%@page import="WSDL_generado.Publicador"%>
<%@page import="WSDL_generado.PublicadorService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Servlets.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        Usuario usr;
        try {
                usr = Login.getUsuarioLogueado(request);
        } catch(Exception ex){
                usr = null;
        }

        if(usr != null) {
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
        <title>UyTube</title>
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

        <!--  menu-->
        <div class="menu">
            
            <div class="card" style="width: 18rem;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">USUARIOS:</li>
                    <li class="list-group-item"><a href="consultausuario.jsp" role="button">Consulta de usuario</a></li>
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
                     <li class="list-group-item"><a href="/WebUyTube/ModificarLista.jsp" role="button">Modificar Lista</a></li>
                    <li class="list-group-item"><a href="#" role="button">Ver más tarde</a></li>
                    <li class="list-group-item"><a href="#" role="button">Me gusta</a></li>
                    <li class="list-group-item"><a href="#" role="button">Música para estudiar</a></li>
                    <li class="list-group-item"><a href="/WebUyTube/ConsultaLista.jsp" role="button">Consulta de Lista de Reproducción</a></li>
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
        
        <%%>
        
        <%
            PublicadorService service = new PublicadorService();
            Publicador port = service.getPublicadorPort();
    
            List<Video> aux = null;
            VideoArray videos = port.getVideos();
            List<Video> l = videos.getItem();
            StringArray categorias = port.listarCategorias();
            List<String> l2 = categorias.getItem();
            
            %>        
                <div id="capsulaVid" align="center" style="width: 80rem; margin: 10px">
                    <ul class="list-group list-group-flush">
                    <%
                        for(int i=0; i<l2.size(); i++)
                        {
                            int cont = 0;
                            for(int i3=0; i3<l.size(); i3++)
                            {
                                if(l.get(i3).getCategoria().getNombre().equals(l2.get(i)))
                                    cont++;
                            }
                            if(cont > 0)
                            {
                                %>        
                                <li><%=l2.get(i)%></li>
                                <li style=" border: solid black; background-color: white;">
                                <%
                                for(int i2=0; i2<l.size(); i2++)
                                {
                                    if(l.get(i2).getCategoria().getNombre().equals(l2.get(i)))
                                    {
                                        %>
                                        <div style="margin: 25px; width: 200px; height: 150px; float: left;">
                                            <form action="MostVideo" method="POST">
                                            <input type="hidden" name="NomVid" value="<%=l.get(i2).getNombre()%>"/>
                                            <video src="<%=l.get(i2).getUrl()%>" style='margin: 2px; border: solid black; width: 170px; height: 98px; float: top'></video>
                                            <br>
                                            <input class="btn btn-link"  type="submit" value="<%=l.get(i2).getNombre()%>" style='width: 200px; height: auto; float: left'/>
                                            </form>
                                        </div>
                                        <%
                                    }
                                }
                                %>
                                </li>
                                <br>
                                <%
                            }
                            aux = null;
                        }
                    %>
                    </ul>
                </div>    
                <%
        %>
        <!--    -----------     -->
        <footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
    <% } %>    
    </body>
</html>

