package ua.hotline.tests.api.components;


import io.qameta.allure.Step;

public interface Section extends Visible {

    @Override
    @Step ("Verify {0} section")
    default boolean elementIsVisible() {
        getRootElement().isDisplayed();
        return true;
    }

    @Override
    default boolean elementIsNotVisible() {
        if (getRootElement().isDisplayed()) {
            System.out.println("Section is displayed, but should not be");
            return false;
        } else {
            return true;
        }
    }
}
