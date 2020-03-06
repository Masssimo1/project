package ua.hotline.tests.api.components.pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import ua.hotline.tests.api.components.buttons.Button;
import ua.hotline.tests.seleniumTests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.hotline.tests.api.utils.CustomSeleniumActions.doFindElement;
import static ua.hotline.tests.api.utils.CustomSeleniumActions.doSendKeys;

public class LoginPage {
    private String url;
    private static final By ENTER_BUTTON = By.className("btn-graphite");
    private static final By GOOGLE_BUTTON = By.id("googleLogin");
    private static final By FACEBOOK_BUTTON = By.cssSelector("div[class=\"cell-6\"]:nth-child(1)>span");
    private static final By USERNAME_INPUT_SELECTOR = By.name("login");
    private static final By PASSWORD_INPUT_SELECTOR = By.name("password");

    public LoginPage(String baseUrl) {
        this.url = baseUrl;
    }

    public LoginPage open() {
        BaseTest.getDriver().get(this.url);
        return this;
    }

    public LoginPage typeUsername(String username) {
        doSendKeys(USERNAME_INPUT_SELECTOR, username);
        return this;
    }

    public LoginPage typeUserPassword(String password) {
        doSendKeys(PASSWORD_INPUT_SELECTOR, password);
        return this;
    }

    public String getPageLogoLink() {
        return doFindElement(By.cssSelector("div[class=\"header-short header-logo\"] > a >img")).getAttribute("src");
    }

    public String getSectionTitle() {
        return doFindElement(By.className("h3")).getText();

    }

    public String getTitleRelatedToFields() {
        return doFindElement(By.className("h4")).getText();
    }


    public boolean getStatusLoginFields() {
        return doFindElement(PASSWORD_INPUT_SELECTOR).isDisplayed() && doFindElement(USERNAME_INPUT_SELECTOR).isDisplayed();
    }

    public static boolean getButtonsStatus() {
        return  (getEnterButton().elementIsVisible())&& (getFacebookBotton().elementIsVisible()) && (getGoogleBookBotton().elementIsVisible());
    }


    public static Button getEnterButton() {
        return new Button(ENTER_BUTTON);
    }

    public static Button getFacebookBotton() {
        return new Button(FACEBOOK_BUTTON);
    }

    public static Button getGoogleBookBotton() {
        return new Button(GOOGLE_BUTTON);
    }



}


