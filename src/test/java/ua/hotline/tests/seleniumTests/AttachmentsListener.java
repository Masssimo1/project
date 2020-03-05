package ua.hotline.tests.seleniumTests;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.UUID;

@Slf4j
public class AttachmentsListener extends TestListenerAdapter {
    /**
     * Listens to tests and takes a web-page screenshot on a test failure
     *
     * @param failedTest - ITestResult failedTest
     */
    @Override
    public void onTestFailure(ITestResult failedTest) {
        String methodName = failedTest.getMethod().getMethodName();

        log.warn("Initiate attachments collecting caused by failed test '{}'", methodName);
        attachScreenshot(methodName);
        attachBrowserLogs(methodName);
        log.warn("Test '{}' FAILED", methodName);
    }

    private void attachBrowserLogs(String methodName) {
        String browserConsoleLogsName = String.format("browser_logs_%s_%s", methodName, UUID.randomUUID().toString());
        Allure.addAttachment(browserConsoleLogsName, getBrowserConsoleLogs());
    }

    @Override
    public void onTestSuccess(ITestResult test) {
        log.info("Test '{}' PASSED", test.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult skippedTest) {
        log.warn("Test '{}' was SKIPPED", skippedTest.getMethod().getMethodName());
    }

    private void attachScreenshot(String methodName) {
        log.warn("Taking screenshot for failed test");
        String screenshotName = String.format("screenshot_%s_%s", methodName, UUID.randomUUID().toString());
        Allure.addAttachment(screenshotName,
                new ByteArrayInputStream(((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES)));
        log.warn("Screenshot was taken for failed test");
    }

    private String getBrowserConsoleLogs() {
        log.warn("Obtaining browser logs");
        LogEntries logEntries = BaseTest.getDriver().manage()
                .logs()
                .get(LogType.BROWSER);

        String parsedLogs = parseBrowserLogs(logEntries);
        log.warn("Browser logs were obtained");

        return parsedLogs;
    }

    private String parseBrowserLogs(LogEntries logEntries) {
        log.warn("Parsing browser logs");
        StringBuilder logs = new StringBuilder();
        for (LogEntry entry : logEntries) {
            logs.append(
                    String.format("[%s] [%s] %s\n",
                            new Date(entry.getTimestamp()).toString(),
                            entry.getLevel(),
                            entry.getMessage())
            );
        }
        log.warn("Browser logs were parsed");

        return logs.toString();
    }
}