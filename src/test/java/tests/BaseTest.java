package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ProductPage;
import pages.SmartphonesListPage;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();
    public static final String HOME_PAGE_URL = "https://www.foxtrot.com.ua/uk";
    public static final String SMARTPHONE_LIST_PAGE_URL = "https://www.foxtrot.com.ua/uk/shop/mobilnye_telefony_smartfon.html";
    @BeforeTest
    public void profileSetup() {
        chromedriver().setup();
    }

    @BeforeMethod
    @Parameters(value={"browser"})
    public void testsSetup(@Optional("firefox")String browser) throws MalformedURLException {
        webDriver.set(new RemoteWebDriver(new URL("http://192.168.0.106:4444/wd/hub"),capabilityFactory.getCapabilities(browser)));
        getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        getWebDriver().close();
    }
    @AfterClass
    void terminate(){
        webDriver.remove();
    }

    public WebDriver getWebDriver() {
        return  webDriver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getWebDriver());
    }
    public ProductPage getProductPage() {return new ProductPage(getWebDriver()); }
    public SmartphonesListPage getSmartphonesListPage(){return new SmartphonesListPage(getWebDriver());}
}
