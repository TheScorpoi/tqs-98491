
package com.tqs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By LoginButton = By.id("login");

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }
}
