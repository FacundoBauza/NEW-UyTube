/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AltaP", urlPatterns = {"/AltaP"})
public class AltaP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            WSDL_generado.DtCanal c = new WSDL_generado.DtCanal(); 
            c.setDesc(descrcanal);
            c.setNombre(canal);
            c.setPrivado(priv);
            
            
        WSDL_generado.DtUsuario dtusu = port.seteando(nickname, contrasenia, nombre, apellido, email, absolute, c , false);
        
            port.altaUsuario(dtusu, c);
            
            
//            SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
//            Date date = null;
//            date = simple.parse(fNac);
            
            //DtUsuario u = new DtUsuario(nickname, contrasenia, nombre, apellido, email, null, absolute, c, false);
            //port.altaUsuario(u, c);
            
            

            out.println("<html><body onload=\"alert ('Usuario Creado')\"></body></html>");
            response.sendRedirect("http://localhost:8084/WebUyTube/login.jsp");

        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
