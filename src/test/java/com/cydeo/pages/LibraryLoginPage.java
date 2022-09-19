package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    //Initialise the driver instance and object of the class
    public LibraryLoginPage() {
        //initElements method will create connection in between current drive session (instance)
        // and the object of the current class
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //PRO/CON: ONE TIME EFFORT TO LOCATE, SAVING TIME FOR FUTURE!
    //User @FindBy annotation to locate web elements
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement singInButton;

    @FindBy(xpath = "//div[@id='inputEmail-error']")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement inputValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailAndPasswordErrorMessage;
}
