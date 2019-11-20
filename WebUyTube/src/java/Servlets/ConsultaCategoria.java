/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.DT.DTCategoria;
import logica.DT.DTListaUsuario;
import logica.DT.DTVideoUsuario;
import logica.Fabrica;
import logica.ISistema;
import logica.Manejador;

/**
 *
 * @author visua
 */
@WebServlet(name = "ConsulCat", urlPatterns = {"/ConsulCat"})
public class ConsultaCategoria extends HttpServlet {

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
            out.println("<title>Servlet ConsultaCategoria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaCategoria at " + request.getContextPath() + "</h1>");
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
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ConsultaCategoria</title>");
                out.println("<style>");
                out.println("body{background-image: url(\"./imagenes/lluviaPro3.jpg\");}"); 
                out.println("#Tabla1{float: left}");
                out.println("#Tabla1{padding: 10px}");
                out.println("#Tabla1{margint: 40px}");
                out.println("#Tabla2{float: left}");
                out.println("#Tabla2{padding: 10px}");
                out.println("#Tabla2{margint: 40px}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");   
                    servidor.Publicador service = new servidor.Publicador();
                     
                    String CatEl = request.getParameter("ComboCat");
                    
                    List<DTListaUsuario> Lus = service.consultaListasPorCategoria(CatEl);
                    List<DTVideoUsuario> Vus = service.consultaVideosPorCategoria(CatEl);
                    
                    out.println("<H4>");   
                        out.println(CatEl);
                    out.println("</H4>");
                    
                    out.println("<div id=contenedor>");    
                        out.println("<div id=Tabla1>");   
                        out.println("<table border=1>");   
                            out.println("<tr>");   
                                out.println("<td WIDTH= 150 HEIGHT= 25>Lista</td>");
                                out.println("<td  WIDTH= 150 HEIGHT= 25>Usuario Propietario</td>");
                            out.println("</tr>");
                            if(Lus != null)
                            {
                                for(int i=0; i<Lus.size(); i++)
                                {
                                    out.println("<tr>");   
                                        out.println("<td  WIDTH= 150 HEIGHT= 25>");
                                            out.println(Lus.get(i).getLista());
                                        out.println("</td>");
                                        out.println("<td  WIDTH= 150 HEIGHT= 25>");
                                            out.println(Lus.get(i).getUsuario());
                                        out.println("</td>");
                                    out.println("</tr>");
                                }
                            }
                            else
                            {
                                out.println("<tr>");   
                                    out.println("<td  WIDTH= 150 HEIGHT= 25>");
                                        out.println("No hay Datos");
                                    out.println("</td>");
                                    out.println("<td  WIDTH= 150 HEIGHT= 25>");
                                        out.println("No hay Datos");
                                    out.println("</td>");
                                out.println("</tr>");
                            }        
                        out.println("</table>");
                        out.println("</div>");
                        
                        out.println("<div id=Tabla2>");
                        out.println("<table border=1>");   
                            out.println("<tr>");   
                                out.println("<td WIDTH= 150 HEIGHT= 25>Video</td>");
                                out.println("<td WIDTH= 150 HEIGHT= 25>Usuario Propietario</td>");
                            out.println("</tr>");
                            if(Vus != null)
                            {
                                for(int i=0; i<Vus.size(); i++)
                                {
                                    out.println("<tr>");   
                                        out.println("<td WIDTH= 150 HEIGHT= 25>");
                                            out.println(Vus.get(i).getVideo());
                                        out.println("</td>");
                                        out.println("<td WIDTH= 150 HEIGHT= 25>");
                                            out.println(Vus.get(i).getUsuario());
                                        out.println("</td>");
                                    out.println("</tr>");
                                }
                            }
                            else
                            {
                                out.println("<tr>");   
                                    out.println("<td  WIDTH= 150 HEIGHT= 25>");
                                        out.println("No hay Datos");
                                    out.println("</td>");
                                    out.println("<td  WIDTH= 150 HEIGHT= 25>");
                                        out.println("No hay Datos");
                                    out.println("</td>");
                                out.println("</tr>");
                            }
                        out.println("</table>");
                        out.println("</div>");
                    out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                }
                catch (Exception ex) {
                                           /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ListarCategoria</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("Error: " + ex.getMessage());
                out.println("</body>");
                out.println("</html>");
            }
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
