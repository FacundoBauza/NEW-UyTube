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
            throws ServletException, IOException, ParseException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            pkgWS.PublicadorService service = new pkgWS.PublicadorService();
            pkgWS.Publicador port = service.getPublicadorPort();
            String nickname = Login.getUsuarioLogueado(request).getNickname();//request.getParameter("nickname");
            String nombre = request.getParameter("Nombre");
            String apellido = request.getParameter("Apellido");
            String contrasenia = request.getParameter("pass");
            String fNac = request.getParameter("Fecha");
            // String imagen = request.getParameter("imagen");
            String canal = request.getParameter("NombreCanal");
            String descrcanal = request.getParameter("DescCanal");
            String privado = request.getParameter("privado");
            Boolean priv= true;
            if(privado==null){
                priv = false;
            }
            SimpleDateFormat simple= new SimpleDateFormat("yyyy-MM-dd"); 
            Date date = null;
            date = simple.parse(fNac);

            port.modificarUsuario(nickname, contrasenia, nombre, apellido, date, null, canal, descrcanal, priv);
            //out.println("<html><body onload=\"alert ('Usuario Modificado')\"></body></html>");
           
           response.setHeader("Refresh", "0; URL=http://localhost:8084/WebUyTube/homeLogIn.jsp");
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
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
