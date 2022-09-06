package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_alert_practies {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // 1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alertTest1() throws InterruptedException {
        //3. Click to “Click for JS Alert” button
        WebElement clickJSAlertBtn = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickJSAlertBtn.click();
        //4. Click to OK button from the alert
        //switch drivers focus to alert
        //outside HTML
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed"); //check if its displayed
        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText, expectedText, "Actual Result text is not as expected");
    }

    @Test
    public void alertTest2() throws InterruptedException {
        WebElement clickJSConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        clickJSConfirm.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement resultText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
        Assert.assertTrue(resultText.isDisplayed());
        String expectedText = "You clicked: Ok";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void alertTest3() throws InterruptedException {
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickJSPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        WebElement resultText = driver.findElement(By.xpath("//p[.='You entered: hello']"));
        Assert.assertTrue(resultText.isDisplayed());
        String expectedText = "You entered:  hello";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText, expectedText);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
/*
TC #1: Information alert practice
/*

 /*
TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.

TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered:  hello” text is displayed.
 */