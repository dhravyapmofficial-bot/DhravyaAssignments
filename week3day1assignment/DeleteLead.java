package org.testleaf.week3day1assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteLead {

    public static void main(String[] args) throws InterruptedException {

    //To execute chrome in guest mode
    ChromeOptions opt = new ChromeOptions();
    opt.addArguments("guest");

    ChromeDriver driver = new ChromeDriver(opt);
    driver.get("http://leaftaps.com/opentaps/control/main");
    driver.manage().window().maximize();

    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
    driver.findElement(By.id("password")).sendKeys("crmsfa");
    driver.findElement(By.className("decorativeSubmit")).click();
    driver.findElement(By.partialLinkText("CRM/SFA")).click();
    driver.findElement(By.partialLinkText("Leads")).click();

    //click find leads
    driver.findElement(By.partialLinkText("Find Leads")).click();

    //click phone tab
    driver.findElement(By.xpath("//span[text()='Phone']")).click();

    //Enter phone number
    driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9090909090");

    // Click Find Leads
    driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
    
    //Create Wait Object
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    //Wait for 2 seconds inorder to load
    Thread.sleep(2000); 
    
    //Capture and Print First Lead
    WebElement firstLead = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]") ) );
    String leadID = firstLead.getText(); 
    System.out.println("First resulting lead is "+leadID);
    
    //Click the first resulting lead
    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

    //Click Delete button
    driver.findElement(By.xpath("//a[text()='Delete']")).click();
    
    //Wait for 2 seconds inorder to load
    Thread.sleep(2000); 

    // Click Find Leads
    driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
    
    //Enter captured lead id
    WebElement leadIdInput = driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[1]"));
    leadIdInput.sendKeys(leadID);

    // Click Find Leads
    driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
    
    //Wait for 2 seconds inorder to load
    Thread.sleep(2000); 
    
    //verify no records present
    WebElement noRecords = driver.findElement(By.xpath("//div[text()='No records to display']"));
    String text = noRecords.getText();
    if (text.equals("No records to display"))
    {
        System.out.println("Lead successfully deleted!");
    }
    else
    {
         System.out.println("Lead still exists!");
    }

    // Close the browser
    driver.quit();

    }



}
