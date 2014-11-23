package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import org.junit.After;
import org.junit.Before;
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
    protected final String baseUrl = "http://localhost:8080/RestaurantDiscovery";
    protected WebDriver driver;
    
    @Before
    public void openBrowser(){
        driver = new FirefoxDriver();
    }
    
    @After
    public void closeBrowser(){
        driver.close();
    }
}
