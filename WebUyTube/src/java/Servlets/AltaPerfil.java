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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DT.DTCanal;
import logica.DT.DTUsuario;
import logica.Fabrica;
import logica.ISistema;
import logica.Sistema;
import servidor.Publicador;
import servidor.PublicadorService;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AltaPerfil", urlPatterns = {"/AltaPerfil"})
public class AltaPerfil extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ISistema s = null;
            s = Fabrica.getInstance();
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
            DTCanal c = new DTCanal(canal, descrcanal, priv, null, null); 
            //cargar imagen
            File fichero = new File(imagen);
            String absolute = fichero.getAbsolutePath();
            
            SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
            Date date = null;
            date = simple.parse(fNac);
            
            DTUsuario u = new DTUsuario(nickname, contrasenia, nombre, apellido, email, date, absolute, c, false);
            servidor.PublicadorService service = new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();
            
            

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AltaPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AltaPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
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
