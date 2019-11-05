
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.Usuario"%>
<!DOCTYPE html>
<html  >
<head>
<!-- BOOTSTRAP-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <img src="imagenes/logo3.png" width="100" height="50" alt="logo"/>

        <divide>
        <a href="http://localhost:8080/WebUyTube/#"> Inicio</a>

        <a   href="http://localhost:8080/WebUyTube/login.jsp">Ingresar</a>
        </divide>
    </header>

<div class="container">


<form action="${pageContext.request.contextPath}/CrearListaPart" method="post">
    <fieldset>
        <legend><h2>Crear Lista:</h2></legend>
            <div class="form-group">
                <input type="checkbox" name="Privada" class='form-control' value="Priv">Lista Privada<br>
            </div>
            Nombre Lista:<br>
            <div class="form-group">
                <input type="text" class='form-control' name="NomLista" placeholder="Nombre Lista" required />
            </div>
            <div class="form-group">
                <input type="submit" class='form-control' value="Submit" />
            </div>
    </fieldset>        
</form>


</div>       
</body>
<footer>
<footer>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </footer>
    <p> UyTube 2020! </p>

</footer>

</html>