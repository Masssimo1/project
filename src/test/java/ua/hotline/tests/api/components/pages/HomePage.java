package ua.hotline.tests.api.components.pages;

import org.openqa.selenium.WebDriver;
import ua.hotline.tests.api.components.sections.*;
import ua.hotline.tests.seleniumTests.BaseTest;
import ua.hotline.tests.seleniumTests.DriverProperties;


public class HomePage {

    private String url;

    public HomePage(String baseUrl){
        this.url = baseUrl;
    }

    public HomePage open() {
        BaseTest.getDriver().get(this.url);
        return this;
    }

    public HeaderButtonsSection getHeaderButtonsSection() {
        return new HeaderButtonsSection ();
    }

    public HeaderLanguageAndCitySection getHeaderLanguageAndCitySection() {
        return new HeaderLanguageAndCitySection();
    }

    public SearchBoxSection getSearchBoxSection() {
        return new SearchBoxSection();
    }

    public DropdownMenuSection getDropdownMenuSection () {
        return new DropdownMenuSection();
    }

    public DataMenuSection getDataMenuSection () {
        return new DataMenuSection();
    }


//    public Button getLoginButton() {
//        return new Button(this.driver,this.parentSelector)
//
//
//    }

}
