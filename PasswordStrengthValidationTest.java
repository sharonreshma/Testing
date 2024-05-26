import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswordStrengthValidationTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "src//Driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login/");
    }

    @Test
    public void testPasswordStrengthValidation() {
        // Locate the password input field
        
        WebElement passwordInput = driver.findElement(By.name("pass"));

        // Enter weak password
        passwordInput.sendKeys("123sS");
        driver.findElement(By.name("login")).click(); // Assuming there's a submit button
        Assert.assertTrue(driver.findElement(By.className("_9ay7")).isDisplayed(), "Password strength validation failed for weak password");

        /*// Enter medium strength password
        passwordInput.clear();
        passwordInput.sendKeys("mediumPassword123");
        driver.findElement(By.name("login")).click(); // Assuming there's a submit button
        Assert.assertTrue(driver.findElement(By.className("_9ay7")).isDisplayed(), "Password strength validation failed for medium strength password");

        // Enter strong password
        passwordInput.clear();
        passwordInput.sendKeys("StrongPassword123!");
        driver.findElement(By.name("login")).click(); // Assuming there's a submit button
        Assert.assertTrue(driver.findElement(By.className("_9ay7")).isDisplayed(), "Password strength validation failed for strong password");*/
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
