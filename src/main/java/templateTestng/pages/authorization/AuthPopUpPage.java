package templateTestng.pages.authorization;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import templateTestng.actions.PageElementActions;
import templateTestng.driver.DriverManager;


public class AuthPopUpPage {

    public Logger logger = LogManager.getLogger();

    /**
     * Действия на странице авторизации
    */

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
    public PageElementActions authPopUpPage(){
        return PageElementActions.getInstance();
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getPhoneNumberInput(){
        PageElementActions.getInstance().initialize(_PHONE_NUMBER_INPUT_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }

    public PageElementActions getLoginButton(){
        PageElementActions.getInstance().initialize(_LOGIN_BUTTON_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }
    public PageElementActions getGoPassword(){
        PageElementActions.getInstance().initialize(GO_PASSWORD_INPUT_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }
    public PageElementActions getPassword(){
        PageElementActions.getInstance().initialize(_PASSWORD_INPUT_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }
    public PageElementActions getChanchToEmail(){
        PageElementActions.getInstance().initialize(_CHANGE_TO_EMAIL_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }

    public PageElementActions getInputEmail(){
        PageElementActions.getInstance().initialize(_AUTH_EMAIL_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }

    public PageElementActions getGoToPassword(){
        PageElementActions.getInstance().initialize(GO_TO_PASSWORD_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }

    public PageElementActions getPasswordInput(){
        PageElementActions.getInstance().initialize(_PASSWORD_INPUT_ID, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }

    public PageElementActions getChanchToCardNumber(){
        PageElementActions.getInstance().initialize(_CHANGE_TO_CARD_NUMBER_XPATH, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }
    public PageElementActions getAuthCardNumber(){
        PageElementActions.getInstance().initialize(_AUTH_CARD_NUMBER_ID, DriverManager.getDriver());
        return PageElementActions.getInstance();
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
        getPhoneNumberInput().waitingForElementNullOnThePage();
    }


}
