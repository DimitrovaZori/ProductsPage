package dev.selenium.tests;

import com.opencsv.exceptions.CsvException;
import dev.selenium.base.MainTest;
import dev.selenium.pages.LoginPage;
import dev.selenium.pages.ProductsPage;
import dev.selenium.utils.CsvReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends MainTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @DataProvider(name = "login-data")
    public static Object [][] dataProviderHardcodedData(){
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "login-data-file")
    public static Object [][] dataProviderFromScvFile() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/login-data.csv");
    }


    @Test(dataProvider = "login-data-file")
    public void testSuccessfulLogin(String username, String password) {
        loginPage = new LoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        productsPage= loginPage.clickLoginButton();
        productsPage = new ProductsPage();

        //assertEquals(productsPage.getPageTitle(), "Products");
    }

    @DataProvider(name = "login-data-invalid")
    public static Object [][] dataProviderScvFile() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/login-data-invalid.csv");
    }


    @Test(dataProvider = "login-data-invalid")
    public void testNotValidLogin(String user, String pass, String error){
        loginPage = new LoginPage();
        loginPage.setUsername(user);
        loginPage.setPassword(pass);
        loginPage.clickLoginButton();

      assertEquals(loginPage.getError(), error);

        loginPage.setUsername(user);
        loginPage.setPassword(pass);
        loginPage.clickLoginButton();

      assertEquals(loginPage.getError(),error);

    }

    @Test
    public void testSuccessful() {
        loginPage = new LoginPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        productsPage= loginPage.clickLoginButton();


        productsPage = loginPage.selectProduct();
        productsPage =loginPage.buyProduct();
        productsPage = loginPage.removeProduct();
        productsPage = loginPage.checkoutProduct();

    }

}
