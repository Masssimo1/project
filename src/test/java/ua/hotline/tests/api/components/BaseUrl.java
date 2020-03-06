package ua.hotline.tests.api.components;

import ua.hotline.tests.seleniumTests.BaseTest;
import ua.hotline.tests.seleniumTests.DriverProperties;

public class BaseUrl extends BaseTest {

    public static String homePageBaseUrl(){
        DriverProperties properties = DriverProperties.getInstance();
        String baseUrl = properties.getScheme() + properties.getHomePageBaseUrl();
        return baseUrl;
    }

    public static String loginPageBaseUrl(){
        DriverProperties properties = DriverProperties.getInstance();
        String baseUrl = properties.getScheme() + properties.getHomePageBaseUrl() + properties.getLoginPageBaseUrl();
        return baseUrl;
    }
}
