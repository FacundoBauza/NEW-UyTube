<%-- 
    Document   : ViendoLista
    Created on : 28-oct-2019, 15:45:31
    Author     : visua
--%>

<%@page import="WSDL_generado.StringArray"%>
<%@page import="WSDL_generado.VideoArray"%>
<%@page import="WSDL_generado.Video"%>
<%@page import="WSDL_generado.Video"%>
<%@page import="WSDL_generado.Publicador"%>
<%@page import="WSDL_generado.PublicadorService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            PublicadorService service = new PublicadorService();
            Publicador port = service.getPublicadorPort();
    
            
            List<Video> aux = null;
            VideoArray videos = port.getVideos();
            List<Video> l = videos.getItem();
            StringArray cat = port.listarCategorias();
            List<String> l2 = cat.getItem();
            %>        
            <div id="capsulaVid" align="center" style="width: 80rem; margin: 10px">
                <ul class="list-group list-group-flush">
                <%
                    for(int i=0; i<l2.size(); i++)
                    {
                        int cont = 0;
                        for(int i3=0; i3<l.size(); i3++)
                        {
                            if(l.get(i3).getCategoria().getNombre().equals(l2.get(i)))
                                cont++;
                        }
                        if(cont > 0)
                        {
                            %>        
                            <li><%=l2.get(i)%></li>
                            <li class="list-group-item">
                            <%
                            for(int i2=0; i2<l.size(); i2++)
                            {
                                if(l.get(i2).getCategoria().getNombre().equals(l2.get(i)))
                                {
                                    %>
                                        <div width="200" height="200" style=" float: left; margin: 10px">
                                            <video src="<%=l.get(i2).getUrl()%>" width="200" height="200" ></video>
                                            <br>
                                            <div><%=l.get(i2).getNombre()%></div>
                                        </div>

                                    <%
                                }
                            }
                            %>
                            </li>
                            <br>
                            <%
                        }
                        aux = null;
                    }
                %>
                </ul>
            </div>    
            <%
            
        %>
    </body>
</html>
