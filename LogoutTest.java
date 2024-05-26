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

public class LogoutTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https://www.facebook.com/?sk=welcome");
        
        
    }

    @Test
    public void testLogout() {
        // Locate the logout button or link using appropriate locators
        WebElement mail = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("pass"));
mail.sendKeys("sharonprakash8492@gmail.com");
        // Enter weak password
        passwordInput.sendKeys("123sJESUS");
        driver.findElement(By.name("login")).click();
        WebElement prof = driver.findElement(By.xpath("//*[@id=\"mount_0_0_3z\"]/div/div[1]/div/div[2]/div[5]/div[1]/span/div/div[1]/div/svg/g/circle"));
        WebElement lo = driver.findElement(By.id(":r21:"));
        // Click on the logout button
        prof.click();
lo.click();
        // Assert that the logout is successful
        
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    

}
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoutTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(priority = 1)
    public void testValidLogin() {
       WebElement un= driver.findElement(By.id("username"));
       un.sendKeys("tomsmith");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();

        WebElement logout=driver.findElement(By.id("content"));
        logout.click();;
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}