package ua.hotline.tests.seleniumTests.LoginUser;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;
import ua.hotline.tests.api.components.pages.HomePage;
import ua.hotline.tests.seleniumTests.BaseTest;
import ua.hotline.tests.seleniumTests.DriverProperties;

@Feature("Login")
@Issue("EZ-4441")
public class LoginUser extends BaseTest {

    @Test (description = "Open the Login page")
    @Issue("EZ-8885")
    @Description ("")
    @Attachment
    void verifyLoginButtonOnMainPage() {
        DriverProperties properties = DriverProperties.getInstance();
        String baseUrl = properties.getScheme() + properties.getHost();
        HomePage homePage = new HomePage(baseUrl);
        homePage.open()
                .getHeaderButtonsSection()
                .getLoginAreaButton().clickOnLoginAreaButton("https://hotline.ua/login/");
    }

    @Test
    void verifyElementsOnLoginPage() {

    }
}
