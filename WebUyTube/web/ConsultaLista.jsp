<%-- 
    Document   : ConsultaLista
    Created on : 18-oct-2019, 15:51:14
    Author     : visua
--%>

<%@page import="logica.Lista"%>
<%@page import="logica.DT.DTLista"%>
<%@page import="logica.DT.DTUsuario"%>
<%@page import="java.util.List"%>
<%@page import="logica.DT.DTCategoria"%>
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
        <title>Consulta Lista</title>
        <style>
            body{
              background-image: url("./imagenes/lluviaPro.jpg");
            }
        </style>
    </head>
    <body>
        
        <form action="ConsulLis" method="POST">
            <center>
            <div id="Contenedor1">
                <%
                    Manejador m = Manejador.getinstance();      
                    List<Lista> Lis = m.getAllListas();
                %> 
            <select name="ComboUser" id="ComboUser" style='width:200px; height:50px'>
              <%
            if(Lis != null)
            {
                for(Lista dc: Lis)
                {
                    %> 
                     <option value="<%=dc.getNombre()%>"><%=dc.getNombre()%></option>
                    <%
                }
            }
            %>
            <input type="submit" name="BotonConsultar" value="Consultar" id="BotonCatego" style='width:200px; height:50px'>
            </div>    
            </center>
        </form>
    </body>
</html>
