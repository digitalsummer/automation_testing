package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Weiters {
    public static void ImplicitlyWait(WebDriver driver, int weit_time){
        driver.manage().timeouts().implicitlyWait(weit_time, TimeUnit.SECONDS);
    }

    public static void weit_until(WebDriver driver, String linkaboutweit, int timeOutInSeconds){
        WebDriverWait weit = new WebDriverWait(driver, timeOutInSeconds);
        weit.until(ExpectedConditions.urlToBe(linkaboutweit));
    }
}

