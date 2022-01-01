import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestGoogle2 {

    static WebDriver driver;

    @Test(priority = 1)
    void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/I514807/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
    }

    @Test(priority = 2)
    void googleTest2() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
                .sendKeys("Test 2");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
        System.out.println(driver.getTitle());
    }

    @Test(priority = 3)
    void teardown() {
        driver.close();
        driver.quit();
    }
}
