import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hospital{
    public static void main(String[] args) throws Exception {
        System.setProperty("Web.Chrome.Driver", "src/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.psghospitals.com/book-an-appointment/");
        driver.manage().window().maximize();
        WebElement doc = driver.findElement(By.xpath("//*[@id=\"Container\"]/div[1]/div[2]"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"appointment-btn\"]"));
        doc.click();
        Thread.sleep(1000);
        submit.click();
        WebElement name = driver.findElement(By.name("PatientName"));
        WebElement mail = driver.findElement(By.name("Email"));
        WebElement mob = driver.findElement(By.name("Mobile"));
        
        WebElement dt = driver.findElement(By.name("Preferreddate"));
        WebElement other = driver.findElement(By.name("OtherDetails"));
        WebElement sub = driver.findElement(By.xpath("//*[@id=\"wpcf7-f2283-o1\"]/form/ul/li[10]/p/input"));
        
        name.sendKeys("Sharon");
        mail.sendKeys("dsd@gmail.com");
mob.sendKeys("34567890");
dt.sendKeys("23/01/2024");
other.sendKeys("sedfghjkl;");
        sub.click();
        
    }
        
}