package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
    protected static WebDriver driver;
    
    @BeforeClass
    public static void openBrowser(){
        driver = new FirefoxDriver();
    }
    
    @AfterClass
    public static void closeBrowser(){
        driver.close();
    }
}
