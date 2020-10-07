package com.techproed.smoketests;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class GlbSignUpTest {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite çalıştı");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest çalıştı");
    }
    @Test  ( groups = "glbtrader")
    public void fhctrip(){
        /*
         * 1. Adım : https://www.glbtrader.com/register-2.html adresine gidelim
         * 2. Adım : GlbSignUpPage class'ından nesne üretip, webelementleri kullanalım.
         * 3. Adım : İçerisine ekleyeceğimiz bilgileri (name, email, phone vs) yine
         *           ConfigurationReader kullanarak, properties file'dan alalım.
         * 4. Adım : Sign-Up butonuna tıklayalım.
         * 5. Adım : Success yazısını görüp görmediğimi Assert ile doğrulayalım.
         *
         */
        //https://www.glbtrader.com/register-2.html
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_login"));
        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        glbSignUpPage.emailkutu.sendKeys(ConfigurationReader.getProperty("glb_email"));
        glbSignUpPage.namekutu.sendKeys(ConfigurationReader.getProperty("glb_name"));
        glbSignUpPage.telefonkutu.sendKeys(ConfigurationReader.getProperty("glb_phone"));
        glbSignUpPage.sifre.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage.sifreconfirm.sendKeys(ConfigurationReader.getProperty("glb_sifre"));
        glbSignUpPage.signupbutonu.click();
        // signUp butonuna tıkladıktan sonra, Success!! yazısını hemen alabilir miyim ?
        System.out.println(glbSignUpPage.SuccesYazisi.getText());
        boolean dogruMu = glbSignUpPage.SuccesYazisi.getText().contains("Success");
        Assert.assertTrue(dogruMu);
    }
    @AfterClass
    public void tearDown(){
        // Driver class'ının içerisindeki closeDriver methodunu çağırmamız yeterli.
        // Driver'ı kapattık ve hafızadan sildik.
        Driver.closeDriver();
    }
}