<%-- 
    Document   : AgregarVideoLista
    Created on : 28-oct-2019, 2:50:25
    Author     : MarianoC
--%>

<%@page import="logica.Lista"%>
<%@page import="java.util.List"%>
<%@page import="logica.Manejador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        String usuarioLogueado = (String) request.getSession().getAttribute("usuario");
            Usuario infoLogueado = (Usuario) request.getSession().getAttribute("infoLogueado");
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioConsult");
              
            %>
            
                <center>
                <div id="Contenedor1">
                    <%
                        Manejador m = Manejador.getinstance();      
                        List<Lista> Lis = infoLogueado.getCanal().getListas();
                    %> 
                <p style="color: white">Modificar privacidad de la/s lista/s de reproducci&oacute;n.</p>
                <p style="color: white">Elija la lista a modificar:</p>
                <br>
                <select name="ComboLista" id="ComboUser" style='width:200px; height:50px'>
                <%
                if(Lis != null)
                {
                    for(Lista dc: Lis)
                    {
                        %> 
                        <option id="LisSel" value="<%=dc.getNombre()%>"><%=dc.getNombre()%></option>
                        <%
                    }
                }
                %>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"></li>
                        <li class="list-group-item"><a href="/WebUyTube/AgregarVideoListajsp" role="button">Agregar Video a Lista</a></li>
                        <li class="list-group-item"><a href="/WebUyTube/QuitarVideoLista.jsp" role="button">Quietar Video de Lista</a></li>
                    </ul>
                </div>
                
                <br>
                
                </div>    
                </center>
    </body>
</html>
