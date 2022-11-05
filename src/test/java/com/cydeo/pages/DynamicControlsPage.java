package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Remove']") //css="form#checkbox-example >button"
    public WebElement removeButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement itsGoneMessage;

    @FindBy(css="div#loading")
    public WebElement loadingBar;



    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;



}
