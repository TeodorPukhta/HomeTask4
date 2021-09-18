package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SmartphonesListPage extends BasePage {
    @FindBy(xpath = "//div[@class='card js-card sc-product']")
    private List<WebElement> listElements;
    @FindBy(xpath = "//div[@class='product-box__response product-box__content-col']//i[@class='icon-compare-2']")
    private WebElement addToComparatorButton;

    @FindBy(xpath = "//div[@class='header-tooltip__count js-toggle-tooltip']")
    private WebElement comparatorCount;

    @FindBy(xpath = "//label[contains(text(),'SAMSUNG')]")
    private WebElement samsungCompanySearchFilter;

    @FindBy(xpath = "//div[p/text()= 'Вбудована пам’ять, Гб']//following-sibling::div//a//label[contains(text(),'512')]")
    private WebElement phoneMemorySearchFilter;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitFilterButton;

    @FindBy(xpath = "//div[@class='listing__body-wrap image-switch']//div[@class='card__body']/a")
    private WebElement firstElementTitle;

    @FindBy(xpath = "//h1[@class='page__title overflow']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='product-img__specs']//label[contains(text(),'Вбудована')]//following-sibling::p")
    private WebElement elementMemoryValue;

    public WebElement getElementMemoryValue() {
        return elementMemoryValue;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getFirstElementTitle() {
        return firstElementTitle;
    }

    public void clickOnFirstSearchedElement() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", firstElementTitle);
    }

    public WebElement getComparatorCount() {
        return comparatorCount;
    }

    public SmartphonesListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openProductPageFromGrid(final int index) {
        listElements.get(index).click();
    }

    public void addProductToComparator() {
        addToComparatorButton.click();
    }

    public void clickSamsungCompanySearchFilter() {
        samsungCompanySearchFilter.click();
    }

    public void clickPhoneMemorySearchFilter() {
        phoneMemorySearchFilter.click();
    }

    public void clickSubmitFilterButton() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", submitFilterButton);
    }
}
