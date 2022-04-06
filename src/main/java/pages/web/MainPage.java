package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MainPage extends MainTestBase {

    //элементы
    private static final String SEARCH_INPUT_XPATH = "xpath;//input[@id='js-site-search-input']";
    private static final String LETTER_N_XPATH = "xpath;//*[@href=\"/littera-Н/\"]";
    private static final String CATALOG_XPATH = "xpath;(//div[contains(.,'Каталог')])[15]";
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String ADD_TO_CART_BUTTON_XPATH = "xpath;(//button[contains(.,'Купить')])[1]";

    //конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public PageElementActions getSearchInput() {
        return new PageElementActions(SEARCH_INPUT_XPATH, driver);
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

    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CART_BUTTON_XPATH, driver);
    }

    //Методы


    @Step("Пользователь вводит артикул товара в поисковую строку - {search}")
    public void setSearchInput(String search) {
        getSearchInput().sendKeys(search);
        logger.info("Пользователь вводит артикул не партнерсского товара в поисковую строку");
    }

    @Step("Пользователь нажимает на кнопку 'Каталог")
    public void checkCatalogButton(){
        getCatalog().click();
        logger.info("Пользователь нажимает на кнопку 'Каталог'");
    }

    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp(){
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN(){
        getLetterN().click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }

    @Step("Пользователь нажимает на кнопку 'Купить'")
    public void clickAddToCardButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'Купить'");
    }

}
