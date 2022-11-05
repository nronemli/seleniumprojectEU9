package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T1_DoubleClick {
    DoubleClickPage doubleClickPage;
    @BeforeMethod
    public void startUpMethod(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        doubleClickPage = new DoubleClickPage();
    }

    @Test
    public void t1_double_click_test(){
        doubleClickPage.acceptCookies.click();
        Driver.getDriver().switchTo().frame("iframeResult");
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(doubleClickPage.textDoubleClick).perform();
        System.out.println("doubleClickPage.textDoubleClick.getAttribute(\"style\") = " + doubleClickPage.textDoubleClick.getAttribute("style"));
        String actualStyleAttribute= doubleClickPage.textDoubleClick.getAttribute("style");
        String expectedStyleAttribute= "red";
        Assert.assertTrue(actualStyleAttribute.contains(expectedStyleAttribute));
    }


}


//TC #1: Double Click Test
//1. Go to
//https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblcli
//ck2
//2. Switch to iframe.
//3. Double click on the text “Double-click me to change my text color.”
//4. Assert: Text’s “style” attribute value contains “red”.
