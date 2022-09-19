package com.cydeo.tests.day7_webTables_utilities;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebElementT1 {

    WebDriver driver;

    @Test
    public void test1() {
        driver.get("https://practice.cydeo.com/tables#delete");
        WebElement deleteButton = driver.findElement(By.xpath("//table[@id='table1']//tr[2]/td[6]/a[2]"));

        deleteButton.click();
        WebElement homeButton= driver.findElement(By.xpath("//a[@class='nav-link']"));
        homeButton.click();
    }
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() {

    }

}
