import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ErrorHandlingTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "src//Driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to the website's home page
        driver.get("https://www.amazon.in/");
    }

    @Test
    public void testErrorHandling() {
        // Introduce intentional error by modifying URL
        driver.get("https://www.amazon.in/lap");

        // Assert that error message or fallback mechanism is triggered appropriately
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for invalid URL");

        // Navigate to a page with a broken link
        driver.get("page_with_broken_link");

        // Find and click on the broken link
        WebElement brokenLink = driver.findElement(By.xpath("//a[@id='broken_link']"));
        brokenLink.click();

        // Assert that error message or fallback mechanism is triggered appropriately
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, "expected_url_after_clicking_broken_link", "Broken link does not trigger error message or fallback mechanism");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
