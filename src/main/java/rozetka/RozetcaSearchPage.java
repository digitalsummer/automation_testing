package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.GoogleResultPage;

import static utils.Weiters.ImplicitlyWait;

public class RozetcaSearchPage {
    public static final String SERCH_FILD = "";
    public static final String Search_page_rozetka = "https://rozetka.com.ua/hudojestvennaya-literatura/c4326593/";
    WebDriver driver;

    public RozetcaSearchPage (WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(Search_page_rozetka);
        ImplicitlyWait(driver, 10);
    }

    public GoogleResultPage search(String SERACH_MESSAGE) {
        WebElement search_message =  driver.findElement(By.id(SERCH_FILD));
        search_message.sendKeys(SERACH_MESSAGE);
        search_message.submit();
        return new GoogleResultPage(driver);
    }

    public RozetcaResultPage min_price_filter_page(String MinPrice) {
        WebElement price =  driver.findElement(By.id("price[min]"));
        price.sendKeys(MinPrice);
        price.submit();
        return new RozetcaResultPage(driver);
    }
}
