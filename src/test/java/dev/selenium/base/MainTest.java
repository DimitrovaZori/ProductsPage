package dev.selenium.base;

import dev.selenium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MainTest {

    public WebDriver driver;
    private String url;
    private int implicitWait;
    private String browser;
    @BeforeMethod
    public void setUp() {
       setupBrowserDriver();
       loadUrl();
    }
    private void setupBrowserDriver() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
            default:
                throw new IllegalStateException("Unsupported browser type");
        }
        }
        private void loadUrl(){
            driver.get(url);
        }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
