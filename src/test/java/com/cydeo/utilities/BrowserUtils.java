package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
In this class only general utility methods that are not related to some psecific page.

 */
public class BrowserUtils {


    /*
    This method will accept int(in seconds) and execute
    Thread.sleep for given seconds
     */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver,String expectedInUrl,String expectedInTitle){
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
          System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
    //This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

}

