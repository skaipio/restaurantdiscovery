package fi.kapsi.skaipio.selenium.restaurantdiscovery;

import static fi.kapsi.skaipio.selenium.restaurantdiscovery.IntegrationTestUsingSelenium.driver;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ITWhenOnLoginPageTest extends IntegrationTestUsingSelenium{
    
    
    @Before
    public void open(){
        driver = new FirefoxDriver();
    }
    
    @After
    public void close(){
        driver.close();
    }
    
    @Test
    public void thereShouldExistALoginForm(){
        driver.get(loginPage);
        WebElement form = null;
        try{
            form = driver.findElement(By.tagName("form"));
        }catch(NoSuchElementException e){}
        assertNotNull(form);
    }
    
    @Test
    public void submittingOnlyUsernameKeepsOnLoginPage() throws NoSuchElementException{
        driver.get(loginPage);
        WebElement username = driver.findElement(By.id("loginForm:username"));
        username.sendKeys("admin");
        username.submit();
        assertTrue(driver.getCurrentUrl().contains(loginPage));
    }
    
    @Test
    public void submittingOnlyPasswordKeepsOnLoginPage() throws NoSuchElementException{
        driver.get(loginPage);
        WebElement password = driver.findElement(By.id("loginForm:password"));
        password.sendKeys("password");
        password.submit();
        assertTrue(driver.getCurrentUrl().contains(loginPage));
    }
    
    @Test
    public void submittingWrongUsernameKeepsOnLoginPage() throws NoSuchElementException{
        driver.get(loginPage);
        WebElement username = driver.findElement(By.id("loginForm:username"));
        WebElement password = driver.findElement(By.id("loginForm:password"));
        username.sendKeys("notadmin");
        password.sendKeys("password");
        username.submit();
        assertTrue(driver.getCurrentUrl().contains(loginPage));
    }
    
    @Test
    public void submittingWrongPasswordKeepsOnLoginPage() throws NoSuchElementException{
        driver.get(loginPage);
        WebElement username = driver.findElement(By.id("loginForm:username"));
        WebElement password = driver.findElement(By.id("loginForm:password"));
        username.sendKeys("admin");
        password.sendKeys("wrongpassword");
        username.submit();
        assertTrue(driver.getCurrentUrl().contains(loginPage));
    }
    
    @Test
    public void submittingCorrectCredentialsOpensTheAdminPage() throws NoSuchElementException, InterruptedException{
        driver.get(loginPage);
        WebElement username = driver.findElement(By.id("loginForm:username"));
        WebElement password = driver.findElement(By.id("loginForm:password"));
        WebElement loginButton = driver.findElement(By.id("loginForm:loginBtn"));
        username.sendKeys("admin");
        password.sendKeys("password");
        loginButton.click();
        assertTrue(driver.getCurrentUrl().contains(adminPage));
    }
}
