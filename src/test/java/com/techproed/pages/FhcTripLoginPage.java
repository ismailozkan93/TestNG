package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FhcTripLoginPage {
    WebDriver driver;
    public FhcTripLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy( id = "UserName" )
    public WebElement username;

    @FindBy( id = "Password" )
    public WebElement password;

    @FindBy( xpath = "//button[@type='submit']" )
    public WebElement login;

}
