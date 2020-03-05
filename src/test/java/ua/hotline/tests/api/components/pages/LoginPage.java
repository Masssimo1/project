package ua.hotline.tests.api.components.pages;

import ua.hotline.tests.seleniumTests.BaseTest;

public class LoginPage {
    private String url;

    public LoginPage (String baseUrl){
        this.url = baseUrl;
    }

    public LoginPage open() {
        BaseTest.getDriver().get(this.url);
        return this;
    }
}
