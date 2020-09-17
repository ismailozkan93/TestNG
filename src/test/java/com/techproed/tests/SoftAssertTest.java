package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

     @Test
    public void test01(){

        driver.get("http://www.amazon.com");
        String baslik = driver.getTitle();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(baslik.contains("Amazon"));
        softAssert.assertTrue(baslik.contains("Car"));
        softAssert.assertEquals("Online",baslik);

        softAssert.assertAll();
    }
    @Test
    public void test02(){

        SoftAssert softAssert=new SoftAssert();
        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement emailkutu=driver.findElement(By.id("session_email"));
        emailkutu.sendKeys("testtechproed@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement sifreKutusu = driver.findElement(By.id("session_password"));
        sifreKutusu.sendKeys("Test1234!");

        softAssert.assertTrue(driver.getTitle().equals("Deneme"));

        WebElement signin=driver.findElement(By.name("commit"));
        signin.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement signoutlink = driver.findElement(By.partialLinkText("Sign out"));
        boolean gorunuyormu=signoutlink.isDisplayed();


        softAssert.assertTrue(gorunuyormu);
        softAssert.assertAll();


    }







}
