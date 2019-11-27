<%-- 
    Document   : ConsultaCategoria
    Created on : 18-oct-2019, 15:52:05
    Author     : visua
--%>

<%@page import="WSDL_generado.DtCategoriaArray"%>
<%@page import="WSDL_generado.DtCategoria"%>
<%@page import="WSDL_generado.Publicador"%>
<%@page import="WSDL_generado.PublicadorService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                PublicadorService service = new WSDL_generado.PublicadorService();
                Publicador port = service.getPublicadorPort();   
                DtCategoriaArray Cat = port.getCategorias();
                List<DtCategoria> DtCat = Cat.getItem();
            %> 
            <select name="ComboCat" id="ComboCatego" style='width:200px; height:50px'>
              <%
            if(DtCat != null)
            {
                for(DtCategoria dc: DtCat)
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
