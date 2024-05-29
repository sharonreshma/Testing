import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Job {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();

        WebElement mail=driver.findElement(By.name("session_key"));
        WebElement pass=driver.findElement(By.name("session_password"));
        WebElement sub=driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button"));
        mail.sendKeys("sharonprakash849@gmail.com");
        pass.sendKeys("123sharon");
        sub.click();
        Thread.sleep(30000);
        WebElement sr=driver.findElement(By.xpath("//*[@id=\"global-nav-typeahead\"]/input"));
        sr.sendKeys("React Developer jobs");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }
    
}
