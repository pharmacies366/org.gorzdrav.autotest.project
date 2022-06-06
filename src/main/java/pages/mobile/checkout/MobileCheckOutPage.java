package pages.mobile.checkout;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileCheckOutPage extends MainTestBase {


    //элементы
    private static final String CHOOSE_DELIVERY_METHOD_XPATH = "xpath;//div[@data-autotest='checkout_delivery']";
    private static final String BASE_INPUT_DELIVERY_XPATH = "xpath;//input[@id='address%s']";
    private static final String Address = "";
    private static final String Entrance = "-entrance";
    private static final String Level = "-level";
    private static final String Flat = "-flat";
    private static final String BASE_INPUT_CONTACT_DETAILS_XPATH = "xpath;//input[@id='%s']";
    private static final String PhoneNumber = "phone";
    private static final String Fio = "fio";
    private static final String Email = "email";
    private static final String MAKE_ORDER_BUTTON_XPATH = "xpath;//button[contains(@class,'contacts')]";
    private static final String INPUT_PHONE_NUMBER_XPATH = "xpath;//input[@name='phone']";
    private static final String BOOKING_BUTTON_XPATH = "xpath;//input[@value='Забронировать']";
    private static final String SELECT_APTEKA_XPATH = "xpath;//span[contains(.,'Выбрать аптеку')]";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";

    private static final String CHECK_DELIVERY_DETAILS_XPATH = "xpath;//a[contains(.,'Уточнить данные доставки')]";
    private static final String CHANGE_APTEKA_LIST_XPATH = "xpath;//label[@data-autotest='checkout_list']";

    private static final String CHECK_AVAILABILITY_XPATH= "xpath;(//a[@data-autotest='check_availability'])[1]";
    private static final String SELECT_XPATH= "xpath;(//a[@data-autotest='check_availability'])[1]";
    private static final String APTEKA_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String PICKUP_RADIO_BUTTON_XPATH = "xpath;//div[@data-autotest='checkout_pickup']";



    //конструктор
    public MobileCheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getChooseDeliveryMethod() {
        return new PageElementActions(CHOOSE_DELIVERY_METHOD_XPATH, driver);
    }

    public PageElementActions getBaseInputContactDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getMakeOrderButton() {
        return new PageElementActions(MAKE_ORDER_BUTTON_XPATH, driver);
    }

    public PageElementActions getInputPhoneNumber() {
        return new PageElementActions(INPUT_PHONE_NUMBER_XPATH, driver);
    }

    public PageElementActions getBookingButton() {
        return new PageElementActions(BOOKING_BUTTON_XPATH, driver);
    }

    public PageElementActions getBaseInputDelivery(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getSelectApteka() {
        return new PageElementActions(SELECT_APTEKA_XPATH, driver);
    }

    public PageElementActions getPharmacyAddressInput() {
        return new PageElementActions(PHARMACY_ADDRESS_INPUT_XPATH, driver);
    }
  public PageElementActions checkDeliveryDetails() {
        return new PageElementActions(CHECK_DELIVERY_DETAILS_XPATH, driver);
    }

    public PageElementActions getChangeAptekaList() {
        return new PageElementActions(CHANGE_APTEKA_LIST_XPATH, driver);
    }

    public PageElementActions getSelect() {
        return new PageElementActions(SELECT_XPATH, driver);
    }

    public PageElementActions getAvailability() {
        return new PageElementActions(CHECK_AVAILABILITY_XPATH, driver);
    }

    public PageElementActions getAptekaMap() {
        return new PageElementActions(APTEKA_MAP_XPATH, driver);
    }

    public PageElementActions getPickupRadioButton() {
        return new PageElementActions(PICKUP_RADIO_BUTTON_XPATH, driver);
    }



    //Методы

    @Step("Пользователь заполняет контактные данные")
    public void contactDetails(String fio, String phoneNumber, String email) {
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Fio)).sendKeys(fio);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, PhoneNumber)).sendKeys(phoneNumber);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Email)).sendKeys(email);
        logger.info("Пользователь заполнил контактные данные");
    }

    @Step("Заполнение данных адреса доставки")
    public void addressDelivery(String address, String entrance, String level, String flat) {
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Address)).sendKeys(address);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Entrance)).sendKeys(entrance);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Level)).sendKeys(level);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Flat)).sendKeys(flat);
        logger.info("Пользователь заполнил адрес доставки");
    }

    @Step("Пользователь нажимает на кнопку 'Сделать заказ'")
    public void clickMakeOrder(){
        getMakeOrderButton().clickJs();
        logger.info("Пользователь нажимает на кнопку 'Сделать заказ'");
    }

    @Step("Пользователь вводит номер телефона при покупке в 1-клик")
    public void setInputOneClickPhoneNumber(String number) {
        getInputPhoneNumber().sendKeys(number);
        logger.info("Пользователь вводит номер телефона при покупке в 1-клик");
    }

    @Step("Пользователь нажимает на кнопку 'Забронировать'")
    public void clickBookingButton(){
        getBookingButton().click();
        logger.info("Пользователь нажимает на кнопку 'Забронировать'");
    }

    @Step("Пользователь нажимает кнопку 'Выбрать Аптеку'")
    public void clickSelectApteka() {
        choosePickupMethod();
        logger.info("Пользователь нажимает кнопку 'Выбрать Аптеку'");
    }

    @Step("Проверка выбранного способа получения 'Самовывоз'")
    public void choosePickupMethod() {
        if (!getSelectApteka().isElementVisible()) {
            getPickupRadioButton().click();
        }
        getSelectApteka().click();
        logger.info("Проверка выбранного способа получения 'Самовывоз'");
    }

    @Step("Пользователь выбирает способ получения - Доставка")
    public void clickDeliveryMethod() {
        chooseDeliveryMethod();
    }

    @Step("Проверка выбранного способа получения 'Доставка'")
    public void chooseDeliveryMethod() {
        if (getSelectApteka().isElementVisible()) {
            getChooseDeliveryMethod().click();
        }
        else {
            getChooseDeliveryMethod().click();
        }
        logger.info("Проверка выбранного способа получения 'Доставка'");
    }

    @Step("Пользователь вводит адрес - {addres}")
    public void setInputSearchAddres(String addres) {
        getPharmacyAddressInput().sendKeysAndEnter(addres);
        logger.info("Пользователь вводит адрес");
    }
    @Step("Пользователь нажимает - Уточнить данные доставки")
    public void clickCheckDeliveryDetails() {
        checkDeliveryDetails().click();
        logger.info("Пользователь нажимает - Уточнить данные доставки");
    }

    @Step("Пользователь нажимает на список доступных Аптек")
    public void clickChangeAptekaList() {
        getChangeAptekaList().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
    }

    @Step("Пользователь нажимает на кнопку узнать о наличаи и выбрать первую аптеку из списка")
    public void clickSelect(){
        getAvailability().click();
        getSelect().clickJs();
        logger.info("Пользователь нажимает на кнопку узнать о наличаи и выбрать первую аптеку из списка");
    }

    @Step("Пользователь проверяет отображении карты на странице")
    public void checkVisibilityMap() {
        getAptekaMap().elementIsVisibility();
        logger.info("Пользователь проверяет отображении карты на странице");
    }



}