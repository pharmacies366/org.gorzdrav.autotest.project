package core;

import actions.PageActions;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesManager;
import utils.WebDriverFactory;


public class MainTestBase {

    public WebDriver driver;
    protected PropertiesManager propertiesManager = new PropertiesManager();
    protected PageActions pageActions;
    private WebDriverFactory driverFactory;

    public static String nameOfPackage;
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
        try {
            driver.get(propertiesManager.getProperty("baseurl"));
            pageActions.waitPageLoad();
        } catch (org.openqa.selenium.TimeoutException ex) {
            driver.navigate().refresh();
            pageActions.waitPageLoad();
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Step("Открывается Главная страница сайта")
    public void beforeClass_StartBrowser(ITestResult result) {
        driverFactory = new WebDriverFactory();
        starting(result);
        driver = driverFactory.getDriver();
        pageActions = new PageActions(driver);
        openStartPage();
        logger.info("Открывается главная страница сайта Горздрав");
    }

/*    @AfterMethod(alwaysRun = true)
    public void afterAllTest(ITestResult result) {
        if (result.getStatus() != ITestResult.SUCCESS) {
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            logger.info("Снят скриншот последнего шага в упавшем тесте");
        }
        driver.close();
        driver.quit();
        logger.info("Браузер закрылся");
    } */

    @AfterMethod(alwaysRun = true)
    public void afterAllTest(ITestResult result) throws Exception {
        if (result.getStatus() != ITestResult.SUCCESS) {
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            logger.info("Снят скриншот последнего шага в упавшем тесте");
        }
            if (driver != null) {
                driver.quit();
                logger.info("Браузер закрылся");
            }
        }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    private void starting(ITestResult result) {
        nameOfPackage = result.getMethod().getRealClass().getName();
        logger.info("Тест старт " + result.getMethod().getMethodName());
    }
}