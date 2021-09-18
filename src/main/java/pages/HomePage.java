package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String BEST_SELLER_PRODUCT_LIST = "//div[contains(@class,'products-best')]//div[@class='owl-item active']//a[@class='card__title']";

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void openBestSellerProduct(){
        webDriver.findElement(By.xpath(BEST_SELLER_PRODUCT_LIST)).click();
    }
}
