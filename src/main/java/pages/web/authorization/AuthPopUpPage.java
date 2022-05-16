package pages.web.authorization;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class AuthPopUpPage extends MainTestBase {

    //элементы
    private static final String _PHONE_NUMBER_INPUT_XPATH = "xpath;//input[@id='login-phone']";
    private static final String GO_PASSWORD_INPUT_XPATH = "xpath;//a[@class='b-link--auth js-auth-ext__button']";
    private static final String _PASSWORD_INPUT_XPATH = "xpath;//input[@id='login-pass']";
    private static final String _CHANGE_TO_EMAIL_XPATH = "xpath;//a[contains(.,'E-mail')]";
    private static final String _AUTH_EMAIL_XPATH = "xpath;//input[@id='login-email']";
    private static final String _LOGIN_BUTTON_XPATH = "xpath;//button[contains(.,'Войти')]";
    private static final String _PASSWORD_INPUT_ID = "id;login-pass";
    private static final String GO_TO_PASSWORD_XPATH = "xpath;//a[@class='b-link--auth js-auth-ext__button']";
    private static final String _CHANGE_TO_CARD_NUMBER_XPATH = "xpath;//a[contains(.,'Номер карты')]";
    private static final String _AUTH_CARD_NUMBER_ID = "id;login-cardNumber";


    //конструктор
    public AuthPopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getPhoneNumberInput() {
        return new PageElementActions(_PHONE_NUMBER_INPUT_XPATH, driver);
    }

    public PageElementActions getLoginButton() {
        return new PageElementActions(_LOGIN_BUTTON_XPATH, driver);
    }

    public PageElementActions getGoPassword() {
        return new PageElementActions(GO_PASSWORD_INPUT_XPATH, driver);
    }

    public PageElementActions getPassword() {
        return new PageElementActions(_PASSWORD_INPUT_XPATH, driver);
    }

    public PageElementActions getChanchToEmail() {
        return new PageElementActions(_CHANGE_TO_EMAIL_XPATH, driver);
    }

    public PageElementActions getInputEmail() {
        return new PageElementActions(_AUTH_EMAIL_XPATH, driver);
    }

    public PageElementActions getGoToPassword() {
        return new PageElementActions(GO_TO_PASSWORD_XPATH, driver);
    }

    public PageElementActions getPasswordInput() {
        return new PageElementActions(_PASSWORD_INPUT_ID, driver);
    }

    public PageElementActions getChanchToCardNumber() {
        return new PageElementActions(_CHANGE_TO_CARD_NUMBER_XPATH, driver);
    }

    public PageElementActions getAuthCardNumber() {
        return new PageElementActions(_AUTH_CARD_NUMBER_ID, driver);
    }


    //Методы

    @Step("Пользователь переключается на вход по Email")
    public void setChangeToEmail() {
        getChanchToEmail().click();
    }

    @Step("Пользователь переключается на вход по номеру бонусной карты")
    public void setChangeToCardNumber() {
        getChanchToCardNumber().click();
        logger.info("Пользователь переключается на вход по номеру бонусной карты");
    }

    @Step("Пользователь вводит номер телефона и пароль")
    public void setPhoneNumber(String phoneNumber, String password) {
        getPhoneNumberInput().sendKeys(phoneNumber);
        getGoToPassword().click();
        getPasswordInput().sendKeys(password);
        logger.info("Пользователь вводит номер телефона и пароль");
    }

    @Step("Пользователь вводит номер телефона и пароль")
    public void setPhoneAndPassword(String phone, String password) {
        getPhoneNumberInput().sendKeys(phone);
        getGoPassword().click();
        getPassword().sendKeys(password);
    }

    @Step("Пользователь вводит номер бонусной карты и пароль")
    public void setCardNumberAndPassword(String cardNumber, String password) {
        getAuthCardNumber().sendKeys(cardNumber);
        getPasswordInput().sendKeys(password);
        logger.info("Пользователь вводит номер бонусной карты и пароль");
    }

    @Step("Пользователь вводит Email и пароль")
    public void setEmailAndPassword(String email, String password) {
        getInputEmail().sendKeys(email);
        getPassword().sendKeys(password);
    }

    @Step("клик на кнопку \"войти\"")
    public void clickToLoginButton() {
        getLoginButton().click();
    }

    @Step("Пользователь вводит номер телефона, пароль и нажимает войти")
    public void authorizeWithPhoneAndPassword(String phone, String password) {
        getPhoneNumberInput().clean();
        getPhoneNumberInput().sendKeys(phone);
        getGoPassword().click();
        getPassword().clean();
        getPassword().sendKeys(password);
        clickToLoginButton();
        pageActions.staticWait(500);
    }


}
