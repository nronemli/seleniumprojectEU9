package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_GoogleSearch {
    WebDriver driver;

    @Test
    public void google_search_test() {
        // 3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("apple"+ Keys.ENTER);
        //searchBox.sendKeys(ConfigurationReader.getProperty("searchValue"+ Keys.ENTER));

        // 4- Verify title:
        // Expected: apple - Google Search
        String expectedTitle= ConfigurationReader.getProperty("searchValue") +" - Google Search";
        //String expectedTitle = " apple - Google Search";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @BeforeMethod
    public void setupMethod() {
        //Another solution!
        //String browserType = ConfigurationReader.getProperty("browser");
        //driver = WebDriverFactory.getDriver(browserType);

        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://google.com");

        //bypass google cookies
        WebElement cookiesButton = driver.findElement(By.id("L2AGLb"));
        cookiesButton.click();
    }
}

/*
TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search


Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.



 */