package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.Weiters.ImplicitlyWait;

public class GoogleSearchPage {
    public static final String SERCH_FILD = "lst-ib";
    public static final String Search_page_google = "https://www.google.com.ua";
    WebDriver driver;

    public GoogleSearchPage (WebDriver driver){
       this.driver = driver;
    }
    public void open() {
        driver.get(Search_page_google);
        ImplicitlyWait(driver, 10);
    }

    public GoogleResultPage search(String SERACH_MESSAGE) {
        WebElement search_message =  driver.findElement(By.id(SERCH_FILD));
        search_message.sendKeys(SERACH_MESSAGE);
        search_message.submit();
        return new GoogleResultPage(driver);
    }

}
