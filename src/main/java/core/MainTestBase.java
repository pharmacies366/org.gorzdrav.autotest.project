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


    @Step("Пользователь переходит в карточку товара")
    protected void openUrl(String url) {
        driver.get(url);
    }

    @BeforeMethod(alwaysRun = true)
    @Step("Открывается Главная страница сайта")
    public void beforeClass_StartBrowser(ITestResult result) {
        driverFactory = new WebDriverFactory();
        starting(result);
        driver = driverFactory.getDriver();
        pageActions = new PageActions(driver);
        driver.get(propertiesManager.getProperty("baseurl"));
        logger.info("Открывается главная страница сайта Горздрав");
    }

    @AfterMethod(alwaysRun = true)
    public void afterAllTest(ITestResult result) {
        if (result.getStatus() != ITestResult.SUCCESS) {
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            logger.info("Снят скриншот последнего шага в упавшем тесте");
        }
        driver.quit();
        logger.info("Браузер закрылся");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    private void starting(ITestResult result) {
        nameOfPackage = result.getMethod().getRealClass().getName();
        //`  nameOfClass = testInfo.getTestClass().get().getName();
        logger.info("Тест старт " + result.getName());
    }
}