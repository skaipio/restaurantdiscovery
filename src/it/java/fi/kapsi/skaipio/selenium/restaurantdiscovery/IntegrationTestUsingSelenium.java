package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author skaipio
 */
public class IntegrationTestUsingSelenium {
    protected static final String baseUrl = "http://localhost:8080/RestaurantDiscovery/";
    protected static final String adminPage = baseUrl + "admin/";
    protected static final String loginPage = baseUrl + "login/";
    protected static WebDriver driver;
    
    
    
    protected void login(){
        driver.get(loginPage);
        WebElement username = driver.findElement(By.id("loginForm:username"));
        WebElement password = driver.findElement(By.id("loginForm:password"));
        WebElement loginButton = driver.findElement(By.id("loginForm:loginBtn"));
        username.sendKeys("admin");
        password.sendKeys("password");
        loginButton.click();
    }
}
