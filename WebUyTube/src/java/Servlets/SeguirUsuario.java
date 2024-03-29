/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import WSDL_generado.Usuario;
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
@WebServlet(name = "SeguirUsuario", urlPatterns = {"/SeguirUsuario"})
public class SeguirUsuario extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        String user = (String) request.getSession().getAttribute("usuarioLogueado");
        Usuario user_seguir = (Usuario) request.getSession().getAttribute("usuarioConsult");
        if (user != null) { 
            if (user_seguir != null) {
                String usuNickSeguir = user_seguir.getNickname();
                if (!(user.equals(usuNickSeguir))) {
                    
                    out.println("<html><body onload=\"alert('Ahora Sigues a: " + usuNickSeguir + "')\"></body></html>");
                    request.getRequestDispatcher("infoconsultausuario.jsp").forward(request, response);
                    //response.sendRedirect("infoconsultausuario.jsp");
                }
            }else{
                out.println("<html><body onload=\"alert('Usuario a seguir no encontrado')\"></body></html>");
                    
            }

        }
        else{
            out.println("<html><body onload=\"alert('Usuario logueado no encontrado')\"></body></html>");
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
