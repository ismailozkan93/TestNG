package com.techproed.smoketests;

import com.techproed.pages.FhcTripHotelRoomCreatePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FhcTripHotelRoomCreateTest extends TestBase {

public void giris(){
    driver.get(ConfigurationReader.getProperty("fhc_login"));
   driver.findElement(By.id("UserName")).sendKeys(ConfigurationReader.getProperty("username"));
    driver.findElement(By.id("Password")).sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);
}
@Test
public void Test(){
    giris();
    driver.get(ConfigurationReader.getProperty("room_create_url"));
    FhcTripHotelRoomCreatePage page=new FhcTripHotelRoomCreatePage(driver);

    Select select=new Select(page.IDHOTELDropDown);
    select.selectByIndex(2);

    page.CODE.sendKeys("1234");
    page.Name.sendKeys("Ahmet Yildiz");
    page.Location.sendKeys("zürih");
    page.Description.sendKeys("Merhaba");

    Actions actions=new Actions(driver);
    actions.dragAndDrop(page.kutu500, page.Price).perform();

    Select select1=new Select(page.RoomTypeDropwDown);
    select1.selectByVisibleText("Double");

    page.MaxAdultCount.sendKeys("2");
    page.MaxChildCount.sendKeys("4");
    page.ApproveKutu.click();
    page.SaveKutu.click();

    try {
        Thread.sleep(3000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    boolean basariliMi=page.basariliYazisi.isDisplayed();
    Assert.assertTrue(basariliMi);










}

}
