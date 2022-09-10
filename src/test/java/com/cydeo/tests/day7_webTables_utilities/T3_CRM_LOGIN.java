package com.cydeo.tests.day7_webTables_utilities;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void crm_login_test() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3. Enter valid username
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputTextBox.sendKeys("helpdesk1@cybertekschool.com");
        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");
    }


    @Test
    public void crm_login_test_2() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utilities.crm_login(driver);
        //6. Verify title is as expected:
        //Expected: Portal"
        BrowserUtils.verifyTitle(driver, "(19) Portal");
    }
    @Test
    public void crm_login_test_3(){
        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utilities.crm_login(driver);
        BrowserUtils.verifyTitle(driver,"(19) Portal");
    }

    @Test
    public void crm_login_test4(){
        driver.get(ConfigurationReader.getProperty("env"));
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputTextBox.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
        BrowserUtils.verifyTitle(driver, "(19) Portal");

    }
}
/*
TC #3: Login scenario
 1. Create new test and make set ups
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal


USERNAME  PASSWORD
helpdesk1@cybertekschool.com  UserUser
Helpdesk2@cybertekschool.com  UserUser

 */