package com.cydeo.tests.day12_PomDesign_ExplilictWait;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriveWaitPractices {

    @Test
    public void dynamic_load_7_Test() {
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        //creating the wait object to be able to create certain condition to wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //2. Wait until title is “Dynamic title”
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        DynamicLoad7page dynamicLoad7page = new DynamicLoad7page();
        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicLoad7page.doneMessage.isDisplayed());
        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7page.imgDisplayed.isDisplayed());
    }

    @Test
    public void dynamic_load_1_test(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        DynamicLoad1Page dynamicLoad1Page=new DynamicLoad1Page();
        dynamicLoad1Page.startButton.click();

        //3. Wait until loading bar disappears
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.ladingBar));
        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.usernameInputBox.isDisplayed());
        //5. Enter username: tomsmith
        dynamicLoad1Page.usernameInputBox.sendKeys("tomsmith");
        //6. Enter password: incorrectpassword
        dynamicLoad1Page.passwordInputBox.sendKeys("");
        //7. Click to Submit button
        dynamicLoad1Page.submitButton.click();
        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.passwordErrorMessage.isDisplayed());

    }


}
//TC#4 : Dynamically Loaded Page Elements 7
//1. Go to https://practice.cydeo.com/dynamic_loading/7
//2. Wait until title is “Dynamic title”
//3. Assert: Message “Done” is displayed.
//4. Assert: Image is displayed.
//Note: Follow POM

//TC#5 : Dynamically Loaded Page Elements 1
//1. Go to https://practice.cydeo.com/dynamic_loading/1
//2. Click to start
//3. Wait until loading bar disappears
//4. Assert username inputbox is displayed
//5. Enter username: tomsmith
//6. Enter password: incorrectpassword
//7. Click to Submit button
//8. Assert “Your password is invalid!” text is displayed.
//Note: Follow POM Design Pattern
