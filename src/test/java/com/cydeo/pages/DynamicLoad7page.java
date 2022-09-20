package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad7page {

//constructor
public DynamicLoad7page(){
    PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy(xpath = "//div[@id='alert']")
public WebElement doneMessage;

@FindBy(xpath = "//img[@alt='square pants']")
public WebElement imgDisplayed;



}
