package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class MobileProductCardPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileProductCardPage.class);

    //элементы
    private static final String DISCOUNT_PRICE_BUTTON_XPATH = "xpath;(//div[@class='c-product-discount__text'])";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String PRICE_VALUE_XPATH = "xpath;//span[@class='js-price-value']";
    private static final String ONE_CKICK_CSS = "css;.js-order-quick-navigate";
    private static final String LUPA_BUTTON_CARD_XPATH = "xpath;//*[@class='b-search js-store-finder-search__form']//*[contains(@class, 'b-search__buttons')]";
    private static final String ONE_CKICK_APTEKA_BUTTONS_XPATH = "xpath;(//button[contains(.,'Купить в 1 клик')])";
    private static final String CHANGE_APTEKA_LIST_CSS = "css;.js-storefinder-recommend";
    private static final String PRICE_LABLE_CSS = "css;.js-price-value";
    private static final String ADD_TO_CARD_BUTTON_XPATH = "xpath;//button[@data-gtm-source='details']";
    private static final String APTEKA_LIST_BUTTON_XPATH = "xpath;//span[contains(.,'Списком')]";
    private static final String APTEKA_MAP_XPATH = "xpath;//*[@id='store-finder-map']";


    //конструктор
    public MobileProductCardPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getOneClick() {
        return new PageElementActions(ONE_CKICK_CSS, driver);
    }

    public PageElementActions getLupaButtonCard() {
        return new PageElementActions(LUPA_BUTTON_CARD_XPATH, driver);
    }

    public PageElementActions getOneClickAptekaButtons() {
        return new PageElementActions(ONE_CKICK_APTEKA_BUTTONS_XPATH, driver);
    }

    public PageElementActions getChangeAptekaList() {
        return new PageElementActions(CHANGE_APTEKA_LIST_CSS, driver);
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

    //Методы

    @Step("Пользователь нажимает на кнопку 'в корзину'")
    public void clickToCartButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'в корзину'");
        saveAllureScreenshot();
    }

    @Step("Запоминаем цену товара")
    public int getProductPrice() {
        int price = getPriceValue().formatElementToValue();
        logger.info("Запоминаем цену товара");
        return price;
    }

    @Step("Пользователь выбирает дисконтный товар")
    public void selectDiscountProduct() {
        getDiscountPriceButton().clickIndex(3);
        logger.info("Пользователь выбирает дисконтный товар");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на кнопку 'Купить в 1 клик'")
    public void buyOneClick() {
        getOneClick().click();
        logger.info("Пользователь нажимает на кнопку 'Купить в 1 клик'");
        saveAllureScreenshot();
    }

    @Step("Пользователь проверяет отображении карты на странице")
    public void checkVisibilityMap() {
        getAptekaMap().elementIsVisibility();
        logger.info("Пользователь проверяет отображении карты на странице");
        saveAllureScreenshot();
    }

    @Step("Пользователь вводит адрес - {addres}")
    public void setInputSearchAddres(String addres) {
        getPharmacyAddressInput().sendKeys(addres);
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает значек 'лупы' и выполняет поиск")
    public void clickLupaButton() {
        getLupaButtonCard().click();
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на список доступных Аптек")
    public void clickAptekaList() {
        getAptekaListButton().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на выбранной аптеке 'Купить в 1 клик'")
    public void oneClickAptekaButtons() {
        getOneClickAptekaButtons().clickIndex(0);
        logger.info("Пользователь нажимает на выбранной аптеке 'Купить в 1 клик'");
        saveAllureScreenshot();
    }

}
