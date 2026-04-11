package testcases.week6assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {

    
    
    public ChromeDriver driver;

    @Parameters({ "url", "username", "password" })
    @BeforeMethod
    public void preConditions(String URL, String uName, String pWord) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("username")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(pWord);

    }

     @AfterMethod
     public void postConditions() {
     driver.close();
}

}
