package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ornek_AmazonKayitSayfasi extends TestBase {

   @Test
   public void test01() {
       driver.get("http://www.amozon.com");
       WebElement buton = driver.findElement(By.id("nav-link-accountList"));
       Actions actions = new Actions(driver);
       actions.moveToElement(buton).perform();
       WebElement link = driver.findElement(By.partialLinkText("Start here"));
       link.click();
   }
        @Test (dependsOnMethods = "test01")
       public void test02(){
       WebElement isim= driver.findElement(By.id("ap_customer_name"));
       isim.sendKeys("Hamza Yılmaz");
       driver.findElement(By.id("ap_email")).sendKeys("hamzayilmaz2020@protonmail.com");
       driver.findElement(By.id("ap_password")).sendKeys("Amazon06.");
       driver.findElement(By.id("ap_password_check")).sendKeys("Amazon06.");
       driver.findElement(By.id("continue")).click();






       }



   }




