package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MedicationsPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MedicationsPage.class);

    //элементы
    private static final String CHECKBOX_BUY_CHEAPER_XPATH = "xpath;(//span[contains(@class,'b-custom-input')][1])";
    private static final String INDEX_INPUT_PRODUCT_XPATH = "xpath;(//img[@class=' lazyloaded'])";


    //конструктор
    public MedicationsPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getСheckboxBuyCheaper() {
        return new PageElementActions(CHECKBOX_BUY_CHEAPER_XPATH, driver);
    }

    public PageElementActions getIndexProduct() {
        return new PageElementActions(INDEX_INPUT_PRODUCT_XPATH, driver);
    }


    //Методы

    @Step("Пользователь нажимает на чекбокс - 'Купить дешевле''")
    public void clickMedicationsButton() {
        getСheckboxBuyCheaper().click();
        logger.info("Пользователь нажимает на чекбокс - 'Купить дешевле''");
        saveAllureScreenshot();
    }

    @Step("Пользователь выбирает лекарство из списка")
    public void clickSomeProduct() {
        getIndexProduct().click();
        logger.info("Пользователь выбирает лекарство из списка");
        saveAllureScreenshot();
    }
}
