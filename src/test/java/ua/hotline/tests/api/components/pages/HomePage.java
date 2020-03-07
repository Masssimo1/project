package ua.hotline.tests.api.components.pages;

import lombok.extern.slf4j.Slf4j;
import ua.hotline.tests.api.components.sections.*;
import ua.hotline.tests.seleniumTests.BaseTest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class HomePage{

    private String url;

    public HomePage(String baseUrl){
        this.url = baseUrl;
    }

    public HomePage open() {
        BaseTest.getDriver().get(this.url);
        return this;
    }

    public HeaderButtonsSection getHeaderButtonsSection() {
        return new HeaderButtonsSection ();
    }

    public HeaderLanguageAndCitySection getHeaderLanguageAndCitySection() {
        return new HeaderLanguageAndCitySection();
    }

    public SearchBoxSection getSearchBoxSection() {
        return new SearchBoxSection();
    }

    public DropdownMenuSection getDropdownMenuSection () {
        return new DropdownMenuSection();
    }

    public DataMenuSection getDataMenuSection () {
        return new DataMenuSection();
    }

//    @Override
//    public boolean isThereJSErrorOnThePage(){
//            Set<String> errorStrings = new HashSet<>();
//            errorStrings.add("Error");
//            errorStrings.add("Unchecked runtime");
//            errorStrings.add("Could not");
//            errorStrings.add("associated");
//            LogEntries logEntries = BaseTest.getDriver().manage().logs().get(LogType.BROWSER);
//            for (LogEntry logEntry : logEntries) {
//                for (String errorString : errorStrings) {
//                    if (logEntry.getMessage().contains(errorString)) {
//                        log.error("Java Script error has been detected:");
//                        log.error(new Date(logEntry.getTimestamp()) + " " + logEntry.getLevel() + " " + logEntry.getMessage());
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
    }



//    public Button getLoginButton() {
//        return new Button(this.driver,this.parentSelector)
//
//
//    }

