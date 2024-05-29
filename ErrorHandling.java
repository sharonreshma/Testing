import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorHandling {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.linkedin.com/signup/");

        driver.manage().window().maximize();


        WebElement email = driver.findElement(By.name("email-or-phone"));
        WebElement password = driver.findElement(By.name("password"));

       
        
        email.sendKeys("sharon@example.com");
        password.sendKeys("SecurePassword123");
        
        WebElement joinNowButton = driver.findElement(By.xpath("//button[@type='submit']"));
        
        Thread.sleep(1000); 

        Actions actions = new Actions(driver);
        actions.doubleClick(joinNowButton).perform();
       //movetoelement()
       //actions.click().perform();

        WebElement firstName = driver.findElement(By.name("first-name"));
        WebElement lastName = driver.findElement(By.name("last-name"));

        firstName.sendKeys("Sharon");
        lastName.sendKeys("Reshma");

        WebElement joinNowButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
        Actions action = new Actions(driver);
        action.moveToElement(joinNowButton1).perform();
        action.click().perform();

        Thread.sleep(10000);
    //    driver.switchTo().frame(driver.findElement(By.id("destination_publishing_iframe_lnkd_0")));
       
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='challenge-dialog']/div/section/div/div/iframe")));
       
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='register-verification-phone-number']")));
        phone.sendKeys("9786352590" + Keys.ENTER);
        
    }
}