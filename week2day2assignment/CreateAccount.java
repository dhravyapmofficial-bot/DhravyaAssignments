package org.testleaf.week2day2assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateAccount {

    public static void main(String[] args) {

    //Inorder to open browser in Guest mode
    ChromeOptions opt = new ChromeOptions(); 
    opt.addArguments("guest");

    //Initialize the WebDriver
    ChromeDriver driver = new ChromeDriver(opt);

    //Load the URL
    driver.get("http://leaftaps.com/opentaps/control/main");

    //Maximize browser window
    driver.manage().window().maximize();

    //Enter Username and password
    driver.findElement(By.id("username")).sendKeys("DemoCSR");
    driver.findElement(By.id("password")).sendKeys("crmsfa");
    driver.findElement(By.className("decorativeSubmit")).click();

    driver.findElement(By.partialLinkText("CRM/SFA")).click();
    
    //Click on the Accounts tab.
    driver.findElement(By.partialLinkText("Accounts")).click();

    //Click on the Create Account button
    driver.findElement(By.partialLinkText("Create Account")).click();

    //Enter and Print Account Name
    String actName = new String("DH3TestLeafAccount");
    driver.findElement(By.id("accountName")).sendKeys(actName);
    System.out.println("Expected Account Name: " + actName);

    driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");

    //To select Industry value using selectByVisibleText
    WebElement industry = driver.findElement(By.name("industryEnumId")); //Find element
    Select industryValue = new Select(industry); //Create object
    industryValue.selectByVisibleText("Computer Software"); //Select option

    //To select ownership value using selectByVisibleText
    WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
    Select ownershipValue = new Select(ownership);
    ownershipValue.selectByVisibleText("S-Corporation");

    //To select source value using SelectByValue
    WebElement source = driver.findElement(By.id("dataSourceId"));
    Select sourceValue = new Select(source);
    sourceValue.selectByValue("LEAD_EMPLOYEE");

    //To select marketing campaign value using SelectByIndex
    WebElement campaign = driver.findElement(By.id("marketingCampaignId"));
    Select campaignValue = new Select(campaign);
    campaignValue.selectByIndex(6);

    //To select state/province value using SelectByValue
    WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
    Select stateValue = new Select(state);
    stateValue.selectByValue("TX");

    driver.findElement(By.className("smallSubmit")).click(); //Clicking button

    //Verify account name
    WebElement account = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/span"));
    String accountName = account.getText();
    System.out.println(accountName);

    //Remove account number
    String actualAccountName = accountName.split("\\(")[0].trim();
    System.out.println("Actual Account Name: " + actualAccountName);

    //Expected Text
    String expectedAccountName = actName;

    //Verify using assert
    Assert.assertEquals(actualAccountName, expectedAccountName);

    driver.close();
}

}
