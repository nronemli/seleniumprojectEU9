package com.cydeo.tests.day10_upload_actions_jssexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {


    @Test
    public void registration_form_test() {
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //Created JavaFaker object to use
        Faker faker = new Faker();

        //3. Enter first name
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String fName = faker.name().firstName();
        firstName.sendKeys(fName);

        //4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        String lName = faker.name().lastName();
        lastName.sendKeys(lName);

        //5. Enter username
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        //userName.sendKeys(faker.name().username().replaceAll(".",""));
        String uName = faker.bothify("helpdesk###");
        userName.sendKeys(uName);

        //6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(uName + "@gmail.com");

        //7. Enter password
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        //password.sendKeys(faker.internet().password());
        password.sendKeys(faker.bothify("###???##"));

        //8. Enter phone number
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@name='gender'][1]"));
        inputGender.click();

        //10. Enter date of birth
        WebElement dob = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dob.sendKeys("03/08/2000");

        //11. Select Department/Office
        Select department = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        //department.selectByValue("MCTC");
        department.selectByIndex(faker.number().numberBetween(1, 9));

        //12. Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(faker.number().numberBetween(1, 8));

        //13. Select programming language from checkboxes
        WebElement programmingLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        programmingLanguage.click();

        //14. Click to sign up button
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signInButton.click();
        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.
         String expectedMessage="You’ve successfully completed registration.";
         WebElement actualMessage = Driver.getDriver().findElement(By.xpath("//p[.]"));
         Assert.assertTrue(actualMessage.isDisplayed(),"Message displayed incorrectly");
    }
}







/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */