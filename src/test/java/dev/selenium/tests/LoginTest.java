package dev.selenium.tests;

import dev.selenium.base.MainTest;
import dev.selenium.pages.LoginPage;
import dev.selenium.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainTest {
    LoginPage loginPage;
    ProductsPage productsPage;


    @Test
    public void testSuccessfulLogin() {
        loginPage = new LoginPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage= loginPage.clickLoginButton();
        productsPage = new ProductsPage();

        assertEquals(productsPage.getPageTitle(), "Products");
    }


    @Test
    public void testNotValidLogin(){
        loginPage = new LoginPage();
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

      //  assertEquals(loginPage.getError(),"Epic sadface: Username is required");


    }

    @Test
    public void testSuccessful() {
        LoginPage loginPage = new LoginPage();
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
