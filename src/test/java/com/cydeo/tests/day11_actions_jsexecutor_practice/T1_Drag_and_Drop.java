package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Drag_and_Drop {


    @Test
    public void drag_drop_Test() {
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //accept cookies button
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //locate small and big and small circle
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, bigCircle).perform();

        String actualBigCircleTest = bigCircle.getText();
        String expectedBigCircleTest = "You did great!";
        Assert.assertEquals(actualBigCircleTest, expectedBigCircleTest, "You did great is not displayed");
    }

    //second solution
    @Test
    public void drag_drop_Test2() {
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //accept cookies button
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //locate small and big and small circle
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(smallCircle)
                .moveToElement(bigCircle)
                .release()
                .perform();

        String actualBigCircleTest = bigCircle.getText();
        String expectedBigCircleTest = "You did great!";
        Assert.assertEquals(actualBigCircleTest, expectedBigCircleTest, "You did great is not displayed");
    }
}
/*
TC #: Drag and drop
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
 */