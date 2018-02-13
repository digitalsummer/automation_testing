package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class RozetcaResultPage {
    WebDriver driver;

    public RozetcaResultPage (WebDriver driver) {
        this.driver = driver;
    }

    private String getNumberString(String price){
        char[] chars = price.toCharArray();
        String result = "";
        for(char ch : chars){
            if(Character.isDigit(ch)){
                result+=ch;
            }
        }
        return  result;
    }

    public boolean MinPriceIsValid(String MinPrice){

        boolean present = true;
        List<WebElement> link = driver.findElements(By.cssSelector(".g-price-uah"));
        for (int i =0; i < link.size(); i++) {
            String price;
            price = link.get(i).getText();
            int realPrice = Integer.parseInt(getNumberString(price));
            int minPrice = Integer.parseInt(MinPrice);
            if (realPrice<=minPrice)
                 present = false;
            }
            return present;
    }
}
