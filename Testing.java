import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testing {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
        //go to myntra
        driver.get("https://www.myntra.com/");

        //search
        // WebElement search = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input"));
        // search.sendKeys("handbag" + Keys.ENTER);

        WebElement search = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input"));
        search.sendKeys("3jisd9//#$" + Keys.ENTER);

        //sleep
        Thread.sleep(5000);

        //click first element
       try {
        WebElement firsElement = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/a/div[1]/div/div/div/picture/img"));
        firsElement.click();

        //get all window link
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> urls = new ArrayList<>(windowHandles);
        
        //switch to item window
        driver.switchTo().window(urls.get(1));
        Thread.sleep(1000);

        //add to bag
        WebElement addCart = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]"));
        addCart.click();

        //go to bag
        WebElement bag = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/a[2]/span[1]"));
        bag.click();

        Thread.sleep(1000);

        //click buy
        WebElement buy = driver.findElement(By.xpath("//*[@id=\"appContent\"]/div/div/div/div/div[2]/div[3]/button"));
        buy.click();
        Thread.sleep(1000);
       } catch (Exception e) {
        Assert.fail("Test failed due to exception");
       }

    }
    @AfterTest
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

}