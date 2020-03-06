package ua.hotline.tests.seleniumTests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ua.hotline.tests.seleniumTests.driver.WebDriverThread;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Listeners(AttachmentsListener.class)
public class BaseTest {
    // A list to store all instances of WebDriverThread
    // A thread won't be able to modify the list while another thread is currently running a method from this list.
    // The object is locked while processing method.
    private static List<WebDriverThread> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<WebDriverThread> driverThread;

    //used in tests page objects' variables to not instantiate them in the tests
    /*private final FrameworkProperties CONFIGURATION = FrameworkProperties.getInstance();
    protected final String baseURL = CONFIGURATION.getBaseURL();*/

    /**
     * Instantiates WebDriverThreads objects,
     * to isolate each instance of WebDriver during parallel tests running
     */
    @BeforeSuite
    public static void instantiateDriverObject() {
        driverThread = ThreadLocal.withInitial(() -> {
            WebDriverThread webDriverThread = new WebDriverThread();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
        long timeout = 8L;
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @BeforeClass
    protected void setUp() {
        log.info("In TestService BeforeClass");
    }
    public static WebDriver getDriver() {
        log.info("Requesting driver");
        return driverThread.get().getDriver();
    }

    @AfterMethod
    public static void clearCookies() {
        getDriver().manage().deleteAllCookies();
    }


    @AfterSuite
    public static void closeDriverObjects() {
        log.info("Closing threads within webDriverThreadPool");
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
            log.info("Thread closed");
        }
        // needed to avoid memory leaks
        driverThread.remove();
    }
}
