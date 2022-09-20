package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad1Page {


    public DynamicLoad1Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(xpath = "//a[@class='nav-link']")
    public WebElement homeLink;

    @FindBy(css = "div#loading")
    public WebElement ladingBar;

    @FindBy(css="#username")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;


    @FindBy(xpath = "//div[@id='flash']")
    public WebElement passwordErrorMessage;

}
