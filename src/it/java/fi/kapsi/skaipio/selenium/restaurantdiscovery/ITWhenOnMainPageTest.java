package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
        
        
public class ITWhenOnMainPageTest extends IntegrationTestUsingSelenium{
    
    @Before
    public void open(){
        driver = new FirefoxDriver();
    }
    
    @After
    public void close(){
        driver.close();
    }
    
    @Test
    public void headerShouldBeHiddenWhenNotSignedIn() throws NoSuchElementException{
        driver.get(baseUrl);
        WebElement header = driver.findElement(By.tagName("header"));
        assertFalse(header.isDisplayed());
    }
    
    @Test
    public void headerShouldNotBeHiddenWhenSignedIn() throws NoSuchElementException{
        this.login();
        driver.get(baseUrl);
        WebElement header = driver.findElement(By.tagName("header"));
        assertTrue(header.isDisplayed());
    }
    
    @Test
    public void restaurantDataRowsShouldNotHaveEditButtonsWhenNotSignedIn() throws NoSuchElementException{
        driver.get(baseUrl);
        List<WebElement> editButtons = driver.findElements(By.className("editButton"));
        assertTrue(editButtons.isEmpty());
    }
    
    @Test
    public void restaurantDataRowsShouldHaveEditButtonsWhenSignedIn() throws NoSuchElementException{
        driver.get(baseUrl);
        List<WebElement> editButtons = driver.findElements(By.className("editButton"));
        assertEquals(2, editButtons.size());
    }
    
    @Test
    public void adminPageLinkShouldOpenAdminPage() throws NoSuchElementException{
        this.login();
        driver.get(baseUrl);
        WebElement link = driver.findElement(By.id("linkAdminPage"));
        link.click();
        assertEquals("http://localhost:8080/RestaurantDiscovery/admin/", driver.getCurrentUrl());
    }
    
    
}
