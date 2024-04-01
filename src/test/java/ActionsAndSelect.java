import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ActionsAndSelect {
    WebDriver driver;
    @BeforeMethod

    public void before (){
        driver = new ChromeDriver();

    }

    //@Test

    /*public void dropDownTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

     WebElement select = driver.findElement(By.id("dropdown"));

        Select dropDown = new Select(select);
        dropDown.selectByVisibleText("Option 1");
        dropDown.selectByValue("2");
    }*/

    /*@Test

    public void column (){
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> emails = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[3]"));
        for (WebElement email: emails){
            System.out.println(email.getText());
        }

        driver.getCurrentUrl();*/


       /* @Test
        public void paginationTest() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://pagination.js.org/");

            WebElement demo1 = driver.findElement(By.id("demo1"));

            List <WebElement> items = demo1.findElements(By.cssSelector(".data-container ul li"));
            List <WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));

            pagination.get(2).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.stalenessOf(items.get(0)));

            items = demo1.findElements(By.cssSelector(".data-container ul li"));
            assertTrue(items.get(0).getText().equals("11"));


        }
*/
        /*@Test

        public void dynamic(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
           // WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Start')]"));
            WebElement button = driver.findElement(By.xpath("//div[@id ='start']/button"));
            button.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='finish']/h4")));

           assertEquals("Hello World!",helloWorldText.getText());

        }*/

   /* @Test

    public void dynamicControl(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement check = driver.findElement(By.cssSelector("[type=checkbox]"));
        check.click();

        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        assertEquals("It's gone!",driver.findElement(By.id("message")).getText());

    }*/


    /*@Test

    public void newTabTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
       //We make list of all tabs
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebElement header = driver.findElement(By.tagName("h3"));
        String headerText = header.getText();
        assertEquals("New Window", headerText);

        driver.close();
        driver.switchTo().window(tabs.get(0));
    }*/

   /* @Test
    public void nestedFramesTests(){
        driver.get("https://the-internet.herokuapp.com/frames");

        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftElement = driver.findElement(By.tagName("body"));
        leftElement.getText();

        //to go upper to frame-top

        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();

    }*/
//https://the-internet.herokuapp.com/iframe
    //clear


    @Test

    public void iFrameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.findElement(By.id("mce_0_ifr"));

        /*content.clear();
        content.sendKeys("Hello");
*/
    }

    @Test
    public void dataTable() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement editFrank = driver.findElement(By.xpath("//table[@id='table1']//tr[contains(text(), Frank)]/td/a[contains(text(), 'edit')]"));
        editFrank.click();
        System.out.println(editFrank.getText());

        WebElement nameFrank = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[2]"));
        System.out.println(nameFrank.getText());

    }


        /*  @AfterMethod
                public void after () {
                      driver.quit();
                    }*/
    }




