package com.cydeo.tests.day1_selenium_intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        //1.Setting up the web driver manager
        //we create our "Browser Driver"
        WebDriverManager.chromedriver().setup();
        //2.create instance of the web driver
        WebDriver driver = new ChromeDriver();
        //3.Test if the driver is working as excepted
        //selenium method :Get
        driver.get("https://www.facebook.com");


    }
}
