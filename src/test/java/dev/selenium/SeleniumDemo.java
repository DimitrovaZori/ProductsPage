package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ClientInfoStatus;
import java.time.Duration;
import java.util.List;

public class SeleniumDemo {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void testOpenBrowser() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> myList = driver.findElements(By.cssSelector("input"));
        myList.get(2).click();

        Thread.sleep(3000);

    }
}