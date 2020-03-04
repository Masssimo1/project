package ua.hotline.tests.api.components;




public interface Section extends Visible {

    @Override
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
