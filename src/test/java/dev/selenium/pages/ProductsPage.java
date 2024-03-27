package dev.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage{


    @FindBy (className = "title");
    private WebElement pageTitle;

    public ProductsPage(WebElement driver){
       super(driver);

    }

    public String getPageTitle(){
        return pageTitle.getText();
    }
}
