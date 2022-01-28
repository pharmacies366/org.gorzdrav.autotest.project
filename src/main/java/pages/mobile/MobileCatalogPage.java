package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MobileCatalogPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileCatalogPage.class);

    //элементы
    private static final String MEDICATIONS_BUTTON_XPATH = "xpath;(//a[contains(.,'Лекарства')])[1]";
    private static final String ALL_MEDICATIONS_BUTTON_XPATH = "xpath;(//a[@href='/category/lekarstva/'])[2]";


    //конструктор
    public MobileCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getMedicationsPageButton() {
        return new PageElementActions(MEDICATIONS_BUTTON_XPATH, driver);
    }

    public PageElementActions getAllMedicationsPageButton() {
        return new PageElementActions(ALL_MEDICATIONS_BUTTON_XPATH, driver);
    }


    //Методы

    @Step("Пользователь нажимает на категорию 'Лекарства")
    public void clickMedicationsButton() {
        getMedicationsPageButton().click();
        logger.info("Пользователь нажимает на категорию 'Лекарства'");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на кнопку 'Лекарства")
    public void allMedicationsPageButton() {
        getAllMedicationsPageButton().click();
        logger.info("Пользователь нажимает на кнопку 'Лекарства'");
        saveAllureScreenshot();
    }
}
