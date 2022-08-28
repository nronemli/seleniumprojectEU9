package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_NextBaseCRM {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes 3- Enter incorrect username into login box:
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Enter incorrect username into login box:
        WebElement userName= driver.findElement(By.xpath("//input[@class='login-inp']"));
        userName.sendKeys("hello");
        //4- Click to `Reset password` button
        WebElement resetButton= driver.findElement(By.xpath("//button[@value='Reset password']"));
        resetButton.click();
        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='errortext']"));
        String exceptedLabel = "Login or E-mail not found";
        String actualLabel = errorLabel.getText();
        if(actualLabel.equals(exceptedLabel)){
            System.out.println("Error label verification PASSED");
        }else {
            System.out.println("Error label verification FAILED");
        }
        driver.close();
    }
}


/*
TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
 */