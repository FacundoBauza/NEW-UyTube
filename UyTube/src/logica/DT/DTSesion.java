/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.DT;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Usuario
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class DTSesion {

    private String nick;
    private String contrasenia;
    

    public DTSesion(String nick, String contrasenia ) {
        this.nick = nick;
        this.contrasenia = contrasenia;
    }

    public String getNickname() {
        return nick;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    
}

