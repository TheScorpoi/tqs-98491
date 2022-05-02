package tqs.hw1.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.extension.ExtendWith;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import io.github.bonigarcia.wdm.WebDriverManager;

@ExtendWith(SeleniumJupiter.class)
public class Test1Test {
  
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @BeforeAll
  static void setupClass() {
      WebDriverManager.firefoxdriver().setup();
  }

  @BeforeEach
  public void setUp() {
    driver = new FirefoxDriver();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test1() {
    driver.get("http://localhost:3000/dashboard");
    driver.manage().window().setSize(new Dimension(1800, 1125));
    driver.findElement(By.id("mui-2")).click();
    driver.findElement(By.id("mui-2")).sendKeys("portugal");
    driver.findElement(By.id("mui-3")).click();
    driver.findElement(By.id("mui-3")).sendKeys("2022-05-01");
    {
      WebElement element = driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("mui-3")).click();
    driver.findElement(By.id("mui-3")).sendKeys("2022-04-04");
    {
      WebElement element = driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("mui-2")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("mui-2")).clear();
    driver.findElement(By.id("mui-2")).sendKeys("spain");
    driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root")).click();
    driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("mui-2")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    
    driver.findElement(By.id("mui-2")).clear();
    driver.findElement(By.id("mui-2")).sendKeys("usa");
    driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("mui-2")).click();
    driver.findElement(By.id("mui-2")).clear();
    driver.findElement(By.id("mui-2")).sendKeys("china");
    driver.findElement(By.id("mui-3")).click();
    driver.findElement(By.id("mui-3")).sendKeys("2022-03-02");
    {
      WebElement element = driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".css-147t4j3-MuiButtonBase-root-MuiButton-root")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }
}
