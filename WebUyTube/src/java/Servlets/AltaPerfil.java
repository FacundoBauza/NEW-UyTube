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
            //cargar imagen
            File fichero = new File(imagen);
            String absolute = fichero.getAbsolutePath();
        
            WSDL_generado.PublicadorService service = new WSDL_generado.PublicadorService();
            WSDL_generado.Publicador port = service.getPublicadorPort();
            //DtCanal c = new DtCanal(canal, descrcanal, priv, null, null); 
            
        WSDL_generado.DtUsuario dtusu = port.seteando(nickname, contrasenia, nombre, apellido, email, absolute, null, false);
        
            port.altaUsuario(dtusu, null);
            
            
//            SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
//            Date date = null;
//            date = simple.parse(fNac);
            
            //DtUsuario u = new DtUsuario(nickname, contrasenia, nombre, apellido, email, null, absolute, c, false);
            //port.altaUsuario(u, c);
            
            

            out.println("<html><body onload=\"alert ('Usuario Creado')\"></body></html>");
            response.sendRedirect("http://localhost:8080/WebUyTube/login.jsp");

        }
    }

    
}
