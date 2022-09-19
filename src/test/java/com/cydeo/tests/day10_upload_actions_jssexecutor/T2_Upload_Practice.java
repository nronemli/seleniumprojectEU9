package com.cydeo.tests.day10_upload_actions_jssexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test() {
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/nuronemli/Desktop/Screenshot 2022-08-30 at 21.31.32.png";
        //3. Upload the file.
        //WebElement for choose file button
        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        fileUpload.sendKeys(path);
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedHeader= Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));
        String expectedHeader= "File Uploaded!";
        Assert.assertEquals(fileUploadedHeader.getText(),expectedHeader,"File uploaded header2 not displayed");
    }


}


/*
TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page

 */

//MAC: right click, hold ooption to copy PATH