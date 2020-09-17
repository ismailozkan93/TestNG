package com.techproed.tests;

import com.techproed.pages.FhcTripHotelCreatePage;
import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {

public void giris(){
    driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
    FhcTripLoginPage fhcTripLoginPage=new FhcTripLoginPage(driver);

    fhcTripLoginPage.username.sendKeys("manager2");
    fhcTripLoginPage.password.sendKeys("Man1ager2!");
    fhcTripLoginPage.login.click();
}
    @Test ( groups = {"fhctrip","hotelolusturma"})
    public void test(){
        FhcTripHotelCreatePage fhcTripHotelCreatePage=new FhcTripHotelCreatePage(driver);
        giris();

        fhcTripHotelCreatePage.codekutusu.sendKeys("1234");
        fhcTripHotelCreatePage.addresskutusu.sendKeys("cikmaz sk");
        fhcTripHotelCreatePage.emailkutusu.sendKeys("techproed@gmail.com");
        fhcTripHotelCreatePage.namekutusu.sendKeys("Techproed");
        fhcTripHotelCreatePage.phonekutusu.sendKeys("123345678");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        Select select = new Select(fhcTripHotelCreatePage.idgroupkutusu);
        select.selectByIndex(2);
        fhcTripHotelCreatePage.submitkutusu.click();

    }
}
