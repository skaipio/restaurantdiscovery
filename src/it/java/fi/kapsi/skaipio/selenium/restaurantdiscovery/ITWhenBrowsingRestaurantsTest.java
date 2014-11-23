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
import org.openqa.selenium.firefox.FirefoxDriver;

// The Failsafe plugin requires that integration-test
// classes are prefixed with IT. Run from console with
// mvn verify -P integration-test
// For now we have to manually start the glassfish server for testing this.
public class ITWhenBrowsingRestaurantsTest extends IntegrationTestUsingSelenium{
    
    /*
    @Before
    public void openBrowser(){
        super.openBrowser();
    }
    
    @After
    public void closeBrowser(){
        super.closeBrowser();
    }*/
    
    @Test
    public void restaurantsAreListedOnMainPage(){
        driver.get(baseUrl);
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Lappi Restaurant"));
        assertTrue(pageSource.contains("Classic American Diner"));
    }
}
