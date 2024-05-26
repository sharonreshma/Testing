import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class DropdownTask {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/s?k=laptop");
    }

    @Test
    public void testSortByPriceLowToHigh() {
        // Locate the sorting dropdown
        Select sortDropdown = new Select(driver.findElement(By.id("s-result-sort-select")));
        
        // Select "Price: Low to High"
        sortDropdown.selectByVisibleText("Price: Low to High");
        
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}