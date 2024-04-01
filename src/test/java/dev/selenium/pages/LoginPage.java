package dev.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    //private By userName = By.id(""); nqma da ima nujda ot public LoginPage

    @FindBy(id = "password")
    private WebElement passwordInput;


    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    private WebElement error;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement product;

    @FindBy(className = "shopping_cart_link")
    private WebElement choosenProduct;

    @FindBy (id = "remove-sauce-labs-backpack")
    private WebElement remove;


    @FindBy (id = "continue-shopping")
    private WebElement shopping;
    @FindBy (id = "checkout")
    private WebElement checkout;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }


    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public ProductsPage selectProduct() {
        product.click();
        return new ProductsPage(driver);
    }


    public String getError() {
        return error.getText();
    }
    public ProductsPage buyProduct() {
        choosenProduct.click();
        return new ProductsPage(driver);
    }

    public ProductsPage removeProduct() {
        remove.click();
        return new ProductsPage(driver);
    }
    public ProductsPage returnShopping() {
        shopping.click();
        return new ProductsPage(driver);
    }

    public ProductsPage checkoutProduct() {
        checkout.click();
        return new ProductsPage(driver);
    }


    public void loginAs(String userName, String password){
        setUsername(userName);
        setPassword(password);
        clickLoginButton();

    }

}