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
import logica.DT.DTUsuario;
import logica.Fabrica;
import logica.ISistema;
import logica.Manejador;
import logica.Usuario;

/**
 *
 * @author Usuario
 */

@WebServlet (name = "VerInfoUsu", urlPatterns = {"/VerInfoUsu"})

public class VerInfoUsu extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String nick = request.getParameter("dataname");
        servidor.Publicador service = new servidor.Publicador();
        Usuario usuario = service.buscarUsuario(nick);
        if(usuario!=null){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioConsult", usuario); 
            request.getRequestDispatcher("infoconsultausuario.jsp").forward(request, response);
        }
        else{
            out.println("<html><body onload=\"alert('Usuario no encontrado')\"></body></html>");
            response.setHeader("Refresh", "0; URL=/WebUyTube/");
        }
    }
}
