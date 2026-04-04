package org.testleaf.week5assignment;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTable {

     public static void main(String[] args) {

        // Initialize ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        // Load the URL
        driver.get("https://erail.in/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Add an implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Clear the existing value in From station and enter "MAS"
        WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
        fromStation.clear();
        fromStation.sendKeys("MAS");
        driver.findElement(By.xpath("//div[@class='autocomplete']/div[@title='Mgr Chennai Ctr']")).click();

        // Clear the existing value in To station and enter "MDU"
        WebElement toStation = driver.findElement(By.id("txtStationTo"));
        toStation.clear();
        toStation.sendKeys("MDU");
        driver.findElement(By.xpath("//div[@class='autocomplete']/div[@title='Madurai Jn']")).click();

        // Uncheck the "Sort on Date" checkbox
        driver.findElement(By.id("chkSelectDateOnly")).click();

        // Retrieve the train names from the web table.
        List<WebElement> trainList = driver.findElements(By.xpath("//div[@id='divTrainsList']/table/tbody/tr/td[2]/a"));
        System.out.println("list size is : " + trainList.size());
        Set<String> uniqueTrainNames = new HashSet<String>();
        for (int i = 0; i < trainList.size(); i++) {
            String trainNames = trainList.get(i).getText();
            System.out.println("Train name is : " + trainNames);
            uniqueTrainNames.add(trainNames);

        }
        //Verify if duplicate train names present 
        if (trainList.size() == uniqueTrainNames.size()) {
            System.out.println("No Duplicate Train names present");
        } else
            System.out.println("Duplicate Trains names present in the table");

        driver.close();
    }

}
