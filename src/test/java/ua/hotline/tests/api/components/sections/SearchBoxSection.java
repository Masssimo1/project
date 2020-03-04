package ua.hotline.tests.api.components.sections;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.hotline.tests.api.components.Section;

@Slf4j
public class SearchBoxSection implements Section {
    private final By parentSelector = By.id("searchbox");
    private WebDriver driver;

    public SearchBoxSection(WebDriver driver) {
        this.driver = driver ;
    }

    @Override
    public WebElement getRootElement() {
        return this.driver.findElement(parentSelector);
    }
}
