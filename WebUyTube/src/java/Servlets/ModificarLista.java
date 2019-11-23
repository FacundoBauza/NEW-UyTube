/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author MarianoC
 */
@WebServlet(name = "ModiList", urlPatterns = {"/ModiList"})
public class ModificarLista extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarLista</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarLista at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
          response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarLista</title>");            
            out.println("</head>");
            out.println("<body>");
            pkgWS.PublicadorService service = new pkgWS.PublicadorService();
            pkgWS.Publicador port = service.getPublicadorPort();
            String usuarioLogueado = (String) request.getSession().getAttribute("usuario");
            Usuario infoLogueado = (Usuario) request.getSession().getAttribute("infoLogueado");
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioConsult");
            String NomLis = request.getParameter("ComboLista");
            String Private = request.getParameter("ComboPrivacidad");
            Lista L = port.buscarLista(NomLis, infoLogueado.getNickname());
            out.println(NomLis+Private);
            if(Private.equals("Privado"))
                port.modificarListaPart(infoLogueado.getNickname(), NomLis, L.getCategoria().getNombre(), true);        
            else     
                port.modificarListaPart(infoLogueado.getNickname(), NomLis, L.getCategoria().getNombre(), false);


            out.println("</body>");
            out.println("</html>");
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
