package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class OspPage extends MainTestBase {


    //элементы
    private static final String PRODUCT_NAME_XPATH = "xpath;//*[@href=\"/catalog/nurofen\"]";
    private static final String BUY_BUTTON_XPATH = "xpath;(//button[@type='submit'])[3]";

    //конструктор
    public OspPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getProductName() {
        return new PageElementActions(PRODUCT_NAME_XPATH, driver);
    }

    public PageElementActions getBuyButton() {
        return new PageElementActions(BUY_BUTTON_XPATH, driver);
    }

    //Методы

    @Step("Пользователь нажимает на товар 'Нурофен'")
    public void clickProductName() {
        getProductName().click();
        logger.info("Пользователь нажимает на товар 'Нурофен'");
    }

    @Step("Пользователь нажимает на кнопку 'купить'")
    public void clickBuyButton() {
        getBuyButton().click();
        logger.info("Пользователь нажимает на кнопку 'купить'");
    }
}