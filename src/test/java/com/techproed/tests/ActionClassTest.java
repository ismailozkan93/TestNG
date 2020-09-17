package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassTest extends TestBase {
@Test
public void sagTiklama(){
    driver.get("https://the-internet.herokuapp.com/context_menu");
    WebElement element= driver.findElement(By.id("hot-spot"));
    Actions actions=new Actions(driver);


    //bir webelemente sag tiklamak icin bu kodu kullaniriz.
    //actions class ile islem yaparsaniz,Her seferinde PERFOM  yapmak zorundadir.

    actions.contextClick(element).perform();
}
@Test
public void ciftTiklama(){//<button ondblclick="myFunction()">Double-Click Me To See Alert</button>
    driver.get("http://demo.guru99.com/test/simple_context_menu.html");
    WebElement button= driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
    Actions actions=new Actions(driver);
    actions.doubleClick(button).perform();
}
@Test
 public void hoverOver(){
    driver.get("http://www.amazon.com");
    WebElement menu= driver.findElement(By.id("nav-link-accountList"));
    Actions actions=new Actions(driver);
    actions.moveToElement(menu).perform();
}
@Test
    public void asagiYukari(){
    driver.get("http://www.amazon.com");
    Actions actions=new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    try {
        Thread.sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    actions.sendKeys(Keys.END).perform();
    try {
        Thread.sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    actions.sendKeys(Keys.PAGE_UP).perform();
    actions.sendKeys(Keys.ARROW_UP).perform();
    try {
        Thread.sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    actions.sendKeys(Keys.HOME).perform();

}

@Test
    public void buyukKucukYazma(){
    //Merhaba nasilsiniz LIVE channel

    driver.get("http://google.com");
    WebElement aramakutu= driver.findElement(By.name("q"));
    //aramakutu.sendKeys(Keys.SHIFT+"merhaba nasilsiniz live channel");// HER KARAKTERI BÜYÜK HARFLE YAZAR

    Actions actions=new Actions(driver);
    actions.moveToElement(aramakutu).click()
            .keyDown(Keys.SHIFT)
            .sendKeys("merhaba")
            .keyUp(Keys.SHIFT)
            .sendKeys("nasilsiniz")
            .perform();

}
@Test
    public void draganddrop(){
    driver.get("http://google.com");
    WebElement aramakutu= driver.findElement(By.name("q"));
    WebElement logo=driver.findElement(By.id("hplogo"));
    Actions actions=new Actions(driver);
    actions.dragAndDrop(logo,aramakutu).perform();



}

}

