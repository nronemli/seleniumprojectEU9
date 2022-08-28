package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_StateDropdown {
    WebDriver driver;

    @Test
    public void stateDropdownTest(){

        Select stateDropDown =new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropDown.selectByVisibleText("Illinois");
        stateDropDown.selectByValue("VA");
        stateDropDown.selectByIndex(5);

        String expectedSDDtext= "California";
        String actualSDDText = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSDDText,expectedSDDtext," State drop down text failed " + actualSDDText);

    }

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}

/*
TC #5: Selecting state from State dropdown and verifying result
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
        Use all Select options. (visible text, value, index)

 */