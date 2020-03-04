package ua.hotline.tests.api.components.pages;

import org.openqa.selenium.WebDriver;
import ua.hotline.tests.api.components.sections.*;


public class HomePage {

    private WebDriver driver;
    private String url;

    public HomePage(WebDriver driver, String baseUrl){
        this.driver = driver;
        this.url = baseUrl;

    }

    public HomePage open() {
        this.driver.get(this.url);
        return this;
    }

    public HeaderButtonsSection getHeaderButtonsSection() {
        return new HeaderButtonsSection (this.driver);
    }

    public HeaderLanguageAndCitySection getHeaderLanguageAndCitySection() {
        return new HeaderLanguageAndCitySection(this.driver);
    }

    public SearchBoxSection getSearchBoxSection() {
        return new SearchBoxSection(this.driver);
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
