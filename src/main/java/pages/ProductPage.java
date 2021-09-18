package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    @FindBy(xpath = "//div[@class='product-menu-wrap js-product-menu']//div[@class='button  buy-button product-buy-button']")
    private WebElement addProductToBookmarkListButton;

    @FindBy(xpath = "//div[@class='footer flex right-xs']//button[@class='footer__btn btn btn--graphite']")
    private WebElement saveProductToBookmarkListButton;

    @FindBy(xpath = "//span[@id='cartItemsCount']")
    private WebElement productSuccessfullySavedTitle;

    public WebElement getProductCartListPopUp() {
        return productCartListPopUp;
    }

    @FindBy(xpath = "//div[@class='tooltip slot tooltip_active']")
    private WebElement productCartListPopUp;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getProductSuccessfullySavedTitle() {
        return productSuccessfullySavedTitle;
    }

    public void clickAddProductToBookmarkListButton() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", addProductToBookmarkListButton);
    }
}
