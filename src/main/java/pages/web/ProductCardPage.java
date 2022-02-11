package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ProductCardPage extends MainTestBase {


    //элементы
    private static final String DISCOUNT_PRICE_BUTTON_XPATH = "xpath;(//div[@class='c-product-discount__text'])";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String PRICE_VALUE_XPATH = "xpath;//span[@class='js-price-value']";
    private static final String ONE_CKICK_CSS = "css;.js-order-quick-navigate";
    private static final String ONE_CKICK_APTEKA_BUTTONS_XPATH = "xpath;(//button[contains(.,'Купить в 1 клик')])";
    private static final String CHANGE_APTEKA_LIST_XPATH = "xpath;//span[contains(@class, 'p-checkout--mixed__control-labelText ')]";
    private static final String APTEKA_LIST_BUTTON_XPATH = "xpath;//a[contains(.,'Списком')]";
    private static final String PRICE_LABLE_CSS = "css;.js-price-value";
    private static final String ADD_TO_CARD_BUTTON_XPATH = "xpath;//button[@data-gtm-source='details']";
    private static final String APTEKA_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String EMPTY_PLACE_XPATH = "xpath;//main[contains(@data-currency-iso-code,'RUB')]";
    private static final String SCALE_DOWN_BUTTON_XPATH = "xpath;//div[@id='zoom-out']";


    //конструктор
    public ProductCardPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getOneClick() {
        return new PageElementActions(ONE_CKICK_CSS, driver);
    }

    public PageElementActions getOneClickAptekaButtons() {
        return new PageElementActions(ONE_CKICK_APTEKA_BUTTONS_XPATH, driver);
    }

    public PageElementActions getChangeAptekaList() {
        return new PageElementActions(CHANGE_APTEKA_LIST_XPATH, driver);
    }

    public PageElementActions getDiscountPriceButton() {
        return new PageElementActions(DISCOUNT_PRICE_BUTTON_XPATH, driver);
    }

    public PageElementActions getPriceLable() {
        return new PageElementActions(PRICE_LABLE_CSS, driver);
    }

    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getAptekaListButton() {
        return new PageElementActions(APTEKA_LIST_BUTTON_XPATH, driver);
    }

    public PageElementActions getAptekaMap() {
        return new PageElementActions(APTEKA_MAP_XPATH, driver);
    }

    public PageElementActions getPharmacyAddressInput() {
        return new PageElementActions(PHARMACY_ADDRESS_INPUT_XPATH, driver);
    }

    public PageElementActions getPriceValue() {
        return new PageElementActions(PRICE_VALUE_XPATH, driver);
    }

    public PageElementActions getEmptyPlace() {
        return new PageElementActions(EMPTY_PLACE_XPATH, driver);
    }

    public PageElementActions getScaleDownButton() {
        return new PageElementActions(SCALE_DOWN_BUTTON_XPATH, driver);
    }


    //Методы

    @Step("Пользователь нажимает на кнопку 'в корзину'")
    public void clickToCartButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'в корзину'");
    }

    @Step("Пользователь вводит адрес - {addres}")
    public void setInputSearchAddres(String addres) {
        getPharmacyAddressInput().sendKeysAndEnter(addres);
    }

    @Step("Пользователь нажимает на кнопку 'Купить в 1 клик'")
    public void buyOneClick() {
        getOneClick().click();
        logger.info("Пользователь нажимает на кнопку 'Купить в 1 клик'");
    }

    @Step("Пользователь нажимает на список доступных Аптек")
    public void clickChangeAptekaList() {
        getChangeAptekaList().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
    }

    @Step("Пользователь нажимает на список доступных Аптек")
    public void clickAptekaList() {
        getAptekaListButton().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
    }

    @Step("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки")
    public void clickBuyOneClick() {
        getOneClickAptekaButtons().clickIndex(0);
        logger.info("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки");
    }

    @Step("Пользователь проверяет отображении карты на странице")
    public void checkVisibilityMap() {
        getAptekaMap().elementIsVisibility();
        logger.info("Пользователь проверяет отображении карты на странице");
    }

    @Step("Запоминаем цену товара")
    public int getProductPrice() {
        int price = getPriceLable().formatElementToValue();
        logger.info("Запоминаем цену товара");
        return price;
    }

    @Step("Пользователь уменьшает маштаб карты в 2 раза")
    public void scaleDownMap() {
        getScaleDownButton().doubleClick();
        logger.info("Пользователь уменьшает маштаб карты в 2 раза");
    }

}
