package ua.hotline.tests.api.components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginAreaButton extends Button{
    private WebDriver driver;
    private final By buttonSelector;

    public LoginAreaButton(WebDriver driver, By parentSelector) {
        super(driver, parentSelector);
        this.driver = driver;
        this.buttonSelector = new ByChained(parentSelector, By.className("item-login"));
    }

    public LoginAreaButton clickOnLoginAreaButton(String url){
        this.driver.findElement(buttonSelector).click();
        String loginPageURL = this.driver.getCurrentUrl();
        assertThat(loginPageURL).isEqualTo(url);
        return this;
    }
}
