package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kenwhiston
 */
@Named(value = "dvd")

@SessionScoped
public class DVDLibraryBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    
    /**
     * Creates a new instance of DVDLibraryBean
     */
    public DVDLibraryBean() {
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //validate login
    public String validateUsernamePassword() {
           
            if (this.username.equals("root") && 
                this.password.equals("123456")) {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", username);
                    return "index";
            } else {
                    FacesContext.getCurrentInstance().addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Incorrecto Username y Password",
                                    "Por favor ingrese un username y Password correctos"));
                    return "login";
            }
    }

    //logout event, invalidate session
    public String logout() {
            HttpSession session = SessionUtils.getSession();
            session.invalidate();
            return "login";
    }
    
}
