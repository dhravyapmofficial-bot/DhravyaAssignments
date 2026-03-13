package org.testleaf.week2day2assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

public static void main(String[] args) {

//To execute chrome in guest mode
ChromeOptions opt = new ChromeOptions();
opt.addArguments("guest");

ChromeDriver driver = new ChromeDriver(opt);
driver.get("http://leaftaps.com/opentaps/control/main");
driver.manage().window().maximize();

driver.findElement(By.id("username")).sendKeys("DemoCSR");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.partialLinkText("CRM/SFA")).click();
driver.findElement(By.partialLinkText("Leads")).click();
driver.findElement(By.partialLinkText("Create Lead")).click();
driver.findElement(By.id("createLeadForm_firstName")).sendKeys("LeadFN");
driver.findElement(By.id("createLeadForm_lastName")).sendKeys("LN");
driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CompanyNm");

String actTitle = new String("TestTitle");
driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys(actTitle);
System.out.println("Expected Title: " + actTitle);

driver.findElement(By.name("submitButton")).click();

//To verify title
String expTitle = driver.findElement(By.id("viewLead_generalProfTitle_sp")).getText(); 
System.out.println("Actual Title: " + expTitle);
if (expTitle.equals(actTitle))
{
System.out.println("Title is correct");
}
else
{
System.out.println("Title is incorrect");
}
driver.close();
}

}
