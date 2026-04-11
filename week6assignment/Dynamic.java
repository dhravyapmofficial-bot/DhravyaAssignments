package testcases.week6assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dynamic extends ProjectSpecificMethod{

@DataProvider(name="fetchData")
public String[][] sendData(){

    String[][] data = new String[2][1];

    data[0][0] = "Salesforce Automation by Dhravya";

    data[1][0] = "Salesforce Automation by Mano";

    return data;

}

 @Test(dataProvider = "fetchData")
    public void dynamicValue( String legalEntityName) throws InterruptedException{
   
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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
        By legalEntities = By.xpath("//one-app-launcher-menu-item//span[normalize-space()='Legal Entities']");
        wait.until(ExpectedConditions.elementToBeClickable(legalEntities)).click();

        //Click New
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='New']"))).click();

        //Fill details
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(legalEntityName);

        //Click Save
        driver.findElement(By.xpath("(//button[contains(text(),'Save')])[2]")).click();
        
        //Verify name
        By nameValueOnViewPage = By.xpath("//span[normalize-space()='Legal Entity Name']" +"/ancestor::div[contains(@class,'slds-form-element')]" +"//lightning-formatted-text"
        );

        WebElement actualNameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(nameValueOnViewPage));
        String actualLegalEntityName = actualNameEl.getText().trim();

        Assert.assertEquals(actualLegalEntityName, legalEntityName,"Legal Entity Name validation failed!");

        System.out.println("Legal Entity created successfully: " + actualLegalEntityName);

    }    
}


