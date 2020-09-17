package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Ornek_Softassert_day11 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement email= driver.findElement(By.className("form-control"));
        email.sendKeys("testtechproed@gmail.com");
        WebElement sifre=driver.findElement(By.id("session_password"));
        sifre.sendKeys("Test1234!");
        driver.findElement(By.xpath("//input[@value='Sign in']")).submit();
        WebElement text=driver.findElement(By.xpath("//span[@class='navbar-text']"));
        System.out.println(text.getText());
        System.out.println(driver.getTitle());
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals("Address Book",driver.getTitle());
        softAssert.assertFalse(!text.isDisplayed());
        softAssert.assertTrue(text.getText().equals("testtechproed@gmail.com"));
       softAssert.assertAll();

    }

}
