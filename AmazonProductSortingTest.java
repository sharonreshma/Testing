import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonProductSortingTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/s?k=laptop");
    }

    @Test
    public void testSortByPriceLowToHigh() {
        // Locate the sorting dropdown
        Select sortDropdown = new Select(driver.findElement(By.id("s-result-sort-select")));
        
        // Select "Price: Low to High"
        sortDropdown.selectByVisibleText("Price: Low to High");
        
        // Wait for the sorting to take effect (may need explicit wait in real scenario)
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        
        // Assert that the products are sorted by price in ascending order
        List<WebElement> prices = driver.findElements(By.cssSelector(".a-price-whole"));
        List<Double> priceValues = new ArrayList<>();
        for (WebElement price : prices) {
            priceValues.add(Double.parseDouble(price.getText().replace(",", "")));
        }

        List<Double> sortedPrices = new ArrayList<>(priceValues);
        Collections.sort(sortedPrices);

        Assert.assertEquals(priceValues, sortedPrices, "Products are not sorted by price from low to high");
    }

    @Test
    public void testSortByRelevance() {
        // Locate the sorting dropdown
        Select sortDropdown = new Select(driver.findElement(By.id("s-result-sort-select")));
        
        // Select "Featured" (default relevance sorting)
        sortDropdown.selectByVisibleText("Featured");
        
        // Wait for the sorting to take effect (may need explicit wait in real scenario)
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        
        // Assert that the products are sorted by relevance
        // This is challenging to verify directly; we will check if the page has refreshed
        List<WebElement> products = driver.findElements(By.cssSelector(".s-title-instructions-style"));
        Assert.assertTrue(products.size() > 0, "Products are not displayed correctly after sorting by relevance");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}