package dev.selenium;

import dev.selenium.pages.LoginPage;
import dev.selenium.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod

    public void setUp(){
        driver = new ChromeDriver;
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test

    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        //ot saita se vzimat vhodnite danni
        loginPage.setPassword("secret_sauce");
        ProductsPage productsPage= loginPage.clickLoginButton();

        assertEquals(productsPage.getPageTitle(), "Products");
    }

}
