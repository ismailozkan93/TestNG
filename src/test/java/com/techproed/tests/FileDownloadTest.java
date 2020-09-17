package com.techproed.tests;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarMi(){

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullanicidosyayolu=System.getProperty("user.dir");
        String pomxmlyolu=kullanicidosyayolu+"/pom.xml";
        boolean varmi= Files.exists(Paths.get(pomxmlyolu));

        Assert.assertTrue(varmi);
    }
    @Test
    public void dosyaUpload(){

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSecme=driver.findElement(By.id("file-upload"));
        dosyaSecme.sendKeys("C:/Users/Ismail/Desktop/logo.jpg");
        WebElement uploadButon=driver.findElement(By.id("file-submit"));
        uploadButon.submit();
        WebElement FileUpload=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(FileUpload.isDisplayed());

    }

    @Test
    public void dosyaDownload(){
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement amsterdamlinki= driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        amsterdamlinki.click();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        boolean varMi=Files.exists(Paths.get("C:/Users/Ismail/Downloads/Amsterdam.jpg"));

        Assert.assertTrue(varMi);
    }





}
