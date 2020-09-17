package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {
    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="email")
    public WebElement emailkutu;

    @FindBy(id="name")
    public WebElement namekutu;

    @FindBy( id="mobile")
    public WebElement telefonkutu;

    @FindBy(id="password")
    public WebElement sifre;

    @FindBy(id = "re_password")
    public  WebElement sifreconfirm;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-warning btn-block']")
    public WebElement signupbutonu;

    @FindBy (xpath = "//strong['Success!']")
    public WebElement SuccesYazisi;

}
