package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileCartPage extends MainTestBase {

    //элементы
    private static final String TOTAL_PRICE_CSS = "css;.c-cart-summary__total span b";
    private static final String CARD_BUTTON_CSS = "css;.c-mini-cart__icon";
    private static final String BUY_BUTTON_XPATH = "xpath;//button[contains(@class, \"js-add-to-cart\")]";
    private static final String MAKE_ORDER_XPATH = "xpath;//a[@href='/cart/checkout']";
    private static final String PRODUCT_CARD_XPATH = "xpath;//div[contains(@class,'c-prod-item__title')]";
    private static final String CARD_COUNT_CSS = "css;.js-mini-cart-count";
    private static final String CLEAR_ALL_FROM_CARD_XPATH = "xpath;//a[@class='js-cart-clear b-item--clean']";
    private static final String CONFIRM_CLEAN_ALL_XPATH = "xpath;//input[@class='js-cart-clear-yes b-btn i-float-l']";
    private static final String PICKUP_BUTTON_XPATH = "xpath;(//div[contains(@class,'content')])[2]";

    //конструктор
    public MobileCartPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getTotalPrice() {
        return new PageElementActions(TOTAL_PRICE_CSS, driver);
    }

    public PageElementActions getBuyButton() {
        return new PageElementActions(BUY_BUTTON_XPATH, driver);
    }

    public PageElementActions getMakeOrder() {
        return new PageElementActions(MAKE_ORDER_XPATH, driver);
    }

    public PageElementActions getProductCard() {
        return new PageElementActions(PRODUCT_CARD_XPATH, driver);
    }

    public PageElementActions getCartCount() {
        return new PageElementActions(CARD_COUNT_CSS, driver);
    }

    public PageElementActions getClearAllFromCart() {
        return new PageElementActions(CLEAR_ALL_FROM_CARD_XPATH, driver);
    }

    public PageElementActions getConfirmCleanAll() {
        return new PageElementActions(CONFIRM_CLEAN_ALL_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_CSS, driver);
    }

    public PageElementActions getPickUpButton() {
        return new PageElementActions(PICKUP_BUTTON_XPATH, driver);
    }


    //Методы
    @Step("Проверка состояния корзины: Если корзина не пустая, удаляем все содержимое")
    public void checkCartQuantity() {
        String stringCartQuantity = getCartCount().getText();
        int quantity = Integer.parseInt(stringCartQuantity);
        if (quantity != 0) {
            logger.info("В КОРЗИНЕ ЕСТЬ ТОВАРЫ");
            driver.get(propertiesManager.getProperty("baseurl") + "/cart");
            getClearAllFromCart().click();
            getConfirmCleanAll().click();
            logger.info("ТОВАРЫ В КОРЗИНЕ УДАЛЕНЫ");
        }
    }

    @Step("Сохранение итоговой суммы в корзине")
    public int getPriceTotal() {
        int price = getTotalPrice().formatElementToValue();
        logger.info("Запоминаем цену товара");
        return price;
    }

    @Step("Пользователь нажимает на кнопку 'купить'")
    public void clickBuyButton() {
        getBuyButton().click();
        logger.info("Пользователь нажимает на кнопку 'купить'");
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().click();
        logger.info("Пользователь нажимает на иконку корзины");
    }

    @Step("Пользователь нажимае на кнопку 'Оформить заказ'")
    public void clickToMakeOrder() {
        getMakeOrder().click();
        logger.info("Пользователь нажимае на кнопку 'Оформить заказ'");
    }

    @Step("Пользователь нажимает на товар")
    public void clickProductCard() {
        getProductCard().click();
        logger.info("Пользователь нажимает на товар");
    }

    @Step("Пользователь выбирает способ доставки 'Самовывоз'")
    public void clickPickUpButton() {
        getPickUpButton().click();
        logger.info("Пользователь выбирает способ доставки 'Самовывоз'");
    }

}
