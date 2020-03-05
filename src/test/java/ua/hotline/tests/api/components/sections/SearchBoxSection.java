package ua.hotline.tests.api.components.sections;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.hotline.tests.api.components.Section;

import static ua.hotline.tests.api.utils.CustomSeleniumActions.doFindElement;

@Slf4j
public class SearchBoxSection implements Section {
    private final By parentSelector = By.id("searchbox");

    @Override
    public WebElement getRootElement() {
        return doFindElement(parentSelector);
    }
}
