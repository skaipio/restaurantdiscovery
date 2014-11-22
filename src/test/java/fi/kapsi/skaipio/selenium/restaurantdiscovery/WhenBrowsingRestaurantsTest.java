/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WhenBrowsingRestaurantsTest {
    private final String baseUrl = "http://localhost:8080/RestaurantDiscovery";
    private WebDriver driver;
    
    @Before
    public void openBrowser(){
        driver = new HtmlUnitDriver();
    }
    
    @After
    public void closerBrowser(){
        driver.close();
    }
    
    @Test
    public void restaurantsAreListedOnMainPage(){
        driver.get(baseUrl);
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Lappi Restaurant"));
        assertTrue(pageSource.contains("Classic American Diner"));
    }
}
