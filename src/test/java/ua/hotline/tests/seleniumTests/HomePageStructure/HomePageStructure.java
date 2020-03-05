package ua.hotline.tests.seleniumTests.HomePageStructure;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import ua.hotline.tests.api.components.BaseUrl;
import ua.hotline.tests.api.components.pages.HomePage;
import ua.hotline.tests.seleniumTests.BaseTest;

@Feature("Home Page")
@Issue("EZ-2658")
public class HomePageStructure extends BaseTest {

        @Test (description = "All sections are displayed on the Home Page")
        @Description("Check that all sections are displayed on the Home page")
        @Severity(SeverityLevel.BLOCKER)
        @Issue("EZ-2658-1")
        void verifyHomePageSections(){
            String baseUrl = BaseUrl.homePageBaseUrl();
            HomePage homePage = new HomePage(baseUrl);
            homePage.open().getHeaderButtonsSection().elementIsVisible();
            homePage.open().getHeaderLanguageAndCitySection().elementIsVisible();
            homePage.open().getSearchBoxSection().elementIsVisible();
            homePage.open().getDropdownMenuSection().elementIsVisible();
            homePage.open().getDataMenuSection().elementIsVisible();
        }
    }
