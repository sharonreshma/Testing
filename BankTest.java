import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class BankTest {
        WebDriver driver;
        @BeforeTest
        public void set(){
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.axisbank.com/bank-smart/open-by-axis-bank/get-started");
        driver.manage().window().maximize();

        }
        @Test
        public void Bank(){
WebElement search=driver.findElement(By.id("search-chatInput"));
search.sendKeys("Card");
        }
        @AfterTest
        public void Test(){
            if(driver!=null)
            {
            driver.quit();
            }
        }
        
    }

