package org.testleaf.week4day2assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {

    public static void main(String[] args) {

        //Launch Chrome in guest mode
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("guest");

        ChromeDriver driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/main");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Login
        driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        //Navigate to Merge Contacts
        driver.findElement(By.partialLinkText("CRM/SFA")).click();
        driver.findElement(By.partialLinkText("Contacts")).click();
        driver.findElement(By.partialLinkText("Merge Contacts")).click();

        //Click 'From Contact' widget
        driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

        //Switch to child window
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>(windowHandles);
        String parentWindow = windowsList.get(0);
        String childWindow = windowsList.get(1);
        driver.switchTo().window(childWindow);

        //Wait for contacts to load and select first contact dynamically
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
        ));

        List<WebElement> fromContacts = driver.findElements(
            By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
        );

        if (!fromContacts.isEmpty()) {
            fromContacts.get(0).click();
        } else {
            System.out.println("No contacts found in 'From Contact' window.");
        }

        driver.switchTo().window(parentWindow);

        //Click 'To Contact' widget
        driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

        //Switch to second child window
        Set<String> allWindows2 = driver.getWindowHandles();
        List<String> windowsList2 = new ArrayList<>(allWindows2);
        windowsList2.remove(parentWindow); // remove main window
        String toWindow = windowsList2.get(0); // should be the new popup
        driver.switchTo().window(toWindow);

        //Wait for contacts and select second contact dynamically
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
        ));

        List<WebElement> toContacts = driver.findElements(
            By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")
        );

        if (toContacts.size() > 1) {
            toContacts.get(1).click(); // second contact
        } else if (!toContacts.isEmpty()) {
            toContacts.get(0).click(); // select first if only one
        } else {
            System.out.println("No contacts found in 'To Contact' window.");
        }

        driver.switchTo().window(parentWindow);

        //Merge and handle alert
        driver.findElement(By.linkText("Merge")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.switchTo().window(parentWindow);

        // Wait for page load AFTER merge
        //wait.until(ExpectedConditions.titleContains("View Contact"));

        //Verify page title
        String title = driver.getTitle();
        System.out.println("Page title after merge: " + title);

        //Close browser
        driver.quit();
    }
}