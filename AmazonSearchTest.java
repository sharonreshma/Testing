/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonSearchTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddToCart() {
        // Search for "Laptop"
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("field-keywords")));
        searchElement.sendKeys("Laptop");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Wait for search results and click on the first result
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-component-type='s-search-result'])[1]//h2/a")));
        firstResult.click();

        // Wait for the "Add to Cart" button and click it
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input")));
        addToCartButton.click();

        // Assert that the cart count has increased (indicating an item has been added)
        WebElement cartCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
        Assert.assertTrue(Integer.parseInt(cartCount.getText()) > 0, "The cart count did not increase after adding an item.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}*/


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonSearchTest {

    WebDriver driver;
    WebDriverWait wait;

        @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        @Test
    public void testAddToCart() {

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("headphones    " + Keys.ENTER);
        
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a-autoid-1-announce")));
        addToCartButton.click();

        // WebElement firstElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")));
        // firstElement.click();

        

        driver.navigate().back();
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}