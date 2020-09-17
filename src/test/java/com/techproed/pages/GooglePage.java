package com.techproed.pages;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class GooglePage {

    WebDriver driver;
    public GooglePage(WebDriver driver){
    this.driver=driver;
        PageFactory.initElements(driver,this);
    }
@FindBy (name = "q")
   public WebElement aramaKutusu;

@FindBy (xpath = "//tbody/tr")
   public List<WebElement> liste;











}
