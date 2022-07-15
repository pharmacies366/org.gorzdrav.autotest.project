package templateTestng.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import templateTestng.actions.PageActions;
import templateTestng.driver.DriverManager;
import templateTestng.driver.TargetFactory;
import templateTestng.utils.PropertiesManager;

public class MainTestBase {
    protected Logger logger = LogManager.getLogger(MainTestBase.class);
    protected PropertiesManager propertiesManager = new PropertiesManager();

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        //DriverManager.getDriver().get(configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
