package Servlets;

import WSDL_generado.Categoria;
import WSDL_generado.DtVideo;
import WSDL_generado.ParseException_Exception;
import WSDL_generado.Publicador;
import WSDL_generado.PublicadorService;
import WSDL_generado.Usuario;
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


@WebServlet(name = "ModificarVideo", urlPatterns = {"/ModificarVideo"})
public class ModificarVideo extends HttpServlet {

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
            throws ServletException, IOException, ParseException, ParseException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
            String nomVideo = request.getParameter("nomVideo");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String duracion = request.getParameter("duracion");
            String f = request.getParameter("fecha");
            String url = request.getParameter("url");
            String categoria = request.getParameter("ComboCat");
            String privado = request.getParameter("privado");
            Boolean priv = true;
            if (privado == null) {
                priv = false;
            }
            
//            SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
//            Date date = null;
//            date = simple.parse(f);
            
            PublicadorService service = new PublicadorService();
            Publicador port = service.getPublicadorPort();
            
            Categoria cat = new Categoria();
            cat.setNombre(categoria);
            
            DtVideo video = port.setVideo(nombre, descripcion, duracion, f, url, priv, cat);
            Usuario u = Login.getUsuarioLogueado(request);
            port.modificarVideo(video, u.getNickname(), nomVideo);

            //out.println("<html><body onload=\"alert ('Video Modificado')\"></body></html>");
            response.sendRedirect("http://localhost:8080/WebUyTube/homeLogIn.jsp");
        
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
            Logger.getLogger(ModificarVideo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(ModificarVideo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ModificarVideo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(ModificarVideo.class.getName()).log(Level.SEVERE, null, ex);
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
