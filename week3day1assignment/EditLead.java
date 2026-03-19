package org.testleaf.week3day1assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

public static void main(String[] args) {

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
driver.findElement(By.partialLinkText("Create Lead")).click();

//Company Name Field using Xpath
driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Test COmpany Name");

//FirstName Field Using Xpath
driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("5Test Leaf FN");

//LastName Field Using Xpath
driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Test Leaf LN");

//FirstName (Local) Field Using Xpath
driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("FN Local");

//Department Field Using Name
driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Department");

//Description Field Using Name
driver.findElement((By.id("createLeadForm_description"))).sendKeys("Selenium Automation");

//Enter Phone number
driver.findElement(By.xpath("//input[@id='createLeadForm_primaryPhoneNumber']")).sendKeys("9090909090");

//Email field
driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("test@gmail.com");

//State/Province as NewYork Using Visible Text
WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
Select stateValue = new Select(state);
stateValue.selectByVisibleText("New York");

//Click Create Lead button
driver.findElement(By.name("submitButton")).click();

//Click Edit button
driver.findElement(By.xpath("//a[text()='Edit']")).click();

//Clear Description field
WebElement clearDescription = driver.findElement((By.id("updateLeadForm_description")));
clearDescription.clear();

//Fill Important note field
driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Test Note 123");

//Click Update button
driver.findElement(By.xpath("//input[@value='Update']")).click();

//Get Title
String title = driver.getTitle();
System.out.println("Title is "+ title);

//Close the browser
driver.close();

}

}
