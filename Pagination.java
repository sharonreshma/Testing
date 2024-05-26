import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Pagination {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }

    @Test
    public void testSearchAndAddPhoneToCart() {
        WebElement searchElement = driver.findElement(By.name("field-keywords"));
       searchElement.sendKeys("Phone");
       WebElement search = driver.findElement(By.id("nav-search-submit-button"));
       search.click();
       WebElement addElement = driver.findElement(By.id("a-autoid-1-announce"));
       addElement.click();
       driver.navigate().back();
       WebElement searchElement1 = driver.findElement(By.name("field-keywords"));
       searchElement1.sendKeys("Laptop");
       WebElement search1 = driver.findElement(By.id("nav-search-submit-button"));
       search1.click();
       WebElement addElement1 = driver.findElement(By.id("a-autoid-1-announce"));
       addElement1.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
