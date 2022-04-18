import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlazeDemoSteps {

    private final WebDriver driver = new FirefoxDriver();

    @When("I navigate to {string}")
    public void go_to_website(String website) {
        driver.get(website);
    }

    @And("I select departure city {string}")
    public void departure_city(String city) {
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[3]/form/select[1]")));
        dropdown.selectByValue(city);
    }

    @And("I select destination city {string}")
    public void destination_city(String city) {
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[3]/form/select[2]")));
        dropdown.selectByValue(city);
    }

    @And("I click {string}")
    public void click(String value) {
        driver.findElement(By.xpath("//input[@value='" + value + "']")).click();
    }
    
    @Then("The title of the page should be {string}")
    public void page_title(String pageTitle) {
        assertEquals(driver.getTitle(), pageTitle);
    }
    @Then("I should be shown results of {string}")
    public void results(String resultsOf) {
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), containsString(resultsOf));
    }

    @And("I enter my Name {string}")
    public void name(String name) {
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys(name);
    }

    @And("I enter my Address {string}")
    public void address(String address) {
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys(address);
    }

    @And("I enter my City {string}")
    public void city(String city) {
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys(city);
    }

    @And("I enter my State {string}")
    public void state(String state) {
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("Aveiro");
    }

    @And("I enter my Zip Code {int}")
    public void zipcode(Integer zipCode) {
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys(zipCode.toString());
    }

    @And("I enter my Credit Card Number {int}")
    public void creditcard(Integer creditCardNumber) {
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys(creditCardNumber.toString());
    }

    @And("I enter my Name on Card {string}")
    public void creditcard_name(String nameOnCard) {
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys(nameOnCard);
    }

    @Then("The purchase should be confirmed")
    public void confirm_purchase() {
        assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Thank you for your purchase today!");
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
