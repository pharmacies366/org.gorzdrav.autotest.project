package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class MobileAuthPopUpPage extends MainTestBase {

    //элементы
    private static final String PHONE_NUMBER_INPUT_ID = "id;login-phone";
    private static final String LOGIN_BUTTON_XPATH = "xpath;//button[contains(.,'Войти')]";
    private static final String CHANGE_TO_CARD_NUMBER_XPATH = "xpath;//a[contains(.,'Номер карты')]";
    private static final String AUTH_CARD_NUMBER_ID = "id;login-cardNumber";
    private static final String CHANGE_TO_EMAIL_XPATH = "xpath;//a[contains(.,'E-mail')]";
    private static final String AUTH_EMAIL_XPATH = "xpath;//input[@id='login-email']";
    private static final String PASSWORD_INPUT_ID = "id;login-pass";


    //конструктор
    public MobileAuthPopUpPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getPhoneNumberInput() {
        return new PageElementActions(PHONE_NUMBER_INPUT_ID, driver);
    }

    public PageElementActions getPasswordInput() {
        return new PageElementActions(PASSWORD_INPUT_ID, driver);
    }

    public PageElementActions getLoginButoon() {
        return new PageElementActions(LOGIN_BUTTON_XPATH, driver);
    }

    public PageElementActions getChanchToCardNumber() {
        return new PageElementActions(CHANGE_TO_CARD_NUMBER_XPATH, driver);
    }

    public PageElementActions getAuthCardNumber() {
        return new PageElementActions(AUTH_CARD_NUMBER_ID, driver);
    }

    public PageElementActions getChanchToEmail() {
        return new PageElementActions(CHANGE_TO_EMAIL_XPATH, driver);
    }

    public PageElementActions getInputEmail() {
        return new PageElementActions(AUTH_EMAIL_XPATH, driver);
    }

    //Методы

    @Step("Пользователь переключается на вход по номеру бонусной карты")
    public void setChangeToCardNumber() {
        getChanchToCardNumber().click();
    }

    @Step("Пользователь переключается на вход по Email")
    public void setChangeToEmail() {
        getChanchToEmail().click();
    }

    @Step("Пользователь вводит номер телефона")
    public void setPhoneNumber(String phoneNumber) {
        getPhoneNumberInput().sendKeys(phoneNumber);
    }


    @Step("Пользователь вводит номер бонусной карты и пароль")
    public void setCardNumberAandPassword(String cardNumber, String password) {
        getAuthCardNumber().sendKeys(cardNumber);
        getPasswordInput().sendKeys(password);
    }

    @Step("Пользователь вводит Email и пароль")
    public void setEmailAndPassword(String email, String password) {
        getInputEmail().sendKeys(email);
        getPasswordInput().sendKeys(password);
    }

    @Step("клик на кнопку \"войти\"")
    public void clickToLoginButton() {
        getLoginButoon().click();
    }

    @Step("Пользователь вводит Email, пароль и нажимает войти")
    public void authorizeWithEmailAndPassword(String email, String password) {
        setChangeToEmail();
        getInputEmail().sendKeys(email);
        getPasswordInput().sendKeys(password);
        clickToLoginButton();
    }

}
