package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ornekasserday8 extends TestBase {


    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.bestbuy.com/");
    }
    @AfterMethod
    public void afterMethod(){

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.quit();
    }

    @Test
    public void titleTest(){

        String title=driver.getTitle();
        System.out.println(title);
        Boolean ICERIYORMU=title.contains("Best");
        Assert.assertTrue(ICERIYORMU);

    }
    @Test
    public void logoTest(){
        WebElement logo=driver.findElement(By.xpath("//*[@class='logo']"));
        boolean gorunur=!logo.isDisplayed();
        Assert.assertFalse(gorunur);

    }
    @Test
    public void linkTest(){
        WebElement link= driver.findElement(By.linkText("Mexico"));
        Assert.assertTrue(link.isDisplayed());


    }
}
