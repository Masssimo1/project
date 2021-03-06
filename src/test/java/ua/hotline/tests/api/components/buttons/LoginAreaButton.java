package ua.hotline.tests.api.components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import ua.hotline.tests.api.components.CurrentPageURL;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.hotline.tests.api.utils.CustomSeleniumActions.doFindElement;

public class LoginAreaButton extends Button{

    private final By buttonSelector;

    public LoginAreaButton( By parentSelector) {
        super(parentSelector);
        this.buttonSelector = new ByChained(parentSelector, By.className("item-login"));
    }

    public LoginAreaButton clickOnLoginAreaButton(String url){
        doFindElement(buttonSelector).click();
        String loginPageURL = CurrentPageURL.getCurrentUrl();
        assertThat(loginPageURL).isEqualTo(url);
        return this;
    }
}
