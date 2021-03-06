package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class AuthPopUpPage extends MainTestBase {

    //элементы
    private static final String _PHONE_NUMBER_INPUT_ID = "id;login-phone";
    private static final String _LOGIN_BUTTON_XPATH = "xpath;//button[contains(.,'Войти')]";
    private static final String _CHANGE_TO_CARD_NUMBER_XPATH = "xpath;//a[contains(.,'Номер карты')]";
    private static final String _AUTH_CARD_NUMBER_ID = "id;login-cardNumber";
    private static final String _CHANGE_TO_EMAIL_XPATH = "xpath;//a[contains(.,'E-mail')]";
    private static final String _AUTH_EMAIL_XPATH = "xpath;//input[@id='login-email']";
    private static final String _PASSWORD_INPUT_ID = "id;login-pass";
    private static final String GO_TO_PASSWORD = "xpath;//a[@class='b-link--auth js-auth-ext__button']";


    //конструктор
    public AuthPopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getPhoneNumberInput() {
        return new PageElementActions(_PHONE_NUMBER_INPUT_ID, driver);
    }

    public PageElementActions getPasswordInput() {
        return new PageElementActions(_PASSWORD_INPUT_ID, driver);
    }

    public PageElementActions getLoginButoon() {
        return new PageElementActions(_LOGIN_BUTTON_XPATH, driver);
    }

    public PageElementActions getChanchToCardNumber() {
        return new PageElementActions(_CHANGE_TO_CARD_NUMBER_XPATH, driver);
    }

    public PageElementActions getAuthCardNumber() {
        return new PageElementActions(_AUTH_CARD_NUMBER_ID, driver);
    }

    public PageElementActions getChangeToEmail() {
        return new PageElementActions(_CHANGE_TO_EMAIL_XPATH, driver);
    }

    public PageElementActions getInputEmail() {
        return new PageElementActions(_AUTH_EMAIL_XPATH, driver);
    }

    public PageElementActions getGoToPassword() {
        return new PageElementActions(GO_TO_PASSWORD, driver);
    }

    //Методы

    @Step("Пользователь переключается на вход по номеру бонусной карты")
    public void setChangeToCardNumber() {
        getChanchToCardNumber().click();
        logger.info("Пользователь переключается на вход по номеру бонусной карты");
    }

    @Step("Пользователь переключается на вход по Email")
    public void setChangeToEmail() {
        getChangeToEmail().click();
        logger.info("Пользователь переключается на вход по Email");
    }

    @Step("Пользователь вводит номер телефона и пароль")
    public void setPhoneNumber(String phoneNumber, String password) {
        getPhoneNumberInput().sendKeys(phoneNumber);
        getGoToPassword().click();
        getPasswordInput().sendKeys(password);
        logger.info("Пользователь вводит номер телефона и пароль");
    }


    @Step("Пользователь вводит номер бонусной карты и пароль")
    public void setCardNumberAandPassword(String cardNumber, String password) {
        getAuthCardNumber().sendKeys(cardNumber);
        getPasswordInput().sendKeys(password);
        logger.info("Пользователь вводит номер бонусной карты и пароль");
    }

    @Step("Пользователь вводит Email и пароль")
    public void setEmailAndPassword(String email, String password) {
        getInputEmail().sendKeys(email);
        getPasswordInput().sendKeys(password);
        logger.info("Пользователь вводит Email и пароль");
    }

    @Step("Пользователь нажимает на кнопку: Войти")
    public void clickToLoginButton() {
        getLoginButoon().click();
        logger.info("Пользователь нажимает на кнопку: Войти");
    }


    @Step("Пользователь вводит Email, пароль и нажимает войти")
    public void authorizeWithEmailAndPassword(String email, String password) {
        setChangeToEmail();
        getInputEmail().sendKeys(email);
        getPasswordInput().sendKeys(password);
        clickToLoginButton();
        logger.info("Пользователь вводит Email, пароль и нажимает войти");
    }


}
