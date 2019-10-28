 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DT.DTCanal;
import logica.DT.DTUsuario;
import logica.Fabrica;
import logica.ISistema;
import logica.Manejador;
import logica.Sistema;

@WebServlet(name = "ModificarUsuario", urlPatterns = {"/ModificarUsuario"})
public class ModificarUsuario extends HttpServlet {

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
            ISistema sistema = new Sistema();
            String nickname = Login.getUsuarioLogueado(request).getNickname();//request.getParameter("nickname");
            String nombre = request.getParameter("Nombre");
            String apellido = request.getParameter("Apellido");
            String contrasenia = request.getParameter("pass");
            //String fNac = request.getParameter("Fecha");
           // String imagen = request.getParameter("imagen");
           String canal = request.getParameter("NombreCanal");
           String descrcanal = request.getParameter("DescCanal");
           String privado = request.getParameter("privado");
           Boolean priv= true;
           if(privado==null){
               priv = false;
           }
           //DTCanal c = new DTCanal(canal, descrcanal, priv, ,);
           //DTUsuario u = new DTUsuario(nickname, contrasenia, nombre, apellido, email, new Date(), null, c);
           sistema.modificarUsuario(nickname, contrasenia, nombre, apellido, null, null, canal, descrcanal, priv);
            out.println("<html><body onload=\"alert ('Usuario Modificado')\"></body></html>");
           
           response.setHeader("Refresh", "0; URL=http://localhost:8080/WebUyTube/homeLogIn.jsp");
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
