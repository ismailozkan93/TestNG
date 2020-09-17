package com.techproed.smoketests;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class GlbSignUpTest {

    @Test(groups = {"glbtrader"})
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_url"));
        GlbSignUpPage page=new GlbSignUpPage();
        page.emailkutu.sendKeys(ConfigurationReader.getProperty("glb_mail"));
        page.namekutu.sendKeys(ConfigurationReader.getProperty("glb_name"));
        page.telefonkutu.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        page.sifre.sendKeys(ConfigurationReader.getProperty("glb_password"));
        page.sifreconfirm.sendKeys(ConfigurationReader.getProperty("glb_password"));
        page.signupbutonu.click();

        System.out.println(page.SuccesYazisi.getText());
        Assert.assertFalse(page.SuccesYazisi.getText().contains("Success"));
    }
    @AfterClass
    public void TearDown(){
        Driver.closeDriver();
    }

}
