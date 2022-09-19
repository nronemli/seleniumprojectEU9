package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /*
    This method will loging with helpdesk1@cybertekschool.com
    wehen it is called
     */
    public static void crm_login(WebDriver driver) {
        //3. Enter valid username
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputTextBox.sendKeys(ConfigurationReader.getProperty("username"));
        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();
    }

    public static void crm_login(WebDriver driver,String username, String password){
        //3. Enter valid username
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@class='login-inp']"));
        inputTextBox.sendKeys(username);
        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);
        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

    }




}
