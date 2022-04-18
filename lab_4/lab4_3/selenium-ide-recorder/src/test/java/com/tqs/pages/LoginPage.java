package com.tqs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("username");

    By password = By.id("password");

    By loginButton = By.id("login");

    public void setUsername(String user) {
        driver.findElement(this.username).sendKeys(user);
    }

    public void setPassword(String pass) {
        driver.findElement(this.password).sendKeys(pass);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
