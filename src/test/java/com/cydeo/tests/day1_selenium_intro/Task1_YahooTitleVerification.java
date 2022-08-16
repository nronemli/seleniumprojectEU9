package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        //2. Go to https://www.yahoo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com");
        //maximize the screen
        driver.manage().window().maximize();

        /* 3.Verify title:
        Expected: Yahoo */
        String expectedTitle="Yahoo";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED");
        }else {
            System.out.println("Failed verification");
        }

        driver.close();
    }
}
