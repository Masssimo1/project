package ua.hotline.tests.LoginUser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hotline.pages.MainPage;
import ua.hotline.tests.BaseTest;
import ua.hotline.tests.DriverProperties;

public class LoginUser extends BaseTest {

    private WebDriver driver;


    @BeforeClass
    public void setUpClass() {
        System.out.println("In Before class");
        this.driver = getDriver();
    }

    @Test
    void verifyLoginButtonOnMainPage() throws InterruptedException {
        DriverProperties properties = DriverProperties.getInstance();
        String baseUrl = properties.getScheme() + properties.getHost();
        MainPage mainPage = new MainPage (driver, baseUrl);
        mainPage.open()
                .getHeaderButtonsSection()
                .getLoginAreaButton()
                .clickOnLoginAreaButton();



    }



}
