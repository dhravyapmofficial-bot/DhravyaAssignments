
package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.*;

import java.time.Duration;

public class CreateAccountStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User launches Salesforce login page")
    public void user_launches_salesforce_login_page() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com");
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("dhravyapmofficial@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Dhravya@28");
        driver.findElement(By.id("Login")).click();
    }

    @When("User clicks on App Launcher toggle")
    public void user_clicks_app_launcher_toggle() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='slds-icon-waffle']"))).click();
    }

    @When("User navigates to Sales app")
    public void user_navigates_to_sales_app() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='View All']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Sales']"))).click();
    }

    @When("User clicks on Accounts tab")
    public void user_clicks_on_accounts_tab() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@title='Accounts']"))).click();
    }

    @When("User clicks on New account button")
    public void user_clicks_on_new_account_button() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='New']"))).click();
    }

    @When("User enters account name as {string}")
    public void user_enters_account_name(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='Name']"))).sendKeys(name);
    }

    @When("User selects ownership as Public")
    public void user_selects_ownership_as_public() {
        driver.findElement(By.xpath("//button[@aria-label='Ownership']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@title='Public']"))).click();
    }

    @When("User saves the account")
    public void user_saves_the_account() {
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        String accountName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//lightning-formatted-text[@slot='primaryField']")))
                .getText();

        Assert.assertTrue(accountName.contains("Dhravya"));
        driver.quit();
    }
}
