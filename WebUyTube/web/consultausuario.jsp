<%-- 
    Document   : consultausuario
    Created on : 30/09/2019, 07:31:02 PM
    Author     : Usuario
--%>

<%@page import="WSDL_generado.DtUsuario"%>
<%@page import="WSDL_generado.DtUsuarioArray"%>
<%@page import="WSDL_generado.Publicador"%>
<%@page import="WSDL_generado.PublicadorService"%>
<%@page import="java.util.List"%>
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
        <title>Consultar Usuario</title>
    </head>
    <body>
        <h1>Consultar Usuario</h1><br><br>
        <!--   tabla    -->
        <div class="col-md-7">
            <table class="table table-bordered table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th>Usuarios:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                       <% 
                        PublicadorService service = new PublicadorService();
                        Publicador port = service.getPublicadorPort();
    
                        DtUsuarioArray usu = port.getUsuarios();
                        List<DtUsuario> usuarios = usu.getItem();
                        for(int i = 0; i < usuarios.size(); i++){ %>
                            <tr>
                                <td><%= usuarios.get(i).getNickname()  %></td>
                            </tr>

                        <% } %>

                    </tr>
                </tbody>
            </table>    
        </div>
        <!--      ----     -->
        
        
        
        <form name="ConsultarUsuario" action="VerInfoUsu" method="POST">
            Nick o Mail del usuario:
            <input type="Text" size="20" name="dataname">
            <input type="submit" value="Buscar">
        </form>
        
    <footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
   
    </body>
</html>
