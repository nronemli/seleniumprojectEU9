package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Webtable_Verify {
    WebDriver driver;
    @Test
    public void order_name_verify_test() {
        WebElement bobsMartinCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        // 2. Verify Bob’s name is listed as expected.
        String expectedBobName = "Bob Martin";
        String actualBobName = bobsMartinCell.getText();
        Assert.assertEquals(actualBobName, expectedBobName);
        //BrowserUtils.verifyTitle(driver,"Bob Martin");
        // 3. Verify Bob Martin’s order date is as expected
        // Expected: 12/31/2021
        WebElement bobMartinOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        String expectedOrderDate = "12/31/2021";
        String actualOrderDate = bobMartinOrderDate.getText();
        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }

    //we use the utility method we created
    @Test
    public void test2(){
        String customerOrderDate1 =WebTableUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("customerOrderDate = " + customerOrderDate1);
        String customerOrderDate2 =WebTableUtils.returnOrderDate(driver,"John Doe");
        System.out.println("customerOrderDate2 = " + customerOrderDate2);
    }

    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver,"Bart Fisher","01/16/2021");
    }

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}

/*
TC #1: Web table practice
 1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */
