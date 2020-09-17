package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCRezervasyonTest extends TestBase {
    public void giris(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        FhcTripLoginPage fhcTripLoginPage=new FhcTripLoginPage(driver);

        fhcTripLoginPage.username.sendKeys("manager2");
        fhcTripLoginPage.password.sendKeys("Man1ager2!");
        fhcTripLoginPage.login.click();
    }
    @Test
    public void Test01(){
        giris();
       String yazi= driver.findElement(By.xpath("//div[@class='caption']")).getText();
        System.out.println(yazi);
        Assert.assertTrue(yazi.equals("Create Hotel"));
    }

}
