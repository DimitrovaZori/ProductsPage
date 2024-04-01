package dev.selenium;

import dev.selenium.pages.LoginPage;
import dev.selenium.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainDriver{
    LoginPage loginPage;
    ProductsPage productsPage;

    private WebDriver driver;


    @Test
    public void testSuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage= loginPage.clickLoginButton();
        productsPage= new ProductsPage(driver);


        //assertEquals(productsPage.getPageTitle(), "Products");
    }


    @Test
    public void testNotValidLogin(){
        SoftAssert soft =new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        soft.assertEquals(loginPage.getError(),"Epic sadface: Username is required");

        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        productsPage= loginPage.clickLoginButton();

        soft.assertEquals(loginPage.getError(),"Epic sadface: Password is required");
        soft.assertAll();
    }

    @Test
    public void testSuccessful() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage= loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage = loginPage.selectProduct();
        productsPage =loginPage.buyProduct();
        productsPage = loginPage.removeProduct();
        productsPage =loginPage.returnShopping();
       //productsPage = loginPage.checkoutProduct();

    }

}
