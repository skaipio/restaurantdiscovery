package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ITWhenOnLoginPageTest extends IntegrationTestUsingSelenium{
    
    @Test
    public void thereShouldExistALoginForm(){
        driver.get(baseUrl+"login");
        WebElement form = null;
        try{
            form = driver.findElement(By.tagName("form"));
        }catch(NoSuchElementException e){}
        assertNotNull(form);
    }
}
