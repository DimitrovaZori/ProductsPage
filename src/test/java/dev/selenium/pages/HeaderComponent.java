package dev.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {
    @FindBy(className = "shopping_cart_link")
    private WebElement cardIcon;

    public void openCartByIcon(){
       cardIcon.click();

    }
}
