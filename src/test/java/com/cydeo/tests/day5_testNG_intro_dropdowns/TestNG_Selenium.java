package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;

    //selenium: test automation tool for browser
    //testNG: unit testing tool, created for developers to unit test (inspired by jUnit and nUnit)
    @Test
    public void selenium_Test() {
        //Max the page
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Get "https://google.com
        driver.get("https://google.com");
        //bypass google cookies
        WebElement cookiesButton = driver.findElement(By.id("L2AGLb"));
        cookiesButton.click();
        //Assert: title is "Google"
        Assert.assertEquals(driver.getTitle(),"Google","Title is not matching");
    }

    @BeforeMethod
    public void setupMethod(){
        //Do browser driver setup
        //Open browser
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }










}
