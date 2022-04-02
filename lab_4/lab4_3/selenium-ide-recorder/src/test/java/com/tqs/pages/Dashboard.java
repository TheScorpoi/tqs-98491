package com.tqs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    By heading = By.xpath("");
    By logoutButton = By.id("submit");

    public String getHeading() {
        return driver.findElement(heading).getText();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

}
