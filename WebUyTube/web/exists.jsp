<%-- 
    Document   : exists
    Created on : 18/11/2019, 03:04:10 PM
    Author     : Usuario
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
        Class.forName("org.postgresql.Driver");
        Connection con =(Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "root", "1234");
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM usuario WHERE " +
                    "nickname = ?");
            ps.setString(1,request.getParameter("nickname"));
            ResultSet res = ps.executeQuery();
            if(res.first()){
                out.print("User already exists");
            }else{
                out.print("User name is valid");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>

