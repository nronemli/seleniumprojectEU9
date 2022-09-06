package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowPractice {
    WebDriver driver;

    @Test
    public void multipleWindowTest() {
        //Storing your main handle into string for re-usability
        //the unique ID gets randomly generated everytime we run the TEST
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();


        Assert.assertEquals(actualTitle, expectedTitle, "Title failed");
        System.out.println("Title before click: " + actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        actualTitle = driver.getTitle();

        System.out.println("Title after click: " + actualTitle);

        //6. Switch to new Window.
        //Set<String> allWindowHandles= driver.getWindowHandles();
        //window handle 1= main window
        //window handle 2- 2nd window

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title before switching windows: " +driver.getTitle());
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick= "New Window";
        actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitleAfterClick);
        System.out.println("Title after click: " +actualTitle);
    }

    @BeforeMethod
    public void setMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }






}


/*
TC #5: Window Handle practice

1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
 */