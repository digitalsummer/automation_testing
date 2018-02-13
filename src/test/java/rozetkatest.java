import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import rozetka.RozetcaResultPage;
import rozetka.RozetcaSearchPage;

import java.io.File;
import java.io.IOException;


public class rozetkatest {

    static WebDriver driver;

    @Before
    public void setUp(){
        String exePath = "/home/nina/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }
    @Test()
    public void aTest() {
        final String MinPrice = "110";

        RozetcaSearchPage searchPage= new RozetcaSearchPage(driver);
        searchPage.open();

        RozetcaResultPage resultPage = searchPage.min_price_filter_page(MinPrice);
        Assert.assertTrue(resultPage.MinPriceIsValid(MinPrice));

    }


    @After
    public void tearDown()  {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(scrFile, new File("JavaTrainingscreenshot.png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //quit WebDriver session
        driver.quit();
    }
}
