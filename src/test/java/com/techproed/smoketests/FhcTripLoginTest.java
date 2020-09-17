package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {
    @Test
    public void girisTesti(){
    driver.get(ConfigurationReader.getProperty("fhc_login"));
        FhcTripLoginPage fhcTripLoginPage=new FhcTripLoginPage(driver);
        fhcTripLoginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        fhcTripLoginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        fhcTripLoginPage.login.click();
}




}
