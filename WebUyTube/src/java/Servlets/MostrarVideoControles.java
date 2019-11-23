/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author visua
 */
@WebServlet(name = "MostVideoControl", urlPatterns = {"/MostVideoControl"})
public class MostrarVideoControles extends HttpServlet {

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
            out.println("<title>Servlet MostrarVideoControles</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MostrarVideoControles at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarVideoControles</title>");            
            out.println("</head>");
            out.println("<body>");
                pkgWS.PublicadorService service = new pkgWS.PublicadorService();
                pkgWS.Publicador port = service.getPublicadorPort();

                Usuario infoLogueado = (Usuario) request.getSession().getAttribute("infoLogueado");

                String Comentario1 = request.getParameter("Comentario1");            
                String BotonComentar1 = request.getParameter("BotonComentar1"); 
                String BotonComentar = request.getParameter("BotonComentar");  
                String BotonComent = request.getParameter("BotonComent");
                String BotonSub = request.getParameter("BotonSubComentar");
                String Comentario = request.getParameter(BotonSub); 
                String ComboListas = request.getParameter("ComboListas");
                String BotonAgregar = request.getParameter("BotonAgregar");
                String BotonMG = request.getParameter("BotonMG");
                String BotonNMG = request.getParameter("BotonNMG");


                if(BotonComentar1 != null)
                {
                    out.print("Entra");
                    Usuario Propie = port.buscarUsuarioPorVideo(BotonComent);
                    out.print(Propie.getNickname());
                      out.print(Comentario1);
                       out.print(infoLogueado.getNickname());
                   
                        out.print(BotonComentar1);
                    DTComentario dc = new DTComentario(Comentario1, infoLogueado.getNickname());
                    port.comentarVideo(Propie.getNickname(), dc, BotonComent, 0);

                }
                else
                    out.print("No Entra al subll");

                if(BotonSub != null)
                {
                    out.print("Entra al sub");
                    out.println("<br>");
                    Usuario Propie = port.buscarUsuarioPorVideo(BotonComent);
                     out.print(Propie.getNickname());
                     out.println("<br>");
                      out.print(Comentario);
                      out.println("<br>");
                       out.print(infoLogueado.getNickname());
                       out.println("<br>");
                        out.print(Integer.parseInt(BotonSub));
                        out.println("<br>");
                        out.print(BotonComent);
                    DTComentario dc = new DTComentario(Comentario, infoLogueado.getNickname());
                    port.comentarVideo(Propie.getNickname(), dc, BotonComent, Integer.parseInt(BotonSub));

                }
                else
                    out.print("No Entra al sub");

                if(BotonAgregar != null)
                {
                    Usuario Propie = port.buscarUsuarioPorVideo(BotonComent);
                    port.agregarVideoAlista(infoLogueado.getNickname(), BotonComent, Propie.getNickname(), ComboListas);

                }

                if(BotonMG != null)
                {
                    Usuario Propie = port.buscarUsuarioPorVideo(BotonComent);
                    DTValoracion v;
                    v = new DTValoracion(true, infoLogueado.getNickname(), BotonComent);
                    port.valorarVideo(Propie.getNickname(), BotonComent, v);     
                }

                if(BotonNMG != null)
                {
                    Usuario Propie = port.buscarUsuarioPorVideo(BotonComent);
                    DTValoracion v;
                    v = new DTValoracion(false, infoLogueado.getNickname(), BotonComent);
                    port.valorarVideo(Propie.getNickname(), BotonComent, v);
                }
            out.println("</body>");
            out.println("</html>");
        }
        
      
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
