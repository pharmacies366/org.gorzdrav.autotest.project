package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MobileMedicationsPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileMedicationsPage.class);

    //элементы
    private static final String BUY_CHEAPER_BUTTON_XPATH = "xpath;//div[@class='js-facet-name '][contains(.,'Купить дешевле')]";
    private static final String CHECKBOX_BUY_CHEAPER_XPATH = "xpath;(//span[contains(.,'Купить дешевле')])[4]";
    private static final String INDEX_INPUT_PRODUCT_XPATH = "xpath;(//img[@class=' lazyloaded'])";
    private static final String FILTER_BUTTON_XPATH = "xpath;//i[contains(@class,'b-icn--filter')]";


    //конструктор
    public MobileMedicationsPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getIndexProduct() {
        return new PageElementActions(INDEX_INPUT_PRODUCT_XPATH, driver);
    }

    public PageElementActions getFilterButton() {
        return new PageElementActions(FILTER_BUTTON_XPATH, driver);
    }

    public PageElementActions getBuyCheaperButton() {
        return new PageElementActions(BUY_CHEAPER_BUTTON_XPATH, driver);
    }

    public PageElementActions getCheckboxBuyCheaper() {
        return new PageElementActions(CHECKBOX_BUY_CHEAPER_XPATH, driver);
    }


    //Методы

    @Step("Пользователь нажимает на фильтр товаров")
    public void clickFilterButton() {
        getFilterButton().click();
        logger.info("Пользователь нажимает на фильтр товаров");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на категорию и чекбокс - 'Купить дешевле'")
    public void clickBuyCheaperButtons() {
        getBuyCheaperButton().click();
        getCheckboxBuyCheaper().click();
        logger.info("Пользователь нажимает на категорию и чекбокс - 'Купить дешевле'");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на товар из категории дисконтных товаров")
    public void clickDiscontProduct() {
        getIndexProduct().clickIndex(0);
        logger.info("Пользователь нажимает на товар из категории дисконтных товаров");
        saveAllureScreenshot();
    }
}
