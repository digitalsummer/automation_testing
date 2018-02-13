import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.GoogleResultPage;
import pageobject.GoogleSearchPage;

import java.io.File;
import java.io.IOException;


public class Chrometest {

    static WebDriver driver;

    private void test_for_link(String SERACH_MESSAGE,String Search_link){
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.open();

        GoogleResultPage resultPage =searchPage.search(SERACH_MESSAGE);

        int present;
        do {
            Assert.assertFalse(resultPage.search_some_link(Search_link));
            Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS) . save ( System.currentTimeMillis()+ ".png" );
            present=resultPage.ClickNextPage();
        } while (present != -1);
    }

    @Before
    public void setUp(){
        String exePath = "/home/nina/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }
    @Test
    public void if_link_is_find() {
        final String SERACH_MESSAGE = " лопоухий единорог с рефрижератором ";
        final String Search_link = "iasa.kpi.ua/";

        test_for_link(SERACH_MESSAGE, Search_link);

    }

    @Test
    public void if_link_is_not_found(){

        final String SERACH_MESSAGE = " iasa ";
        final String Search_link = "iasa.kpi.ua/";

        test_for_link(SERACH_MESSAGE, Search_link);
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
