package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CsAlertTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
     @Test
     public void jsTestAlert() {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

         WebElement btn=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
         btn.click();


         //alertin icerdigi mesaji almak icin getTexti kullaniriz.
        String alertMesaji = driver.switchTo().alert().getText();
         System.out.println(alertMesaji);

        //alertin icerisindeki "okay" butonuna tiklamak icin kullanilir.
         driver.switchTo().alert().accept();
        }
       @Test
    public void jsConfirmTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement btnconfirm=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        btnconfirm.click();

        String mesaj=driver.switchTo().alert().getText();
        System.out.println(mesaj);

        driver.switchTo().alert().dismiss();

       }

       @Test
    public void jsPromptTest(){
           driver.get("https://the-internet.herokuapp.com/javascript_alerts");
           WebElement mesajbtn= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
            mesajbtn.click();

           String mesaj = driver.switchTo().alert().getText();
           System.out.println(mesaj);
           driver.switchTo().alert().sendKeys("Merhaba TestNG");
           driver.switchTo().alert().accept();

       }



    }

