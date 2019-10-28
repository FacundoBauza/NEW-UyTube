<%@page import="logica.Manejador"%>
<%@page import="java.util.List"%>
<%@page import="logica.DT.DTCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Manejador m = Manejador.getinstance();      
    List<DTCategoria> DtCat = m.getCategorias();
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
        <script src="resources/js/pestanas.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% //out.println(usuario.getNickname()); %></title>
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
                </div>     
            </nav>   
        </header>

                    
        
                    
        <div class="contenedorGeneral">
            <!--       menu      -->
            <div class="menu">

                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">USUARIOS:</li>
                        <li class="list-group-item"><a href="/WebUyTube/consultausuario.jsp" role="button">Consulta de usuario</a></li>
                    </ul>
                </div>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">VIDEOS:</li>
                        <li class="list-group-item"><a href="#" role="button">Subir video</a></li>
                        <li class="list-group-item"><a href="#" role="button">Ver videos</a></li>
                    </ul>
                </div>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">LISTAS:</li>
                        <li class="list-group-item"><a href="#" role="button">Crear lista</a></li>  
                        <li class="list-group-item"><a href="#" role="button">Ver más tarde</a></li>
                        <li class="list-group-item"><a href="#" role="button">Me gusta</a></li>
                        <li class="list-group-item"><a href="#" role="button">Música para estudiar</a></li>
                    </ul>
                </div>
                <div class="card" style="width: 18rem;">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">CATEGORÍAS:</li>
                        <li class="list-group-item"><a href="#" role="button">Consulta de categoría</a></li>
                        <li class="list-group-item"><a href="#" role="button">listar categorias existentes</a></li>

                    </ul>
                </div>
            </div>
            <div class="contenedorInfo">
                <h3>Nuevo Video</h3>
                    <form action="AltaVideo" method="POST">
                        <div class="form-group">
                            <input id="nombre" type="text" name='nombre' placeholder="Nombre" class='form-control' autofocus required>
                        </div>
                        <div class="form-group">
                            <input id="descripcion" type="text" name='descripcion' placeholder="Descripcion" class='form-control' required> 
                        </div>
                        <div class="form-group">
                            <input type="text" name='duracion' placeholder="Duracion" class='form-control' required>
                        </div>
                        <div class="form-group">
                            <input type="date" name='fecha' placeholder="Fecha" class='form-control' required>
                        </div>
                        <div class="form-group">
                            <input type="url" name='url' placeholder="URL" class='form-control' required>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="privado" value="privado"> Privado <br>
                        </div> 
                        <div class="form-group">
                            <select name="ComboCat" id="ComboCatego" style='width:200px; height:50px'>
                                <%
                              if(DtCat != null){
                                  for(DTCategoria dc: DtCat){
                                      %> 
                                       <option value="<%=dc.getNombre()%>"><%=dc.getNombre()%></option>
                                      <%
                                  }
                              }%>
                              </select>
                        </div>
                        <div class="form-group">
                            <input id="botonConfirmar" type="submit" value="Confirmar" class='button'>
                        </div>
                    </form>
            </div>

        <footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
    </body>
</html>
