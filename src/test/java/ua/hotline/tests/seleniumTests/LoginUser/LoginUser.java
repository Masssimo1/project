package ua.hotline.tests.seleniumTests.LoginUser;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ua.hotline.tests.api.components.BaseUrl;
import ua.hotline.tests.api.components.pages.HomePage;
import ua.hotline.tests.api.components.pages.LoginPage;
import ua.hotline.tests.seleniumTests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
@Feature("Login")
@Issue("EZ-4441")
public class LoginUser extends BaseTest {

    private static final String USERNAME = "m71920910@gmail.com";
    private static final String PASSWORD = "71920910";


    //TC should be moved to another class as Smoke Test
    @Test (description = "Go to Login Page From Home Page Header")
    @Issue("EZ-8885")
    @Description ("Check the Login button on Header Home Page")
    void verifyLoginButtonOnMainPage() {
        HomePage homePage = new HomePage(BaseUrl.homePageBaseUrl());
        homePage.open().getHeaderButtonsSection()
                .getLoginAreaButton().clickOnLoginAreaButton("https://hotline.ua/login/");
    }
    //TC should be moved to another class as Smoke Test
    @Test (description = "Verify Login page elements")
    @Issue("EZ-8885")
    void verifyTextElementsOnLoginPage() {
        LoginPage loginPage = new LoginPage(BaseUrl.loginPageBaseUrl());
        loginPage.open().getPageLogoLink();
        loginPage.getSectionTitle();
        loginPage.getTitleRelatedToFields();


        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(loginPage.getPageLogoLink()).isEqualTo("https://hotline.ua/public/i/logo-v2.svg");
        softly.assertThat(loginPage.getSectionTitle()).isEqualTo("Вход");
        softly.assertThat(loginPage.getTitleRelatedToFields()).isEqualTo("Заполните поля");
        softly.assertAll();
    }

    //TC should be moved to another class as Smoke Test
    @Test
    @Issue("EZ-8885")
    void verifyGeneralElementsOnLoginPage() {
        LoginPage loginPage = new LoginPage(BaseUrl.loginPageBaseUrl());
        loginPage.open().getStatusLoginFields();
        LoginPage.getButtonsStatus();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(loginPage.getStatusLoginFields()).isTrue();
        softly.assertThat(LoginPage.getButtonsStatus()).isTrue();
        softly.assertAll();

    }


    @Test (description = "Login with valid credentials ")
    void LoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(BaseUrl.loginPageBaseUrl());
        loginPage.open().typeUsername(USERNAME).typeUserPassword(PASSWORD);
        LoginPage.getEnterButton().clickOnButton();

        //Captcha :(
        WebDriverWait explicitWait = new WebDriverWait(BaseTest.getDriver(),15);
        explicitWait.until(ExpectedConditions.urlContains("login132"));
    }
//
//    @Test (description = "Log with invalid credentials")
//    void failLoginWithInvalidCredentials () {
//        LoginPage loginPage = new LoginPage(BaseUrl.loginPageBaseUrl());
//        loginPage.open().typeUsername().typeUserPassword().enterButton.click();
//    }

}
