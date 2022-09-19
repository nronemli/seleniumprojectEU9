package com.cydeo.tests.day10_upload_actions_jssexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7 {

    @Test
    public void t7_Test(){
        Driver.getDriver().get("https://practice.cydeo.com/large");
        WebElement cydeoLink= Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        WebElement homeLink= Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        //get me arguments index no 0, and scroll that in tov view true = cydeoLink
        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);

        BrowserUtils.sleep(3);
        //js.executeScript("arguments[0].scrollIntoView(true)",homeLink);
        //0 is the index no for cydelink, 1 is the index no for homelink
        js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink);

    }



}

//TC #7: Scroll using JavascriptExecutor
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/large
//3- Scroll down to “Cydeo” link
//4- Scroll up to “Home” link
//5- Use below provided JS method only
//
//JavaScript method to use : arguments[0].scrollIntoView(true)
//
//Note: You need to locate the links as web elements and pass them as
//arguments into executeScript() method