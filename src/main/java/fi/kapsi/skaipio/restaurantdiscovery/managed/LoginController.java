/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.managed;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author skaipio
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable{
    private final String adminUsername = "admin";
    private final String adminPassword = "password";
    private String username = "";
    private String password = "";
    private String errorMessage;

    public LoginController() {
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

    public String getErrorMessage() {
        return errorMessage;
    }
    
    public boolean isLoggedIn(){
        return username.equals(adminUsername) && password.equals(adminPassword);
    }
    
    public String login(){
       if (isLoggedIn()){
            return "/admin/index.xhtml?faces-redirect=true";
        }else{
            errorMessage = "Wrong user name or password.";
            return "";
        }
    }
    
    public String logout(){
        if (isLoggedIn()){
            this.username = "";
            this.password = "";
            return "/index.xhtml?faces-redirect=true";
        }
        
        return "/index.xhtml?faces-redirect=true";
    }
}
