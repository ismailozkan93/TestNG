package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class FhcTripHotelRoomCreatePage {
  WebDriver driver;
  public FhcTripHotelRoomCreatePage(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);

  }
  @FindBy ( id = "IDHotel")
  public WebElement IDHOTELDropDown;

  @FindBy (id ="Code")
  public  WebElement CODE;

  @FindBy (id="Name")
  public    WebElement Name;

  @FindBy (id = "Location")
  public   WebElement Location;

  @FindBy (xpath = "//textarea[@dir='ltr']")
  public WebElement Description;

  @FindBy(id = "Price")
   public WebElement Price;

  @FindBy( partialLinkText = "500")
    public WebElement kutu500;

  @FindBy(id = "IDGroupRoomType")
    public WebElement RoomTypeDropwDown;

  @FindBy(id = "MaxAdultCount")
    public WebElement MaxAdultCount;

  @FindBy(id = "MaxChildCount")
    public WebElement MaxChildCount;

  @FindBy( id = "uniform-IsAvailable")
    public WebElement ApproveKutu;

  @FindBy(id = "btnSubmit")
    public WebElement SaveKutu;

  @FindBy ( xpath = "//*[.='HotelRoom was inserted successfully']")
  public WebElement basariliYazisi;


}
