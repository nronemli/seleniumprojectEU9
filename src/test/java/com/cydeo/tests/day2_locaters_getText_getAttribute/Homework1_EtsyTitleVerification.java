package com.cydeo.tests.day2_locaters_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1_EtsyTitleVerification {
    public static void main(String[] args) {

        //        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //        2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com/uk/");


      //WebElement cookiesButton = driver.findElement(By.cssSelector(""));
      //cookiesButton.click();


    }



}

/*
TC #1: Etsy Title Verification
        3. Search for “wooden spoon”
        4. Verify title:
        Expected: “Wooden spoon | Etsy”

 */