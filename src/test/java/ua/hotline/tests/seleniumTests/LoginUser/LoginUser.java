package ua.hotline.tests.seleniumTests.LoginUser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hotline.tests.api.components.pages.HomePage;
import ua.hotline.tests.seleniumTests.BaseTest;
import ua.hotline.tests.seleniumTests.DriverProperties;

public class LoginUser extends BaseTest {

    private WebDriver driver;


    @BeforeClass
    public void setUpClass() {
        System.out.println("In Before class");
        this.driver = getDriver();
    }

    @Test
    void verifyLoginButtonOnMainPage() {
        DriverProperties properties = DriverProperties.getInstance();
        String baseUrl = properties.getScheme() + properties.getHost();
        HomePage homePage = new HomePage(driver, baseUrl);
        homePage.open()
                .getHeaderButtonsSection()
                .getLoginAreaButton().clickOnLoginAreaButton("https://hotline.ua/login/");
    }

    @Test
    void verifyElementsOnLoginPage() {

    }
}
