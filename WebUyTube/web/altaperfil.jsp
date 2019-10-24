<%-- 
    Document   : altaperfil
    Created on : 28/09/2019, 02:56:20 PM
    Author     : Usuario
--%>

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
        <title>Registrarse</title>
    </head>
    <body>
        <div class="container p-4">
            <div class="row">
                <div class="col-md-4 mx-auto">
                    <div class="card text-center">
                        <div class="card-header bg-dark text-white text-center">
                            <h3>Registrarse</h3>
                        </div>
                        <div class="card-body">
                            <form action="AltaPerfil" method="POST">
                                <div class="form-group">
                                    <input id="userNick" type="text" name='nickname' placeholder="Nickname" class='form-control' autofocus required><z id="UsedMail"></z>
                                </div>
                                <div class="form-group">
                                    <input id="userMail" type="email" name='email' placeholder="Email" class='form-control' required><z id="UsedMail"></z> 
                                </div>
                                <div class="form-group">
                                    <input type="text" name='nombre' placeholder="Nombre" class='form-control' required>
                                </div>
                                <div class="form-group">
                                    <input type="text" name='apellido' placeholder="Apellido" class='form-control' required>
                                </div>
                                <div class="form-group">
                                    <input type="password" id="contra" name='contrasenia' placeholder="Contraseña" class='form-control' required onkeyup="HabilitarBoton();">
                                </div>
                                <div class="form-group">
                                    <input type="password" id="contra2" name='confirmacion_contraseña' placeholder="Confirmar contraseña" class='form-control' required onkeyup="HabilitarBoton();"><div id="passMatch"> </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" name='fecha_nac' placeholder="Fecha nacimiento" class='form-control' required>
                                </div>
                                <div class="form-group">
                                    Seleccione imagen: <input type="file" name="imagen" class='form-control'>
                                </div>
                                <div class="form-group">
                                    <input type="text" name='canal' placeholder="Nombre canal" class='form-control' >
                                </div>
                                <div class="form-group">
                                    <input type="text" name='descripcion_canal' placeholder="Descripcion canal" class='form-control' >
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="privado" value="privado"> Privado <br>
                                </div>    
                                <div class="form-group">
                                    <input id="botonRegistro" type="submit" value="Registrarse" class='btn btn-dark btn-block'>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
        
    <script>function checkPasswordMatch() {
        var password = document.getElementById("contra").value;
        var confirmPassword  = document.getElementById("contra2").value;

        if (password !== confirmPassword){
            document.getElementById('passMatch').innerHTML = ' Las Contraseñas No Coinciden';
            return false;
        }
        else{
            document.getElementById('passMatch').innerHTML = '';
            return true;
        }
    }
    </script>
    
    <script>function HabilitarBoton(){
        if(checkPasswordMatch.call()){
            document.getElementById('botonRegistro').disabled = false;
        }
        else{
           document.getElementById('botonRegistro').disabled = true; 
        }
    }
    </script>
    
    <footer>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </footer>
    </body>
</html>
