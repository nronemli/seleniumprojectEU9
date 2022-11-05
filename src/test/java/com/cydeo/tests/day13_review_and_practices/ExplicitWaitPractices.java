package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod() {
        //    Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void remove_button_test() {
        dynamicControlsPage.removeButton.click();
        //4- Wait until “loading bar disappears”
        //SWITCH OFF ,the implicit wait in the driver to use the wait
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        //Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());
        try {
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        } catch (NoSuchElementException n) {
            Assert.assertTrue(true);
        }
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.getText().equals("It's gone!"));
    }

    @Test
    public void enable_button_test() {
        dynamicControlsPage = new DynamicControlsPage();
        System.out.println("dynamicControlsPage.inputBox.isEnabled() = " + dynamicControlsPage.inputBox.isEnabled());//false
        dynamicControlsPage.enableButton.click();
        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);
        System.out.println("dynamicControlsPage.inputBox.isEnabled() = " + dynamicControlsPage.inputBox.isEnabled());//true once its clicked enabled
        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled()); //true
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.inputBox.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.equals("It's enabled!"));


    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }
}
//TC #2: Explicit wait practice
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/dynamic_controls
//3- Click to “Remove” button
//4- Wait until “loading bar disappears”
//5- Verify:
//a. Checkbox is not displayed
//b. “It’s gone!” message is displayed.

//TC #3: Explicit wait practice
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/dynamic_controls
//3- Click to “Enable” button
//4- Wait until “loading bar disappears”
//5- Verify:
//a. Input box is enabled.
//b. “It’s enabled!” message is displayed.