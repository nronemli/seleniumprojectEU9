package com.cydeo.tests.day12_PomDesign_ExplilictWait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
    }
    @Test
    public void required_field_error_message_test() {
        //3- Do not enter any information
        //4- Click to “Sign in” button
        libraryLoginPage.singInButton.click();
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
    }
    @Test
    public void invalid_email_format_error_message_test() {
        libraryLoginPage.inputUsername.sendKeys("wrongEmail");
        libraryLoginPage.singInButton.click();
        Assert.assertTrue(libraryLoginPage.inputValidEmailErrorMessage.isDisplayed());
    }
    @Test
    public void library_negative_login_test() {
        libraryLoginPage.inputUsername.sendKeys("nur@gmail.com");
        libraryLoginPage.inputPassword.sendKeys("aaaaaa");
        libraryLoginPage.singInButton.click();
        Assert.assertTrue(libraryLoginPage.wrongEmailAndPasswordErrorMessage.isDisplayed());
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
}

//TC #1: Required field error message test
//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com
//3- Do not enter any information
//4- Click to “Sign in” button
//5- Verify expected error is displayed:
//Expected: This field is required.

//TC #2: Invalid email format error message test
//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com
//3- Enter invalid email format
//4- Verify expected error is displayed:
//Expected: Please enter a valid email address.

//TC #3: Library negative login
//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com
//3- Enter incorrect username or incorrect password
//4- Verify title expected error is displayed:
//Expected: Sorry, Wrong Email or Password


//1.Step: Create a class for the page: constructor and all elements
//2. test class : before method(page object+driver), after method(driver.close),test caseses.
//3. configuration reader to read configuration.propertoes
//4.configuration.properties file
//5. driver utility
//6. browser utility

