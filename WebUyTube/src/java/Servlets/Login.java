/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import static java.lang.System.out;
=======
>>>>>>> 5273429756de38465bc0fb15dcf39dc3f3f5bc1d
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.DT.DTSesion;

import logica.Fabrica;
import logica.ISistema;
import logica.Manejador;
import logica.Sistema;

/**
 *
 * @author Usuario
 */
@WebServlet (name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String nickname = request.getParameter("username");
        String contrasenia = request.getParameter("password");
<<<<<<< HEAD
        ISistema s = null;
        s = Fabrica.getInstance();
        DTSesion user = s.getUserSession(nickname, contrasenia);
=======
        ISistema sistema = Fabrica.getInstance();
        DTSesion user = sistema.getUserSession(nickname, contrasenia);
>>>>>>> 5273429756de38465bc0fb15dcf39dc3f3f5bc1d
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("UserNick", user.getNickname());
            session.setAttribute("UserPass", user.getContrasenia());
<<<<<<< HEAD
=======

          
>>>>>>> 5273429756de38465bc0fb15dcf39dc3f3f5bc1d
            response.sendRedirect("homeLogIn.jsp");
        }
        else{
            out.println("<html><body onload=\"alert ('Usuario no encontrado')\"></body></html>");
            response.sendRedirect("index.jsp");
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
