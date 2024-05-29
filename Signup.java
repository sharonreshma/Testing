import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;


public class Signup{
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("Web.Chrome.Driver", "src/Driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/signup");
driver.manage().window().maximize();

WebElement firstNameInput = driver.findElement(By.name("firstname"));
WebElement lastNmaeInput = driver.findElement(By.name("lastname"));
WebElement mobilenumber = driver.findElement(By.name("reg_email__"));
WebElement password = driver.findElement(By.name("reg_passwd__"));
WebElement DOB = driver.findElement(By.name("birthday_day"));
WebElement DOB1 = driver.findElement(By.name("birthday_month"));
WebElement DOB2 = driver.findElement(By.name("birthday_year"));
WebElement gender = driver.findElement(By.xpath("//input[@value='1']"));
//WebElement pronoun = driver.findElement(By.name("preffered_pronoun"));
WebElement SUBMIT = driver.findElement(By.name("websubmit"));

firstNameInput.sendKeys("Sharon");
lastNmaeInput.sendKeys("Reshma");
mobilenumber.sendKeys("7448977325");
password.sendKeys("#123sHARON");
DOB.sendKeys("4");
DOB1.sendKeys("jul");
DOB2.sendKeys("2004");
if(!gender.isSelected()){
    gender.click();
}
//Select pronoun1 = new Select(pronoun);
//pronoun1.selectByVisibleText("She: \"Wish her a happy birthday!\"");
SUBMIT.click();
    }
}