/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Usuario
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Publicador {
    private Endpoint endpoint = null;
    
    public Publicador(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://192.168.0.103:9130/publicador", this);   //CAMBIAR LA IP Y PUERTO
    }
    
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
}
