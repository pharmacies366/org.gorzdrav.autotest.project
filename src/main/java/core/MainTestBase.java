package core;

import actions.PageActions;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.PropertiesManager;
import utils.WebDriverFactory;

public class MainTestBase {

    protected WebDriver driver;
    protected PropertiesManager propertiesManager = new PropertiesManager();
    protected PageActions pageActions;
    public static String nameOfPackage;
    public static String nameOfClass;
    protected Logger logger = LogManager.getLogger(MainTestBase.class);


    @Step("Пользователь открывает страницу по URL")
    protected void openUrl(String url) {
        try {
            driver.get(url);
        } catch (org.openqa.selenium.TimeoutException ex) {
            driver.navigate().refresh();
        }
    }

    private void openStartPage() {
        driver.get(propertiesManager.getProperty("baseurl"));
    }

    @BeforeEach
    @Step("Открывается Главная страница сайта")
    public void beforeClass_StartBrowser(TestInfo testInfo) {
        WebDriverFactory driverFactory = new WebDriverFactory();
        starting(testInfo);
        driver = driverFactory.getDriver();
        pageActions = new PageActions(driver);
        openStartPage();
        logger.info("Открывается главная страница сайта Горздрав");
    }

    @AfterEach
    public void finish() {
        saveAllureScreenshot();
        driver.close();
        driver.quit();
    }


    private void starting(TestInfo testInfo) {
        nameOfPackage = testInfo.getTestClass().get().getPackage().getName();
        //`  nameOfClass = testInfo.getTestClass().get().getName();
        logger.info("Тест старт " + testInfo.getDisplayName());
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Прикрепить строку к отчету
     *
     * @param string - Входящая строка
     * @return - строка к отчету
     */
    @Attachment(value = "строка")
    public String returnString(String string) {
        return string;
    }

    @Attachment(value = "Result")
    public String returnAttachment() {
        return "Все хорошо";
    }
}
