package dev.selenium;

import dev.selenium.pages.LoginPage;
import dev.selenium.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class MainDriver {
    LoginPage loginPage;
    ProductsPage productsPage;

     WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

     @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
