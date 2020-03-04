package ua.hotline.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ua.hotline.buttons.LoginAreaButton;

public class HeaderButtonsSection {
    private final By parentSelector = By.cssSelector("div[class=\"header-nav cell-6\"]");
    private WebDriver driver;

    public HeaderButtonsSection(WebDriver driver) {
        this.driver = driver ;
    }

    public LoginAreaButton getLoginAreaButton() {
        return new LoginAreaButton(this.driver, this.parentSelector);

    }



}
