
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DT.DTCanal;
import logica.DT.DTUsuario;
import logica.ISistema;
import logica.Sistema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ISistema sistema = new Sistema();
            String nickname = request.getParameter("nickname");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String contrasenia = request.getParameter("contrasenia");
            String email = request.getParameter("email");
            String fNac = request.getParameter("fecha_nac");
           // String imagen = request.getParameter("imagen");
           String canal = request.getParameter("canal");
           String descrcanal = request.getParameter("descripcion_canal");
           String privado = request.getParameter("privado");
           Boolean priv= true;
           if(privado==null){
               priv = false;
           }
           DTUsuario u = new DTUsuario(nickname, contrasenia, nombre, apellido, email, null, "", canal);
           DTCanal c = new DTCanal(canal, descrcanal, priv, null, null);
           sistema.altaUsuario(u, c);
            out.println("<html><body onload=\"alert ('Usuario Creado')\"></body></html>");
           
           response.setHeader("Refresh", "0; URL=http://localhost:8084/UyTube/");
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

