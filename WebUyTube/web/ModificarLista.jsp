<%-- 
    Document   : ModificarLista
    Created on : 28-oct-2019, 0:10:09
    Author     : MarianoC
--%>

<%@page import="WSDL_generado.Lista"%>
<%@page import="WSDL_generado.ListaArray"%>
<%@page import="WSDL_generado.Publicador"%>
<%@page import="WSDL_generado.PublicadorService"%>
<%@page import="WSDL_generado.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            <form action="ModiList" method="POST">
                <center>
                <div id="Contenedor1">
                    <%
                        PublicadorService service = new PublicadorService();
                        Publicador port = service.getPublicadorPort();
                        
                        List<Lista> Lis = infoLogueado.getCanal().getListas();
                    %> 
                <p style="color: white">Modificar privacidad de la/s lista/s de reproduccion.</p>
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
                </select>
                <br>
                <select name="ComboPrivacidad" id="Combo" style='width:200px; height:50px'>    
                    <option id="1" value="Privado">Privado</option>
                    <option id="2" value="NoPrivado">No Privado</option>
                </select>
                <input type="submit" name="BotonConsultar" value="Modificar" id="BotonCatego" style='width:200px; height:50px'>
                <br>
                
                </div>    
                </center>
            </form>    
    </body>
</html>
