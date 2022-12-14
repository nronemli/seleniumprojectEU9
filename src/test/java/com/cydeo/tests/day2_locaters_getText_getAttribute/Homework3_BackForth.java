package com.cydeo.tests.day2_locaters_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3_BackForth {
    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.get("https://google.com");

        //bypass google cookies
        WebElement cookiesButton = driver.findElement(By.id("L2AGLb"));
        cookiesButton.click();

        //3- Click to Gmail from top right.
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();

        //4- Verify title contains:Expected: Gmail
        String expectedTitle= "Gmail";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASS " + actualTitle);
        }else{
            System.out.println("Title verification FAILED");
        }

       // 5- Go back to Google by using the .back();
        driver.navigate().back();

       // 6- Verify title equals:Expected: Google
        expectedTitle = "Google";
        actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASS " + actualTitle);
        }else{
            System.out.println("Title verification FAILED");
        }
        driver.close();
    }
}

