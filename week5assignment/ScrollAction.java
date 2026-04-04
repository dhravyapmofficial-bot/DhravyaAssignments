package org.testleaf.week5assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollAction {

    
    public static void main(String[] args) {
        // Launch the browser
        ChromeDriver driver = new ChromeDriver();

        // Load the url
        driver.get("https://www.amazon.in/");

        // Maximize the browser
        driver.manage().window().maximize();

        // Add an implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Scroll down to the "Conditions of Use and Sale" section at the bottom of the
        // page using Actions class.
        WebElement scrollElement = driver.findElement(By.linkText("Conditions of Use & Sale"));
        Actions action = new Actions(driver);
        action.scrollToElement(scrollElement).perform();

        // Get the text of "Conditions of Use and Sale" and print it in the console
        String text = scrollElement.getText();
        System.out.println("Text is :" + text);

        driver.close();

    }

}
