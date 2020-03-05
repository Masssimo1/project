package ua.hotline.tests.seleniumTests.HomePageStructure;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hotline.tests.api.components.pages.HomePage;
import ua.hotline.tests.seleniumTests.BaseTest;
import ua.hotline.tests.seleniumTests.DriverProperties;

@Feature("Home Page")
@Issue("EZ-2658")
public class HomePageStructure extends BaseTest {

        @Test (description = "All sections are displayed on the Home Page")
        @Description("Check that all sections are displayed on the Home page")
        @Severity(SeverityLevel.BLOCKER)
        @Issue("EZ-2658-1")
        void verifyHomePageSections(){
            DriverProperties properties = DriverProperties.getInstance();
            String baseUrl = properties.getScheme() + properties.getHost();
            HomePage homePage = new HomePage(baseUrl);
            homePage.open().getHeaderButtonsSection().elementIsVisible();
            homePage.open().getHeaderLanguageAndCitySection().elementIsVisible();
            homePage.open().getSearchBoxSection().elementIsVisible();
            homePage.open().getDropdownMenuSection().elementIsVisible();
            homePage.open().getDataMenuSection().elementIsVisible();
        }
    }
