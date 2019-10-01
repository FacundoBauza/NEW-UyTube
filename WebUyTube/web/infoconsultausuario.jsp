<%-- 
    Document   : infoconsultausuario
    Created on : 30/09/2019, 08:01:53 PM
    Author     : Usuario
--%>

<%@page import="logica.Canal"%>
<%@page import="logica.DT.DTUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DTUsuario usuario = (DTUsuario) request.getAttribute("userInfo");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.println(usuario.getNickname()); %></title>
    </head>
    <body>
        <img src="<%out.println(usuario.getImagen().substring(14));%>" width="200" height="200" alt="Imagen de usuario"/>
        <h3>Datos</h3>
        <div>
            <ul>
            <%
                out.println("<li>Nick: " + usuario.getNickname()+ "</li>");
                out.println("<li>Nombre: " + usuario.getNombre()+ "</li>");
                out.println("<li>Apellido: " + usuario.getApellido() + "</li>");
                out.println("<li>Canal " + usuario.getCanal()+ "</li>");
                
                
            %>
            </ul>
        </div>
        
    </body>
</html>
