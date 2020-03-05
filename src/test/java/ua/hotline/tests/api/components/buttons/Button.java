package ua.hotline.tests.api.components.buttons;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.hotline.tests.api.components.Clickable;
import ua.hotline.tests.api.components.Visible;

import static ua.hotline.tests.api.utils.CustomSeleniumActions.doFindElement;

@Slf4j
public class Button implements Visible, Clickable {
    private final By sectionSelector;

    public Button ( By parentSelector){
        this.sectionSelector = parentSelector;
    }

    @Override
    public boolean elementIsVisible() {
        return doFindElement(sectionSelector).isDisplayed();
    }

    @Override
    public boolean elementIsNotVisible() {
        if (doFindElement(sectionSelector).isDisplayed()) {
            log.info("Button is displayed");
        return false;
        } else {
            return true;
        }
    }

    @Override
    public WebElement clickOnButton() {
         doFindElement(sectionSelector).click();
        return null;
    }

    @Override
    public WebElement getRootElement() {
        return doFindElement(sectionSelector);
    }
}
