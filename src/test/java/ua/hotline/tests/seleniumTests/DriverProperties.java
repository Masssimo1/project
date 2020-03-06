package ua.hotline.tests.seleniumTests;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
@Slf4j
public class DriverProperties {
    private static final String CONFIG_FILE = "tests.properties";

    public static final String BROWSER = Optional.ofNullable(System.getProperty("browser")).orElse("FIREFOX");

    @Getter
    private static final DriverProperties instance = new DriverProperties();
    private final Properties properties;

    private DriverProperties() {
        properties = new Properties();

        this.setDefaultProperties();

        this.getPropertiesFromConfigFile();

        properties.putAll(System.getProperties());
    }

    /**
     * Gets properties from domain.properties file
     */
    private void getPropertiesFromConfigFile() {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE);

        if (inputStream != null)
            try {
                properties.load(inputStream);
                log.info("Properties from " + CONFIG_FILE + " are obtained");
            } catch (IOException | IllegalArgumentException e) {
                String errorMessage = "Can't get properties from " + CONFIG_FILE;
                log.error(errorMessage, e);
                throw new IllegalStateException(errorMessage, e);
            }
        else {
            log.warn("No " + CONFIG_FILE + " file found! Default properties are used");
        }
    }

    /**
     * Sets default properties to be used in framework
     * (if the .properties file is not accessible
     * or necessary parameters are not passed)
     */
    private void setDefaultProperties() {
        properties.setProperty("test.scheme", "https://");
        properties.setProperty("test.homePageBaseUrl", "hotline.ua");
        properties.setProperty("test.loginPageUrl", "/login");
    }

    /**
     * Getters for properties
     */
    public String getScheme() {
        return properties.getProperty("test.scheme");
    }

    public String getHomePageBaseUrl() {
        return properties.getProperty("test.homePageBaseUrl");
    }

    public String getLoginPageBaseUrl() {
        return properties.getProperty("test.loginPageUrl");
    }
}
