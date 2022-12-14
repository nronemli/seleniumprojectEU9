package com.cydeo.tests.day2_locaters_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.get("https://google.com");

        //bypass google cookies
        WebElement cookiesButton = driver.findElement(By.id("L2AGLb"));
        cookiesButton.click();

        //3- Write “apple” in search box
        //4- Click google search button>> ENTER
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //5- Verify title: Expected: Title should start with “apple” word
        String exceptedInTitle = "apple";
        String actualInTitle = driver.getTitle();

        if (actualInTitle.startsWith(exceptedInTitle)) {
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }

        driver.close();
    }
}




/*
TC#3: Google search

 */