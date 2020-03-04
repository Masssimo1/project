package ua.hotline.pages;

import org.openqa.selenium.WebDriver;
import ua.hotline.buttons.Button;
import ua.hotline.sections.HeaderButtonsSection;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    private WebDriver driver;
    private String url;

    public MainPage (WebDriver driver, String baseUrl){
        this.driver = driver;
        this.url = baseUrl;

    }

    public MainPage open() {
        this.driver.get(this.url);
        return this;
    }

    public HeaderButtonsSection getHeaderButtonsSection() {
        return new HeaderButtonsSection (this.driver);
    }

//    public Button getLoginButton() {
//        return new Button(this.driver,this.parentSelector)
//
//
//    }

}
