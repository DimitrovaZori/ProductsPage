package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Assert {

    @Test
     //Login-wrong
    public void wrongLogin() {
        WebDriver  driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement user = driver.findElement(By.name("user-name"));
        user.sendKeys("locked_out_user");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        String error = driver.findElement(By.className("error-button")).getCssValue("background-color");
        assertEquals(error, "rgba(0, 0, 0, 0)");

        driver.quit();
    }
       // Login -normal
       @Test
          public void login (){
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");

            WebElement user = driver.findElement(By.name("user-name"));
            user.sendKeys("performance_glitch_user");
            WebElement pass = driver.findElement(By.id("password"));
            pass.sendKeys("secret_sauce");
            WebElement login = driver.findElement(By.id("login-button"));
            login.click();

           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
          WebElement logo =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".app_logo")));
            WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Sauce Labs Bike Light')]"));
           System.out.println(logo);
            String background = text.getCssValue("#fff");
            String txt = text.getText();
           System.out.println(txt);

           WebElement button = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
           button.click();
           WebElement buttonRemove = driver.findElement(By.id("remove-sauce-labs-bike-light"));
           String remove = buttonRemove.getAttribute("type");
           assertEquals(remove, "submit");
           String content = buttonRemove.getText();
           assertEquals(content, "Remove" );

           String cssValue =buttonRemove.getCssValue("background-color");
           assertEquals(cssValue,"rgba(255, 255, 255, 1)");

           String tagName = buttonRemove.getTagName();
           assertEquals(tagName, "button");


       }






}
