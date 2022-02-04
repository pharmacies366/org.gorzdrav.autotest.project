package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static core.MainTestBase.nameOfPackage;


public class WebDriverFactory {
    private Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private RemoteWebDriver driver;

    @Step("Получение типа драйвера")
    public WebDriver getDriver() {
        DriverType driverType = DriverType.valueOf(System.getProperty("driver").toUpperCase());
            switch (driverType) {
                case LOCAL:
                    if (nameOfPackage.contains("mobile")) {
                        driver = setupMobileDriver();
                    }
                    else {
                        setupLocalDriver();
                    }
                    break;
                case REMOTE:
                    if (nameOfPackage.contains("mobile")) {
                        driver = setupRemoteMobileDriver();
                    }
                    else {
                        setupRemoteDriver();
                    }
                    break;
            }
        return driver;
    }

    @Step("Настройка удаленного драйвера")
    private void setupRemoteDriver() {
        logger.info("setup remote driver");
        String driverURL = System.getProperty("driverurl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("91.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        try {
            driver = new RemoteWebDriver(
                    URI.create(driverURL).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        configureDriver();
        logger.info("ЗАПУЩЕН УДАЛЕННЫЙ ДРАЙВЕР");
    }

    @Step("Настройка локального драйвера")
    public void setupLocalDriver() {
        logger.info("setup local web driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        configureDriver();
        logger.info("ЗАПУЩЕН ЛОКАЛЬНЫЙ ДРАЙВЕР");
    }


    @Step("Конфигурация драйвера")
    private void configureDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Step("Настройка удаленного мобильного драйвера")
    private RemoteWebDriver setupRemoteMobileDriver() {
        logger.info("setup remote mobile driver");

        String driverURL = System.getProperty("driverurl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("91.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);

        try {
            driver = new RemoteWebDriver(
                    URI.create(driverURL).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        configureDriver();
        logger.info("ЗАПУЩЕН УДАЛЕННЫЙ ДРАЙВЕР");

        return driver;
    }


    @Step("Запуск локального мобильного драйвера")
    public RemoteWebDriver setupMobileDriver() {

        WebDriverManager.chromedriver().setup();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

}
