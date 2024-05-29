import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cart {
    public static void main(String[] args) throws Exception {
       System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.amazon.in/");
       driver.manage().window().maximize();

       WebElement searchElement = driver.findElement(By.name("field-keywords"));
       searchElement.sendKeys("Phone");
       Actions actions=new Actions(driver);
       actions.sendKeys(Keys.ENTER).perform();
       WebElement addElement = driver.findElement(By.id("a-autoid-1-announce"));
       addElement.click();
       Thread.sleep(7000);
       WebElement phone=driver.findElement(By.id("a-autoid-2-announce"));
       actions.sendKeys(Keys.ARROW_DOWN).perform();
       actions.moveToElement(phone).perform();
       Thread.sleep(9000);
       driver.navigate().back();
       WebElement searchElement1 = driver.findElement(By.name("field-keywords"));
       searchElement1.sendKeys("Laptop");
       Actions actionss=new Actions(driver);
       actionss.sendKeys(Keys.ENTER).perform();
       WebElement addElement1 = driver.findElement(By.id("a-autoid-1-announce"));
       addElement1.click();
       WebElement lap=driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));
       lap.click();
       actionss.sendKeys(Keys.ARROW_UP).perform();
    
    }
}