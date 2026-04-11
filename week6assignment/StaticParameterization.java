package testcases.week6assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;



public class StaticParameterization extends ProjectSpecificMethod{

    @Test
    public void dyamnicValue() throws InterruptedException {
   
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Click login button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Login"))).click();

        // Click Verify button after entering the OTP manually
        Thread.sleep(20000);
        driver.findElement(By.id("save")).click();

        // Click App Launcher (Toggle)
        By appLauncher = By.xpath("//div[contains(@class,'slds-icon-waffle')]");
        wait.until(ExpectedConditions.elementToBeClickable(appLauncher)).click();

        //Click View All
        driver.findElement(By.xpath("//button[contains(text(),'View All')]")).click();
        
        //Search and select Legal Entities
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Legal Entities']"))).click();
        
        //Click New
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();

        //Fill details
        driver.findElement(By.name("CompanyName")).sendKeys("TestCompanyName");
        driver.findElement(By.xpath("//label[contains(text(),'Description')]/following::textarea[1]")).sendKeys("Salesforces");
        // Click Status dropdown
        driver.findElement(By.xpath("//label[text()='Status']/following::button[1]")).click();
        // Select Active
        driver.findElement(By.xpath("//span[@title='Active']")).click();


        //Click Save
        driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
        
        //Verify alert message
        WebElement error = driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__help') and contains(text(),'Complete this field')]"));
        Assert.assertTrue(error.isDisplayed(), "Expected mandatory error shown for Name field");
    }

}
