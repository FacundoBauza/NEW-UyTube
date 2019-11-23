package Servlets;

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
import pkgWS.Categoria;
import servidor.Publicador;
import servidor.PublicadorService;

@WebServlet(name = "AltaVideo", urlPatterns = {"/AltaVideo"})
public class AltaVideo extends HttpServlet {

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
        PrintWriter out = response.getWriter();
            
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String duracion = request.getParameter("duracion");
            String f = request.getParameter("fecha");
            String url = request.getParameter("url");
            Categoria categoria = request.getParameter("ComboCat");
            String privado = request.getParameter("privado");
            Boolean priv = true;
            if (privado == null) {
                priv = false;
            }
            SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
            Date date = null;
            date = simple.parse(f);
            //                   String nombre,  descripcion,  duracion, date, url, privado, categoria
            DTVideo video = new DTVideo(nombre, descripcion, duracion, date, url, priv, categoria);
            PublicadorService service = new servidor.PublicadorService();
            Publicador port = service.getPublicadorPort();
            //port.altaVideo(video, "Gime");
            

            //out.println("<html><body onload=\"alert ('Video Creado')\"></body></html>");
            response.sendRedirect("http://localhost:8084/WebUyTube/homeLogIn.jsp");
        
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
            Logger.getLogger(AltaVideo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AltaVideo.class.getName()).log(Level.SEVERE, null, ex);
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
