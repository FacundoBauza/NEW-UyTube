/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.Publicador;
import servidor.PublicadorService;
import logica.DT.*;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AltaPerfil", urlPatterns = {"/AltaPerfil"})
public class AltaPerfil extends HttpServlet {
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
//            ISistema s = null;
//            s = Fabrica.getInstance();
            String nickname = request.getParameter("nickname");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String contrasenia = request.getParameter("contrasenia");
            String email = request.getParameter("email");
            String fNac = request.getParameter("fecha_nac");
            String imagen = request.getParameter("imagen");
            String canal = request.getParameter("canal"); 
            String descrcanal = request.getParameter("descripcion_canal");
            String privado = request.getParameter("privado");
            Boolean priv = true;
            if (privado == null) {
                priv = false;
            }
        
            
            pkgWS.PublicadorService service = new pkgWS.PublicadorService();
            pkgWS.Publicador port = service.getPublicadorPort();
            
            
            
            DTCanal c = new DTCanal(canal, descrcanal, priv, null, null); 
            //cargar imagen
            File fichero = new File(imagen);
            String absolute = fichero.getAbsolutePath();
            
            SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
            Date date = null;
            date = simple.parse(fNac);
            
            DTUsuario u = new DTUsuario(nickname, contrasenia, nombre, apellido, email, date, absolute, c, false);
            //port.altaUsuario(arg0, arg1);
            
            

            out.println("<html><body onload=\"alert ('Usuario Creado')\"></body></html>");
            response.sendRedirect("http://localhost:8084/WebUyTube/login.jsp");

        }
    }

    
}
