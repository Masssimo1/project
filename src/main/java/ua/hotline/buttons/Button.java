package ua.hotline.buttons;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.hotline.Clickable;
import ua.hotline.Visible;
@Slf4j
public class Button implements Visible, Clickable {
    private WebDriver driver;
    private final By sectionSelector;

    public Button (WebDriver driver, By parentSelector){
        this.driver = driver;
        this.sectionSelector = parentSelector;
    }

    @Override
    public boolean elementIsVisible() {
        return this.driver.findElement(sectionSelector).isDisplayed();
    }

    @Override
    public boolean elementIsNotVisible() {
        if (this.driver.findElement(sectionSelector).isDisplayed()) {
            log.info("Button is displayed");
        return false;
        } else {
            return true;
        }
    }

    @Override
    public WebElement clickOnButton() {
         this.driver.findElement(sectionSelector).click();
        return null;
    }
}
