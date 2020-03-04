package ua.hotline.tests.api.components.sections;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.hotline.tests.api.components.Section;
import ua.hotline.tests.api.components.buttons.LoginAreaButton;

@Slf4j
public class HeaderButtonsSection implements Section {
    private final By parentSelector = By.cssSelector("div[class=\"header-nav cell-6\"]");
    private WebDriver driver;

    public HeaderButtonsSection(WebDriver driver) {
        this.driver = driver;
    }

    public LoginAreaButton getLoginAreaButton() {
        return new LoginAreaButton(this.driver, this.parentSelector);

    }

    @Override
    public WebElement getRootElement() {
        return this.driver.findElement(parentSelector);
    }
}

