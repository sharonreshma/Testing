import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Coursera {
public static void main(String[] args) throws Exception{
    System.setProperty("webdriver.chrome.driver","src/Driver/chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.coursera.org/login");
    driver.manage().window().maximize();

    WebElement mail=driver.findElement(By.name("email"));
    WebElement pass=driver.findElement(By.name("password"));
    WebElement login=driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div/div/div/section/section/div[1]/form/div[3]/button"));
    mail.sendKeys("727822it219@skct.edu.in");
    pass.sendKeys("123sharon");
    login.click();
    Thread.sleep(60000);
    WebElement search=driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div[2]/span/div[1]/header/div[1]/div/div/div[2]/div/div/div[1]/div/div/div[3]/div/div[2]/form/div/div[1]/input"));
    search.sendKeys("testing");
    Actions actions=new Actions(driver);
    actions.sendKeys(Keys.ENTER).perform();;
}    
}
