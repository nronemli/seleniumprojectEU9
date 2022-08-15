package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

        //Setup the Browser Driver
        WebDriverManager.chromedriver().setup();
        //Create instance of the driver
        //Opens empty browser
        WebDriver driver = new ChromeDriver();
        //maximize the browser size
        driver.manage().window().maximize();
        //doesnt work for windows: for mac
        driver.manage().window().fullscreen();

        //go to  tesla.com
        driver.get("https://www.tesla.com");

        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //get the current URL using Selenium
        String currentURL= driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        //4- use selenium to navigate back
        driver.navigate().back();

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        //selenium to navigate forward
        driver.navigate().forward();

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();

        //stop code execution for 3 seconds
        Thread.sleep(3000);

        //use navigate().to(): method (selenium method)
        driver.navigate().to("https://www.google.com");
        //check the title of the page and assign to current title
        currentTitle = driver.getTitle();

        //get the title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("currentTitle = " + currentTitle);

        //get the current URL using Selenium
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //close the driver(one window/tab)
        driver.close();

        //closes all of the opened windows(closes all tabs)
        driver.quit();
    }

}
