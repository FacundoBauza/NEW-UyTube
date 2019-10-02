<%-- 
    Document   : MiPerfilUsuario
    Created on : 01/10/2019, 08:54:43 PM
    Author     : Usuario
--%>

<%@page import="logica.DT.DTUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DTUsuario usuario = null;
    if (request.getSession().getAttribute("UserNick") == null) {
        response.sendRedirect("index.jsp");
    } else {
        usuario = (DTUsuario) request.getAttribute("userInfo");
    }

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
        <title>Mi perfil</title>
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
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="../src/java/Servlets/Miperfil.java">Mi perfil</a>
                        <a class="dropdown-item" href="#">Modificar datos de usuario</a>
                        <a class="dropdown-item" href="#">Darse de baja</a>
                        <a class="dropdown-item" href="#">Cerrar sesión</a>
                    </div>
                </div>     
            </nav>   
        </header>
        <%
                if(usuario!=null){
                    out.println("<img src=\""+usuario.getImagen().substring(14)+"\" height=\"200\" width=\"200\">");
                    out.println("<p> Nick: "+ usuario.getNickname() + "<br>"
                            + "Mail: " + usuario.getEmail()+ "<br>"
                            + "Nombre: " + usuario.getNombre() + "<br>"
                            + "Apellido: " + usuario.getApellido() + "<br>"
                            + "Canal " + usuario.getCanal() + "<br>");
                }            
            %>

    <footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
    </body>

</html>
