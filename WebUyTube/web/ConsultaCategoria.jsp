<%-- 
    Document   : ConsultaCategoria
    Created on : 18-oct-2019, 15:52:05
    Author     : visua
--%>

<%@page import="logica.Manejador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logica.DT.DTCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
              background-image: url("./imagenes/lluviaPro.jpg");
            }
        </style>
    </head>
    <body>
        
        <form action="ConsulCat" method="POST">
            <center>
            <div id="Contenedor1">
            <%
                Manejador m = Manejador.getinstance();      
                List<DTCategoria> DtCat = m.getCategorias();
            %> 
            <select name="ComboCat" id="ComboCatego" style='width:200px; height:50px'>
              <%
            if(DtCat != null)
            {
                for(DTCategoria dc: DtCat)
                {
                    %> 
                     <option value="<%=dc.getNombre()%>"><%=dc.getNombre()%></option>
                    <%
                }
            }
            %>
            </select>
            <input type="submit" name="BotonConsultar" value="Consultar" id="BotonCatego" style='width:200px; height:50px'>
            </div>    

            </center>
        </form>
    </body>
</html>
