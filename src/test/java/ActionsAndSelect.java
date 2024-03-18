import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsAndSelect {
    WebDriver driver;
    @BeforeMethod

    public void before (){
        driver = new ChromeDriver();

    }

    @Test

    public void sliderTest(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement slider = driver.findElement(By.cssSelector(".form-range"));
        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(slider).moveByOffset(40,0).perform();



    }

    @AfterMethod

    public void after () {
        driver.quit();

    }

}
