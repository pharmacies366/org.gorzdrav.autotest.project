package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileMainPage extends MainTestBase {

    //элементы
    private static final String SITE_LOGO_XPATH = "xpath;//img[@alt='ГЗ лого.svg']";
    private static final String SEARCH_INPUT_CLICK_XPATH = "xpath;//input[@class='b-search__input']";
    private static final String SEARCH_INPUT_SENDKEYS_XPATH = "xpath;//input[@id='js-site-search-input']";
    private static final String LETTER_N_XPATH = "xpath;//*[@href=\"/littera-Н/\"]";
    private static final String CATALOG_XPATH = "xpath;(//a[contains(.,'Каталог')])[1]";
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String MOBILE_APP_POP_UP_BUTTON_XPATH = "xpath;//div[contains(@class,'flyer--close')]";

    //конструктор
    public MobileMainPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getSiteLogo() {
        return new PageElementActions(SITE_LOGO_XPATH, driver);
    }

    public PageElementActions getSearchInputClick() {
        return new PageElementActions(SEARCH_INPUT_CLICK_XPATH, driver);
    }

    public PageElementActions getSearchInputSendKeys() {
        return new PageElementActions(SEARCH_INPUT_SENDKEYS_XPATH, driver);
    }

    public PageElementActions getLetterN() {
        return new PageElementActions(LETTER_N_XPATH, driver);
    }

    public PageElementActions getCatalog() {
        return new PageElementActions(CATALOG_XPATH, driver);
    }

    public PageElementActions getPopUpButton() {
        return new PageElementActions(POP_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getMobileAppPopUpButton() {
        return new PageElementActions(MOBILE_APP_POP_UP_BUTTON_XPATH, driver);
    }

    //Методы

    @Step("Проверка отображения логотипа сайта на главной странице")
    public void checkElementIsCorrect() {
        getSiteLogo().elementIsVisibility();
        logger.info("Лого отображается");
    }

    @Step("Пользователь нажимает на кнопку Логотипа и переходит на главную страницу сайта")
    public void clickSiteLogo(){
        getSiteLogo().click();
        logger.info("Пользователь нажимает на кнопку Логотипа и переходит на главную страницу сайта");
    }

    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp() {
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Пользователь закрывает попап мобильного приложения: 'Приложение 36.6'")
    public void clickCloseMobileAppPopUp() {
        getMobileAppPopUpButton().click();
        logger.info("Пользователь закрывает попап мобильного приложения: 'Приложение 36.6'");
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {search}")
    public void setSearchInput(String search) {
        getSearchInputClick().click();
        getSearchInputSendKeys().clickAndSendKeys(search);
        logger.info("Пользователь вводит артикул товара в поисковую строку");
    }

    @Step("Пользователь нажимает на кнопку 'Каталог")
    public void checkCatalogButton() {
        getCatalog().click();
        logger.info("Пользователь нажимает на кнопку 'Каталог'");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN() {
        getLetterN().click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }
}
