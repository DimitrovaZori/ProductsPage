package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actions {
    WebDriver driver;


    @BeforeMethod

    public void before (){
        driver = new ChromeDriver();

    }

    @Test

    public void clickAndHold() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        Actions drag = new Actions(driver);

        Thread.sleep(2000);

        drag.clickAndHold (source).moveToElement(target).release().perform();


    }

    @AfterMethod

    public void after () {
        driver.quit();

    }


}
