package ua.hotline.tests.seleniumTests.HomePageStructure;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.hotline.tests.api.components.pages.HomePage;
import ua.hotline.tests.seleniumTests.BaseTest;
import ua.hotline.tests.seleniumTests.DriverProperties;

public class HomePageStructure extends BaseTest {

        private WebDriver driver;

        @BeforeClass
        public void setUpClass() {
            System.out.println("In Before class");
            this.driver = getDriver();
        }

        @Test (description = "All sections are displayed on the Home Page")
        void verifyHomePageSections(){
            DriverProperties properties = DriverProperties.getInstance();
            String baseUrl = properties.getScheme() + properties.getHost();
            HomePage homePage = new HomePage(driver, baseUrl);
            homePage.open().getHeaderButtonsSection().elementIsVisible();
            homePage.open().getHeaderLanguageAndCitySection().elementIsVisible();
            homePage.open().getSearchBoxSection().elementIsVisible();
            homePage.open().getDropdownMenuSection().elementIsVisible();
            homePage.open().getDataMenuSection().elementIsVisible();
        }
    }
