<%-- 
    Document   : AgregarVideoLista
    Created on : 28-oct-2019, 2:39:00
    Author     : MarianoC
--%>

<%@page import="logica.Video"%>
<%@page import="logica.Lista"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="logica.Manejador"%>
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
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
            body{
              background-image: url("./imagenes/lluviaPro6.jpg");
            }
        </style>
    </head>
    <body>
        <%
            String usuarioLogueado = (String) request.getSession().getAttribute("usuario");
            Usuario infoLogueado = (Usuario) request.getSession().getAttribute("infoLogueado");
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioConsult");
              
            %>
            
            <%
                Manejador m = Manejador.getinstance();      
                List<Lista> Lis = infoLogueado.getCanal().getListas();
            %> 
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
            <center>             
            <div class="card" style="width:200px; height:50px; margin: 10px;">
                <ul class="list-group list-group-flush">
                    <center> 
                    <li class="list-group-item"><a href="/WebUyTube/AgregarVideoListajsp" role="button">Agregar Video a Lista</a></li>
                    <li class="list-group-item"><a href="/WebUyTube/QuitarVideoLista.jsp" role="button">Quietar Video de Lista</a></li>
                    </center> 
                </ul>
            </div>

            </center> 

            <footer>
                 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
                 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
             </footer>
    </body>
</html>
