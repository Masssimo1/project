package ua.hotline.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

public class LoginAreaButton extends Button{
    private WebDriver driver;
    private final By buttonSelector;

    public LoginAreaButton(WebDriver driver, By parentSelector) {
        super(driver, parentSelector);
        this.driver = driver;
        this.buttonSelector = new ByChained(parentSelector, By.className("item-login"));
    }

    public LoginAreaButton clickOnLoginAreaButton(){
        this.driver.findElement(buttonSelector).click();
        return this;
    }
}
