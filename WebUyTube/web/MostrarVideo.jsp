<%-- 
    Document   : MostrarVideo
    Created on : 28-oct-2019, 16:24:23
    Author     : visua
--%>

<%@page import="Servlets.Login"%>
<%@page import="logica.DT.DTLista"%>
<%@page import="logica.Lista"%>
<%@page import="logica.DT.DTComentario"%>
<%@page import="logica.ISistema"%>
<%@page import="logica.Fabrica"%>
<%@page import="logica.Usuario"%>
<%@page import="logica.Comentario"%>
<%@page import="logica.Video"%>
<%@page import="java.util.List"%>
<%@page import="logica.Manejador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!--CSS ANIMATE-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
        <!--FONT AWESOME-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- GOOGLE FONT-->
        <link href="https://fonts.googleapis.com/css?family=Be+Vietnam&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./resources/css/css.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="resources/js/CheckMailUse.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
            body{
                background-color:  #656776;
            }
        </style>
        
        <script type="text/javascript">
            function Refrescar() {
                String NomVid = document.getElementById("");  
                request.setAttribute("Nombre", NomVid);
            }
        </script>
    </head>
    <body>
        <%
         Usuario infoLogueado = (Usuario) request.getSession().getAttribute("infoLogueado");
        %>
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
                    <%
                    if(infoLogueado != null)
                    {
                        %>
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%= infoLogueado.getNickname() %>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="MiPerfil">Mi perfil</a>
                            <a class="dropdown-item" href="#">Modificar datos de usuario</a>
                            <a class="dropdown-item" href="#">Darse de baja</a>
                            <a class="dropdown-item" href="Logout">Cerrar sesión</a>
                        </div>
                        <%
                    }
                    else
                    {
                        %>
                        <a class="btn btn-primary" href="/WebUyTube/login.jsp" role="button"><i class="fas fa-sign-in-alt"></i> INGRESAR</a>
                        <%
                    }
                    %>
                    
                </div>     
            </nav>   
        </header>
        <%
            Manejador m = Manejador.getinstance();
            List<Video> Vid = m.getVideos();         
            for(int i=0; i<Vid.size(); i++)
            {
                if(Vid.get(i).getNombre().equals(request.getAttribute("Nombre")))
                {
                    %>
                    <centre>                        
                    <video contextmenu contenteditable controls src="<%=Vid.get(i).getUrl()%>" style="width: 650px; height: 370px;border: 5px solid black; margin: 15px"></video>
                    <div style=" margin: 15px; width: 650px; height: 150px">
                    <form action="MostVideoControl" method="POST">   
                        <input class="btn btn-primary" type="submit" name="BotonMG" value="Me Gusta" id="BotonCatego" style='width:150px; height:30px'>
                        <input class="btn btn-primary" type="submit" name="BotonNMG" value="No me Gusta" id="BotonCatego" style='width:150px; height:30px'>
                        <%   
                        if(infoLogueado != null)
                        {
                            %>
                                <input class="btn btn-primary" type="submit" name="BotonAgregar" value="Agregar a Lista" id="BotonCatego" style='width:150px; height:30px'>
                                <select class="btn btn-outline-success my-2 my-sm-0" name="ComboListas" id="ComboCatego" style='width:150px; height:30px'>
                                <%    
                                List<Lista> listas = m.getListas(infoLogueado.getNickname());
                                if(listas != null)
                                {
                                    for(Lista dc: listas)
                                    {
                                        %> 
                                            <option value="<%=dc.getNombre()%>"><%=dc.getNombre()%></option>
                                        <%
                                    }
                                }
                                %>
                                </select>
                            <%
                        }
                        %>
                        <br>
                        <br>
                        <div style="width: 650px; height: 150px">
                            <text name="NombreVideo1" rows=5 cols=40 style=" margin: 10px; width: 300px; height: 50px; color: white;">Nombre: <%=Vid.get(i).getNombre()%></text>
                            <br>
                            <text name="comment" rows=5 cols=40 style=" margin: 10px; width: 300px; height: 50px; color: white;">Descripción: <%=Vid.get(i).getDescripcion()%></text>
                        </div>
                        <%
                        if(infoLogueado != null)
                        {
                            %>
                                <textarea style="border: solid black;" name="Comentario1" id="Comentar1" rows=4 cols=80></textarea>
                                <br>
                                <input class="btn btn-primary" target="_self" style="float: left; font-family: Arial; font-size: 8pt;width:150px; height:25px" type="submit" name="BotonComentar1" value="Comentar" id="BotonCatego">
                            <%
                        }
                        else
                        {
                            %>
                            <label style="margin: 15px">PARA PODER REALIZAR UN COMENTARIO DEBE LOGUEARSE</label>
                            <%
                        }
                        %>
                        <br>
                        <input class="btn btn-primary" style="float: left; font-family: Arial; font-size: 8pt;width:60px; height:20px" type="hidden" name="BotonComent" value="<%=request.getAttribute("Nombre")%>" id="BotonCatego">
                        <br>
                        <div style="background-color: white; border: 5px solid black; width: 650px; height: auto">
                            <%
                                List<Video> v = m.getVideos();
                            
                                for(int i2=0; i2<v.size(); i2++)
                                {
                                    if(v.get(i2).getNombre().equals(request.getAttribute("Nombre")))
                                    {
                                        List<Comentario> c = v.get(i2).getComentarios();
                                        if(c.size()>0)
                                        {
                                            for(int i3=0; i3<c.size(); i3++)
                                            {
                                                %>
                                                <div style="background-color: white; border: 1px solid black; width: 640px; height: auto">
                                                    <div>
                                                        
                                                        <img src="<%=c.get(i3).getUsuario().getImagen()%>" style="margin: 4px; width: 2px; height: 2px; float: left;"></img>
                                                        <text name="comment" style="color: black; float: top;"><p><font size="1">*<%=c.get(i3).getUsuario().getNickname()%> <%=c.get(i3).getFecha()%></font></p></text>
                                                        <text name="com1" style="color: black; float: top;"><%=c.get(i3).getTexto()%></text> 
                                                        <%
                                                        if(infoLogueado != null)
                                                        {
                                                            %>    
                                                                <br>
                                                                <textarea id="Comentar" name="<%= Integer.toString(c.get(i3).getId())%>" style="float: left; font-family: Arial; font-size: 8pt; width:200px; height:25px"></textarea>
                                                                <button value="<%=c.get(i3).getId()%>" type="submit" name="BotonSubComentar" style="float: left; font-family: Arial; font-size: 8pt;width:100px; height:25px">Comentar</button>                                 
                                                            <%
                                                        }
                                                        else
                                                        {
                                                            %>
                                                            <br>
                                                            <label>PARA PODER REALIZAR UN SUB_COMENTARIO DEBE LOGUEARSE</label>
                                                            <%
                                                        }
                                                        %>
                                                        <br>
                                                        <p style="color: black; float: top;"><font size="1">//Subcomentarios</font></p>
                                                    </div>
                                                    <%
                                                    List<Comentario> c1 = c.get(i3).getHijos();    
                                                    if(c1.size()>0)
                                                    {
                                                        for(int i4=0; i4<c1.size(); i4++)
                                                        {
                                                            %>
                                                            <div style="background-color: #818183; color: white; float: top; border: 1px solid black;">
                                                                <img src="<%=c1.get(i4).getUsuario().getImagen()%>" style="margin: 4px; width: 2px; height: 2px; float: top;"></img>
                                                                <text name="comment" style="color: black; float: top;"><p><font size="1">**<%=c1.get(i4).getUsuario().getNickname()%> <%=c1.get(i4).getFecha()%></font></p></text>
                                                                <text name="TextoSubComentario" style="color: black; float: top;"><p><font size="2"><%=c1.get(i4).getTexto()%></font></p></text>
                                                            </div>
                                                            <%

                                                        }

                                                    }
                                                    %>
                                                     <br>
                                                </div>     
                                                <%
                                            }
                                            
                                        }
                                        else
                                        {
                                            %>
                                            <div style="background-image: url('./imagenes/Textura6.jpg'); border: 5px solid black; width: 650px; height: auto;">
                                                <text name="comment" rows=5 cols=40 style="margin: 4px; color: white; float: left;">No hay Comentarios</text> 
                                            </div>
                                            <%
                                        }
                                        
                                        break;
                                    }    
                                }    
                            %>
                        </div>
                     <br>
                    </form>
                    </div>     
                    </centre>
                    <%
                }
            }
        %>
        
    </body>
</html>
