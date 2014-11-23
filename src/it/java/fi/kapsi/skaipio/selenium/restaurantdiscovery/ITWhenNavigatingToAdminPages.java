package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
        
        
public class ITWhenNavigatingToAdminPages extends IntegrationTestUsingSelenium{
    @Test
    public void mainPageShouldHaveLinkToAdminPage(){
        driver.get(baseUrl);
        WebElement link = null;
        try{
            link = driver.findElement(By.id("linkAdminPage"));
        }catch(NoSuchElementException e){}
        assertNotNull(link);
    }
    
    @Test
    public void adminPageLinkShouldOpenAdminPage() throws NoSuchElementException{
        driver.get(baseUrl);
        WebElement link = driver.findElement(By.id("linkAdminPage"));
        link.click();
        assertEquals("http://localhost:8080/RestaurantDiscovery/admin/", driver.getCurrentUrl());
    }
}
