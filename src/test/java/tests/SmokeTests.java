package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SmokeTests extends BaseTest{
    private String PRODUCT_IN_CART_COUNT = "1 товар";
    private String COMPANY_FILTER = "SAMSUNG";
    private String MEMORY_FILTER = "512";
    private static final long TIME_TO_WAIT = 5000;

    @Test(priority = 1)
    public void checkAddProductToCart() {
        getWebDriver().get(HOME_PAGE_URL);
        getHomePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getHomePage().openBestSellerProduct();
        getProductPage().clickAddProductToBookmarkListButton();
        WebDriverWait wait = new WebDriverWait(getProductPage().getWebDriver(),TIME_TO_WAIT);
        wait.until(ExpectedConditions.visibilityOf(getProductPage().getProductCartListPopUp()));
        assertEquals(PRODUCT_IN_CART_COUNT,getProductPage().getProductSuccessfullySavedTitle().getText());
    }

    @Test(priority = 2)
    public void checkAddProductToComparator() throws InterruptedException {
        getWebDriver().get(SMARTPHONE_LIST_PAGE_URL);
        getSmartphonesListPage().openProductPageFromGrid(1);
        getHomePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getSmartphonesListPage().addProductToComparator();
        getWebDriver().navigate().back();
        getHomePage().waitForPageLoadComplete(TIME_TO_WAIT);
        getSmartphonesListPage().openProductPageFromGrid(2);
        getSmartphonesListPage().waitForPageLoadComplete(TIME_TO_WAIT);
        getSmartphonesListPage().addProductToComparator();
        Thread.sleep(2000);
        assertEquals("2",getSmartphonesListPage().getComparatorCount().getText());
    }
    @Test(priority = 3)
    public void checkSearchFiltersSamsung512(){
        getWebDriver().get(SMARTPHONE_LIST_PAGE_URL);
        getSmartphonesListPage().clickSamsungCompanySearchFilter();
        getSmartphonesListPage().clickPhoneMemorySearchFilter();
        getSmartphonesListPage().clickSubmitFilterButton();
        getSmartphonesListPage().waitForAjaxToComplete(TIME_TO_WAIT);
        getSmartphonesListPage().clickOnFirstSearchedElement();
        WebDriverWait wait = new WebDriverWait(getProductPage().getWebDriver(),TIME_TO_WAIT);
        wait.until(ExpectedConditions.visibilityOf(getSmartphonesListPage().getElementMemoryValue()));
        wait.until(ExpectedConditions.visibilityOf(getSmartphonesListPage().getPageTitle()));
        assertTrue(getSmartphonesListPage().getPageTitle().getText().contains(COMPANY_FILTER));
        assertTrue(getSmartphonesListPage().getElementMemoryValue().getText().contains(MEMORY_FILTER));
    }
}
