package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {

    public void giris() {
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    @Test
    public void test() {
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        WebElement tbody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        List <WebElement> basliklar= driver.findElements(By.xpath("//thead/tr/th"));
        for (WebElement w : basliklar) {
            System.out.println( w.getText() );
        }

    }
    @Test
    public void tumSatirlar() {
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        List<WebElement> tumsatirlar = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement w : tumsatirlar) {
            System.out.println(w.getText());
        }
    }
        @Test
        public void tumHucreler(){
            giris();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<WebElement> tumhucreler = driver.findElements(By.xpath("//tbody/tr/td"));
            for (WebElement w : tumhucreler) {
                System.out.println(w.getText());
            }
            System.out.println(tumhucreler.size());
        }
        @Test
        public void belirliBirSutunYazdirma(){
        giris();

        List<WebElement> dorduncusutun= driver.findElements(By.xpath("//tbody/tr/td[4]"));
            for (WebElement w : dorduncusutun) {
                System.out.println(w.getText());
            }
            System.out.println("-------------");
            System.out.println(dorduncusutun.size());
        }
        @Test
        public void calistir(){
        giris();
        hucreYazdir(3,5);
        hucreYazdir(5,2);
        hucreYazdir(2,1);
        hucreYazdir(9,4);
        }
        public void hucreYazdir(int satir, int sutün){
        //tbody/tr[3]/td[5]
            String xpathdegerim="//tbody/tr["+ satir +"]/td["+ sutün +"]";
            WebElement hucre= driver.findElement(By.xpath(xpathdegerim));
            System.out.println(hucre.getText());
        }

    }





