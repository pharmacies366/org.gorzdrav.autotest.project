package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends MainTestBase {

    //элементы
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String BASE_INPUT_DELIVERY_XPATH = "xpath;//input[@id='address%s']";
    private static final String Address = "";
    private static final String Entrance = "-entrance";
    private static final String Level = "-level";
    private static final String Flat = "-flat";
    private static final String BASE_INPUT_CONTACT_DETAILS_XPATH = "xpath;//input[@id='%s']";
    private static final String PhoneNumber = "phone";
    private static final String Fio = "fio";
    private static final String Email = "email";
    private static final String INPUT_PHONE_NUMBER_XPATH = "xpath;//input[@name='phone']";
    private static final String CHOOSE_DELIVERY_METHOD_CSS = "css;.js-checkout--mixed__shipment-delivery";
    private static final String FINAL_BUY_BUTTON_XPATH = "xpath;//button[contains(.,'Оформить заказ')]";
    private static final String CHANGE_APTEKA_LIST_XPATH = "xpath;//span[contains(@class, 'p-checkout--mixed__control-labelText ')]";
    private static final String MAKE_ORDER_BUTTON_CSS = "css;.js-checkout--mixed__contacts";
    private static final String BOOKING_BUTTON_XPATH = "xpath;//input[@value='Забронировать']";
    private static final String CHECKOUT_BUTTON_XPATH = "xpath;//button[contains(.,'Оформить заказ')]";
    private static final String AVAILABILITY_XPATH = "xpath;(//a[@class='b-btn b-btn--outline js-store-choose'])[1]";
    private static final String CHOOSE_THIS_PHARMACY_XPATH = "xpath;(//a[@class='b-btn b-btn--outline js-store-choose'])[1]";
    private static final String APTEKA_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String PICKUP_BUTTON_XPATH = "xpath;(//div[contains(@class,'content')])[2]";

    //конструктор
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getChooseDeliveryMethod() {
        return new PageElementActions(CHOOSE_DELIVERY_METHOD_CSS, driver);
    }

    public PageElementActions getBaseInputDelivery(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputContactDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getPharmacyAddressInput() {
        return new PageElementActions(PHARMACY_ADDRESS_INPUT_XPATH, driver);
    }

    public PageElementActions getInputPhoneNumber() {
        return new PageElementActions(INPUT_PHONE_NUMBER_XPATH, driver);
    }

    public PageElementActions getFinalBuyButton() {
        return new PageElementActions(FINAL_BUY_BUTTON_XPATH, driver);
    }

    public PageElementActions getChangeAptekaList() {
        return new PageElementActions(CHANGE_APTEKA_LIST_XPATH, driver);
    }

    public PageElementActions getMakeOrderButton() {
        return new PageElementActions(MAKE_ORDER_BUTTON_CSS, driver);
    }

    public PageElementActions getBookingButton() {
        return new PageElementActions(BOOKING_BUTTON_XPATH, driver);
    }

    public PageElementActions getCheckoutButton() {
        return new PageElementActions(CHECKOUT_BUTTON_XPATH, driver);
    }

    public PageElementActions getAvailability() {
        return new PageElementActions(AVAILABILITY_XPATH, driver);
    }


    public PageElementActions getChooseThisPharmacy() {
        return new PageElementActions(CHOOSE_THIS_PHARMACY_XPATH, driver);
    }

    public PageElementActions getAptekaMap() {
        return new PageElementActions(APTEKA_MAP_XPATH, driver);
    }

    public PageElementActions getPickUpButton() {
        return new PageElementActions(PICKUP_BUTTON_XPATH, driver);
    }


    //Методы
    @Step("Заполнение данных адреса доставки")
    public void addressDelivery(String address, String entrance, String level, String flat) {
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Address)).sendKeys(address);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Entrance)).sendKeys(entrance);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Level)).sendKeys(level);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Flat)).sendKeys(flat);
    }

    @Step("Пользователь выбирает способ доставки 'Самовывоз'")
    public void clickPickUpButton() {
        getPickUpButton().click();
        logger.info("Пользователь выбирает способ доставки 'Самовывоз'");
    }

    @Step("Заполнение данных адреса самовывоза")
    public void sendAddressPickUp(String address) {
        getPharmacyAddressInput().sendKeysAndEnter(address);
    }

    @Step("Пользователь заполняет контактные данные")
    public void contactDetails(String email, String phoneNumber, String fio) {
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Email)).sendKeys(email);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, PhoneNumber)).sendKeys(phoneNumber);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Fio)).sendKeys(fio);
        logger.info("Пользователь заполнил контактные данные");
    }

    @Step("Пользователь выбирает способ получения - Доставка")
    public void clickDeliveryMethod() {
        getChooseDeliveryMethod().click();
    }

    @Step("Пользователь нажимает на кнопку купить")
    public void clickToFinalButton() {
        getFinalBuyButton().click();
        logger.info("ПОЛЬЗОВАТЕЛЬ ПЕРЕШЕЛ НА СТРАНИЦУ СБЕРА");
    }

    @Step("Пользователь вводит номер телефона при покупке в 1-клик")
    public void setInputOneClickPhoneNumber(String number) {
        getInputPhoneNumber().sendKeys(number);
        logger.info("Пользователь вводит номер телефона при покупке в 1-клик");
    }

    @Step("Пользователь нажимает на кнопку 'Забронировать'")
    public void clickBookingButton() {
        getBookingButton().click();
        logger.info("Пользователь нажимает на кнопку 'Забронировать'");
    }

    @Step("Пользователь нажимает на кнопку 'Сделать заказ'")
    public void clickMakeOrder() {
        getMakeOrderButton().click();
        logger.info("Пользователь нажимает на кнопку 'Сделать заказ'");
    }

    @Step("Пользователь нажимает на кнопки 'Узнать о наличии' и 'Выбрать эту аптеку'")
    public void getAvailabilityAndChooseThisPharmacy() {
        getAvailability().click();
        getChooseThisPharmacy().click();
        logger.info("Пользователь нажимает на кнопки 'Узнать о наличии' и 'Выбрать эту аптеку'");
    }

    @Step("Пользователь нажимает на кнопку 'Оформить заказ'")
    public void clickCheckout() {
        getCheckoutButton().click();
        logger.info("Пользователь нажимает на кнопку 'Оформить заказ'");
    }

    @Step("Пользователь нажимает на список доступных Аптек")
    public void clickChangeAptekaList() {
        getChangeAptekaList().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
    }

    @Step("Пользователь проверяет отображении карты на странице")
    public void checkVisibilityMap() {
        getAptekaMap().elementIsVisibility();
        logger.info("Пользователь проверяет отображении карты на странице");
    }

}
