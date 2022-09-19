package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_login {
    public static void crm_login(WebDriver driver){
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputTextBox.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
    }
}
