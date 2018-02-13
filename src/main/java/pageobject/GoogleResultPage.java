package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultPage {

    public static final String Link = "._Rm";
    public static final String Click_next_page = "//*[@id='pnnext']/span[2]";
    WebDriver driver;

    public GoogleResultPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean search_some_link(String search_link) {
        List<WebElement> link = driver.findElements(By.cssSelector(Link));
        for (int i =0; i < link.size(); i++) {
            if ( link.get(i).getText().equals(search_link)) {
               return true;
            }
            //  System.out.println("match found");
        }
        return  false;
    }

    public int ClickNextPage(){
        int present;

        if (!driver.findElements(By.xpath(Click_next_page)).isEmpty())
        {
            driver.findElement(By.xpath(Click_next_page)).click();
            present = 1;
        } else {
            present = -1;
        }
        return present;
    }
}
