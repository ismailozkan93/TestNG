package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_day09_DropDown extends TestBase {

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        select.selectByIndex(1);
        WebElement secim1=select.getFirstSelectedOption();
        System.out.println(secim1.getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        select.selectByValue("2");
        WebElement secim2=select.getFirstSelectedOption();
        System.out.println(secim2.getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        select.selectByVisibleText("Option 1");
        WebElement secim3=select.getFirstSelectedOption();
        System.out.println(secim3.getText());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println();
        List<WebElement>liste= select.getOptions();
        for(WebElement w : liste){
            System.out.println(w.getText());
        }

        int oge= liste.size();
        System.out.println(oge);


if(oge==4){
    System.out.println("True");
}else {
    System.out.println("False");
}



    }

}
