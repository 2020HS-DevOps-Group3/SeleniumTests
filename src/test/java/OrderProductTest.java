import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

@Slf4j
public class TestGoogleSearch {

    static WebDriver driver;

    @Test(priority = 1)
    void setup() {
        String path = "src/test/resources/chromedriver";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        log.info("chrome driver: {}" + absolutePath);
        System.setProperty("webdriver.chrome.driver", absolutePath);
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
    }

    @Test(priority = 2)
    void googleTest2() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
                .sendKeys("Order");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
        driver.wait(3000);

        boolean isSuccessMessageDisplayed = driver.findElement(By.xpath("/html/body/div[1]/div[3]/modal/div[1]/div[1]/div[1]/swal/success")).isDisplayed();
        Assert.assertEquals(0, isSuccessMessageDisplayed);

        // Is Cart Empty
        boolean isDisplayed = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]")).isDisplayed();
        Assert.assertEquals(0, isDisplayed);
        System.out.println(driver.getTitle());
    }

    @Test(priority = 3)
    void teardown() {
        driver.close();
        driver.quit();
    }
}
