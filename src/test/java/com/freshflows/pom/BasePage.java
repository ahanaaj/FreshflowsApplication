package com.freshflows.pom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage (WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getElement(By element){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public BasePage randomString(   ) {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return this;
    }
    }
