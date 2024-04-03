package dev.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class MainDriverJobs {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.jobs.bg/js_registration.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
