import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailVerificationTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "src//Driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to the email inbox
        driver.get("https://mail.google.com/mail/u/0/#inbox");
    }

    @Test
    public void testEmailVerificationLink() {
        // Locate and click on the email containing the verification link using appropriate locators
        WebElement emailContainingVerificationLink = driver.findElement(By.xpath("xpath_of_email_containing_verification_link"));
        emailContainingVerificationLink.click();

        // Find and click on the verification link in the email
        WebElement verificationLink = driver.findElement(By.xpath("xpath_of_verification_link"));
        verificationLink.click();

        // Wait for the new page to load (you may need to add explicit wait)
        
        // Assert that the verification link redirects to the correct page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "expected_url_after_verification", "Verification link does not redirect to the correct page");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
