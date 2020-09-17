package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ornek_Otel_Olusturma extends TestBase {


    @BeforeMethod
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);
    }
    @Test
    public void hotelCreate(){
        WebElement code= driver.findElement(By.id("Code"));
        code.sendKeys("12345");

        WebElement name=driver.findElement(By.id("Name"));
        name.sendKeys("ahmet yildiz");

        WebElement adres=driver.findElement(By.id("Address"));
        adres.sendKeys("neuhausen");

        WebElement phone=driver.findElement(By.id("Phone"));
        phone.sendKeys("1234565678");

        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("ahmetyildiz@gmail.com");

        WebElement dropdown=driver.findElement(By.id("IDGroup"));
        Select select=new Select(dropdown);
        select.selectByIndex(2);
        WebElement btn=driver.findElement(By.id("btnSubmit"));
        btn.submit();

//        WebDriver wait=new WebDriverWait(driver,20);
        
        WebElement basariliyazi=driver.findElement(By.className("bootbox-body"));
        Assert.assertTrue(basariliyazi.isDisplayed());


    }




}




