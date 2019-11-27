/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import WSDL_generado.Publicador;
import WSDL_generado.PublicadorService;
import WSDL_generado.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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

        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
        Usuario usu = port.buscarUsuario(name);
        //chequea contraseña
        if(usu.getContrasenia().equals(password)){
            HttpSession session=request.getSession();  
            session.setAttribute("usuarioLogueado",usu.getNickname()); 
            session.setAttribute("infoLogueado", usu);
            response.sendRedirect("homeLogIn.jsp");
        }
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }  
        out.close(); 
    }
    
    static public Usuario getUsuarioLogueado(HttpServletRequest request)
			throws ServletException, IOException {
        
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
               
        return port.buscarUsuario(
                (String) request.getSession().getAttribute("usuarioLogueado"));
				
			
    }

}
