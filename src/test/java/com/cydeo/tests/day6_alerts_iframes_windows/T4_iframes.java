package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_iframes {
    WebDriver driver;
    @Test
    public void iframesTest() {
        //switch drivers focus to iframe
        //option 1 - iframe using id attribute valie
       // driver.switchTo().frame("mce_0_ifr"); //by using id of the frame
        //driver.switchTo().frame(0); //by using index value
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        //locate the p tag
        WebElement yourContentText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(yourContentText.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        //switch back to main HTML to verify main HTML
        driver.switchTo().parentFrame();

        WebElement headerText= driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(headerText.isDisplayed());
    }
    @BeforeClass
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }


}


/*
TC #4: Iframe practice

1. Create a new class called: T4_Iframes
2. Create new test and make set ups
3. Go to: https://practice.cydeo.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
 */