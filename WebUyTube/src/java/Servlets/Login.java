/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Fabrica;
import logica.ISistema;
import logica.Manejador;
import logica.Usuario;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        //guardo los parametros ingresados
        String name = request.getParameter("username");  
        String password = request.getParameter("password");
        Manejador m = Manejador.getinstance();
        Usuario usu = m.buscarUsuario(name);
        if(usu.getEliminado()!=true){
            //chequea contraseña
            if (usu.getContrasenia().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogueado", usu.getNickname());
                session.setAttribute("infoLogueado", usu);
                response.sendRedirect("homeLogIn.jsp");
            } else {
                out.print("Sorry, username or password error!");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        }
        else {
        out.print("El usuario está eliminado");
        }
              
        out.close(); 
    }
    
    static public Usuario getUsuarioLogueado(HttpServletRequest request)
			throws ServletException, IOException {
        
        Manejador m = Manejador.getinstance();        
        return m.buscarUsuario(
                (String) request.getSession().getAttribute("usuarioLogueado"));
				
			
    }

}
