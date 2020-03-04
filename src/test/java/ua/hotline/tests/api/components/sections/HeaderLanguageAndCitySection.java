package ua.hotline.tests.api.components.sections;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.hotline.tests.api.components.Section;

@Slf4j
public class HeaderLanguageAndCitySection implements Section {
    private final By parentSelector = By.cssSelector("div[class=\"header-city-language cell-8 cell-sm-6\"]");
    private WebDriver driver;

    public HeaderLanguageAndCitySection (WebDriver driver) {
        this.driver = driver ;
    }

    @Override
    public WebElement getRootElement() {
        return this.driver.findElement(parentSelector);
    }
}