package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;

public class Ornek_IFrame_Day12 extends TestBase {
    @Test
    public void IframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe ");
        driver.switchTo().frame("mce_0_ifr");
        WebElement consol= driver.findElement(By.xpath("//p"));
        consol.clear();
        consol.sendKeys("Merhaba Dunya");
        String framelisayfa= driver.getWindowHandle();
        driver.switchTo().defaultContent();
        WebElement linktext= driver.findElement(By.linkText("Elemental Selenium"));
        linktext.click();
        String selenyumsayfa=driver.getWindowHandle();
        System.out.println(selenyumsayfa);
        String yazi=linktext.getText();
        System.out.println(yazi);
        driver.switchTo().window(framelisayfa);
        driver.switchTo().frame(0);
        driver.switchTo().parentFrame();
        System.out.println(framelisayfa);

        Set<String>windows= driver.getWindowHandles();
        for (String w:windows) {
            System.out.println(w);
        }
        System.out.println(windows.size());


    }


}
