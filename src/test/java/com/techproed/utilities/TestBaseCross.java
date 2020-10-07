package com.techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


    public abstract class TestBaseCross {

        protected WebDriver driver;
        //Bize parametre olarak browser gelecek(gelirse)
        //Biz de o parametreyi kullanacaüiz.
        //Bu parametre ,xml dosyasina gelecek.


        @Parameters("browser")
        @BeforeMethod
        public void setUp(@Optional String browser) {//optional herhangi bir parametre gelmezse  bile calisir.
            driver = DriverCross.getDriver(browser);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @AfterMethod
        public void tearDown() {
            DriverCross.closeDriver();
        }
    }

