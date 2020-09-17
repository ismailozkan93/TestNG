package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcTripHotelCreatePage {
    WebDriver driver;
    public FhcTripHotelCreatePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy( id= "Code" )
    public WebElement codekutusu;
    @FindBy( name = "Name" )
    public WebElement namekutusu;
    @FindBy( id= "Address" )
    public WebElement addresskutusu;
    @FindBy( id= "Phone" )
    public WebElement phonekutusu;
    @FindBy( id= "Email" )
    public WebElement emailkutusu;
    @FindBy( id= "IDGroup" )
    public WebElement idgroupkutusu;
    @FindBy( id= "btnSubmit" )
    public WebElement submitkutusu;

}
