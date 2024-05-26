/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
    public static void main(String[] args) throws Exception {
        // String location="src/Poi/data.xlsx";
        // XSSFWorkbook wbook=new XSSFWorkbook(location);
        // XSSFSheet sheet=wbook.getSheetAt(0);
        // for(int i=1;i<=2;i++){
        //     XSSFRow row=sheet.getRow(i);
        //     for(int j=0;j<2;j++){
        //         XSSFCell cell=row.getCell(j);
        //         String value=cell.getStringCellValue();
        //         System.out.println(value);
        //     }
            
        // }
        // wbook.close();
    }
}
*/

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class App {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        try {
            FileInputStream file = new FileInputStream("src/Poi/data.xlsx");
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(0);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.tagName("button")).click();

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testLoginSuccess() {
        // Assuming successful login scenario
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        // Add your assertion for successful login message
    }

    @Test
    public void testLoginFailure() {
        // Assuming failed login scenario
        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        // Add your assertion for error message
    }
}*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class App {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void signUpTest() throws InterruptedException {
        driver.get("https://www.facebook.com/signup");

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNmaeInput = driver.findElement(By.name("lastname"));
        WebElement mobilenumber = driver.findElement(By.name("reg_email__"));
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        WebElement DOB = driver.findElement(By.name("birthday_day"));
        WebElement DOB1 = driver.findElement(By.name("birthday_month"));
        WebElement DOB2 = driver.findElement(By.name("birthday_year"));
        WebElement gender = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement SUBMIT = driver.findElement(By.name("websubmit"));

        firstNameInput.sendKeys("Sharon");
        lastNmaeInput.sendKeys("Reshma");
        mobilenumber.sendKeys("7448977325");
        password.sendKeys("#123sHARON");
        DOB.sendKeys("4");
        DOB1.sendKeys("jul");
        DOB2.sendKeys("2004");
        if (!gender.isSelected()) {
            gender.click();
        }
        SUBMIT.click();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


