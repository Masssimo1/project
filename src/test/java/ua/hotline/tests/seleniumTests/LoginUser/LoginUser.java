package ua.hotline.tests.seleniumTests.LoginUser;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.jsoup.Connection;
import org.testng.annotations.Test;
import ua.hotline.tests.api.components.BaseUrl;
import ua.hotline.tests.api.components.pages.HomePage;
import ua.hotline.tests.api.components.pages.LoginPage;
import ua.hotline.tests.seleniumTests.BaseTest;

@Feature("Login")
@Issue("EZ-4441")
public class LoginUser extends BaseTest {

    @Test (description = "Go to Login Page From Home Page Header")
    @Issue("EZ-8885")
    @Description ("Check the Login button on Header Home Page")
    void verifyLoginButtonOnMainPage() {
        HomePage homePage = new HomePage(BaseUrl.homePageBaseUrl());
        homePage.open().getHeaderButtonsSection()
                .getLoginAreaButton().clickOnLoginAreaButton("https://hotline.ua/login/");
    }

    @Test (description = "Verify Login page elements")
    @Issue("EZ-8885")
    void verifyElementsOnLoginPage() {
        LoginPage loginPage = new LoginPage(BaseUrl.loginPageBaseUrl());
        loginPage.open();
    }
}
