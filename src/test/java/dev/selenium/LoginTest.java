package dev.selenium;

import dev.selenium.pages.LoginPage;
import dev.selenium.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage= loginPage.clickLoginButton();

        assertEquals(productsPage.getPageTitle(), "Products");
    }


    @Test
    public void testNotValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        assertEquals(loginPage.getError(),"Epic sadface: Username is required");


    }

    @Test
    public void testSuccessful() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage= loginPage.clickLoginButton();
        productsPage = loginPage.selectProduct();
        productsPage =loginPage.buyProduct();
        productsPage = loginPage.removeProduct();
        productsPage = loginPage.checkoutProduct();

    }


   /* @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/

}
