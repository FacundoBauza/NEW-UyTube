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
public class DtSesion {

    private String nick;
    private String contrasenia;
    
    public DtSesion(){}

    public void setear (String nick, String contrasenia ) {
        this.nick = nick;
        this.contrasenia = contrasenia;
    }
    
    public DtSesion(String nick, String contrasenia ) {
        this.nick = nick;
        this.contrasenia = contrasenia;
    }

    public String getNickname() {
        return nick;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}

