/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.managed;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author skaipio
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {
    private final String adminUsername = "admin";
    private final String adminPassword = "password";
    private String username;
    private String password;
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

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String login(){
        if (adminUsername.equals(username) &&
                adminPassword.equals(password)){
            return "/admin/index.xhtml?faces-redirect=true";
        }else{
            errorMessage = "Wrong user name or password.";
            return "";
        }
    }
}
