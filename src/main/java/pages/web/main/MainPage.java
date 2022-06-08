package pages.web.main;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MainPage extends MainTestBase {

    /**
     * Действия на главной странице
     */

    //элементы
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String LETTER_N_XPATH = "xpath;//a[@href='/littera-Н/']";
    private static final String ADD_TO_CART_BUTTON_XPATH = "xpath;(//button[@type='submit' and @class='b-btn js-enable-btn js-add-to-cart-listing--gz b-btn--without-merger-modifications'])[1]";
    private static final String QUANTITY_MATERIALS_XPATH = "xpath;(//div[contains(@class,'b-btn-qty-selector-grid-gz-count js-add-to-cart--gz-count')])[1]";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//div[@class='b-btn-qty-selector-grid-plus'])[1]";
    private static final String DECREASE_QUANTITY_XPATH = "xpath;(//div[@class='b-btn-qty-selector-grid-minus'])[1]";
    private static final String FAVORITES_ICON_XPATH = "xpath;(//button[contains(@class,'button b-star')])[1]";
    private static final String BANNER_LIST_XPATH = "xpath;(//button[@type='button'])";
    private static final String CHECK_START_BANNER_XPATH = "xpath;(//img[@class='b-bnr--responsive__img '])[1]";
    private static final String PREV_BANNER_XPATH = "xpath;//button[@class='slick-prev slick-arrow']";
    private static final String NEXT_BANNER_XPATH = "xpath;//button[@class='slick-next slick-arrow']";
    private static final String BANNER_PIN_BUTTONS_XPATH = "xpath;//button[@type='button'][contains(.,'%s')]";
    private static final String BANNERS_BUTTONS_XPATH = "xpath;//div[@class='p_slider js-banner-slider _infinite slick-initialized slick-slider']";
    private static final String MAIN_BUTTON_XPATH = "xpath;//span[contains(.,'Главная')]";
    private static final String QUANTITY_BANNERS_XPATH = "xpath;//ul[contains(@role,'tablist')]";
    private static final String CLOSE_POP_UP_NEWS_BUTTON_XPATH = "xpath;//div[@class='popmechanic-close']";
    private static final String CATALOG_BUTTON_XPATH = "xpath;//div[@class='c-header-menu__item-title c-header-menu__item-title--modify js-dropdown-menu-button js-navigation-menu__title'][contains(.,'Каталог')]";
    private static final String PRODUCT_BUTTON_XPATH = "xpath;(//div[@class='c-prod-item__title'])[1]";
    private static final String BOT_CONSULTANT_BUTTON_XPATH = "xpath;//jdiv[@id='jvlabelWrap']";
    private static final String BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH = "xpath;//div[@class='c-card-balance--product c-card-balance--background']";
    private static final String COLOR_TEXT_PRODUCT_GALLERY_BUTTON_XPATH = "xpath;(//div[@class='c-card-balance__text c-card-balance__text--list'])[1]";
    private static final String CASH_BACK_INFO_POP_UP_XPATH = "xpath;//div[@class='hint__title']";
    private static final String LINK_MORE_ABOUT_BONUSES_XPATH = "xpath;//a[@href='/pravila_programmy/'][contains(.,'Подробнее о бонусах')]";

    private static final String PLUS_ON_BONUS_BUTTON_XPATH = "xpath;(//div[@class='c-card-balance__text c-card-balance__text--list'])[1][contains(.,'+')]";

    //конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getPopUpButton() {
        return new PageElementActions(POP_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getLetterN() {
        return new PageElementActions(LETTER_N_XPATH, driver);
    }

    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getMaterialsQuantity() {
        return new PageElementActions(QUANTITY_MATERIALS_XPATH, driver);
    }

    public PageElementActions getIncreaseQuantity() {
        return new PageElementActions(INCREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getDecreaseQuantity() {
        return new PageElementActions(DECREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getFavoritesIcon() {
        return new PageElementActions(FAVORITES_ICON_XPATH, driver);
    }

    public PageElementActions getBannerList() {
        return new PageElementActions(BANNER_LIST_XPATH, driver);
    }

    public PageElementActions getCheckStartBanner() {
        return new PageElementActions(CHECK_START_BANNER_XPATH, driver);
    }

    public PageElementActions getPrevBannerButton() {
        return new PageElementActions(PREV_BANNER_XPATH, driver);
    }

    public PageElementActions getNextBannerButton() {
        return new PageElementActions(NEXT_BANNER_XPATH, driver);
    }

    public PageElementActions getBaseInputBannersPinLocators(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBannersLocators() {
        return new PageElementActions(BANNERS_BUTTONS_XPATH, driver);
    }

    public PageElementActions getMainButton() {
        return new PageElementActions(MAIN_BUTTON_XPATH, driver);
    }


    public PageElementActions getStringQuantityBanners() {
        return new PageElementActions(QUANTITY_BANNERS_XPATH, driver);
    }

    public PageElementActions getClosePopUpNewsButton() {
        return new PageElementActions(CLOSE_POP_UP_NEWS_BUTTON_XPATH, driver);
    }

    public PageElementActions getCatalogButton() {
        return new PageElementActions(CATALOG_BUTTON_XPATH, driver);
    }

    public PageElementActions getProductButton() {
        return new PageElementActions(PRODUCT_BUTTON_XPATH, driver);
    }

    public PageElementActions getBotConsultantButton() {
        return new PageElementActions(BOT_CONSULTANT_BUTTON_XPATH, driver);
    }

    public PageElementActions getBackgroundColorProductGalleryButton() {
        return new PageElementActions(BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH, driver);
    }

    public PageElementActions getTextColorProductGalleryButton() {
        return new PageElementActions(COLOR_TEXT_PRODUCT_GALLERY_BUTTON_XPATH, driver);
    }

    public PageElementActions getCashBackInfoPopUp() {
        return new PageElementActions(CASH_BACK_INFO_POP_UP_XPATH, driver);
    }

    public PageElementActions getMoreAboutBonuses() {
        return new PageElementActions(LINK_MORE_ABOUT_BONUSES_XPATH, driver);
    }

    public PageElementActions getPlusOnBonusButton() {
        return new PageElementActions(PLUS_ON_BONUS_BUTTON_XPATH, driver);
    }



    //Методы
    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp() {
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Пользователь нажимает закрыть новосной попап")
    public void ClickClosePopUpNewsButton() {
        getClosePopUpNewsButton().click();
        logger.info("Пользователь нажимает закрыть новосной попап");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN() {
        getLetterN().click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void clickAddToCardButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }

    @Step("Сохранение количества товаров")
    public int getQuantityMaterials() {
        int quantity = getMaterialsQuantity().formatElementToValue();
        logger.info("Запоминаем количество товара");
        return quantity;
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public void clickIncreaseQuantity() {
        getIncreaseQuantity().click();
        logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
    }

    @Step("Пользователь нажимает '-' уменьшая количество шт. товара")
    public void clickDecreaseQuantity() {
        getDecreaseQuantity().click();
        logger.info("Пользователь нажимает '-' уменьшая количество шт. товара");
    }

    @Step("Пользователь добавляет товар в избранное")
    public void clickFavoritesIcon() {
        getFavoritesIcon().click();
        logger.info("Пользователь добавляет товар в избранное");
    }


    @Step("Пользователь кликает по стрелке вперед, переключает банеры и проверяет, что возвращается к первому")
    public void checkNextBannerList() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getNextBannerButton().click();
            getBannerList().isElementDisplayedWithIndex(i);
        }
        getCheckStartBanner().isElementDisplayed();
        logger.info("Пользователь кликает по стрелке вперед, переключает банеры и проверяет, что возвращается к первому");
    }

    @Step("Пользователь кликает по стрелке назад, переключает банеры и проверяет, что возвращается к первому")
    public void checkPrevBannerList() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getPrevBannerButton().click();
            getBannerList().isElementDisplayedWithIndex(i);
        }
        getCheckStartBanner().isElementDisplayed();
        logger.info("Пользователь кликает по стрелке назад, переключает банеры и проверяет, что возвращается к первому");
    }


    @Step("Пользователь переключает банеры по пинам")
    public void checkNextBannerButtons() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
        }
        logger.info("Пользователь переключает банеры по пинам");
    }


    @Step("Пользователь переключает банеры по пинам и возвращается на главную страницу")
    public void checkBannersClickable() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
            getBannersLocators().click();
            getMainButton().click();
        }
        logger.info("Пользователь переключает банеры по пинам и возвращается на главную страницу");
    }


    @Step("Пользователь нажимает на кнопку каталог")
    public void clickCatalogButton() {
        getCatalogButton().click();
        logger.info("Пользователь нажимает на кнопку каталог");
    }

    @Step("Пользователь нажимает на первый товар в списке на главной странице")
    public void clickFirstProductOnMainPage() {
        getProductButton().click();
        logger.info("Пользователь нажимает на первый товар в списке на главной странице");
    }

    @Step("Пользователь нажимает на иконку консультант бота")
    public void clickBotConsultantButton() {
        getBotConsultantButton().click();
        logger.info("Пользователь нажимает на иконку консультант бота");
    }

    @Step("Получение цвета кнопки")
    public String getColorBackgroundProductGalleryButton() {
        String backgroundColor = getBackgroundColorProductGalleryButton().getBackgroundColor();
        logger.info("Получение цвета кнопки");
        return backgroundColor;
    }

    @Step("Получение цвета текста кнопки с расчётом бонусов")
    public String getColorTextProductGalleryButton() {
        String colorButton = getTextColorProductGalleryButton().getColor();
        logger.info("Получение цвета текста кнопки с расчётом бонусов");
        return colorButton;
    }

    @Step("Получение текста загаловка с попапом информации про -  Cash back за покупку")
    public String getTextAboutCashBack() {
        String text = getCashBackInfoPopUp().getText();
        logger.info("Получение текста загаловка с попапом информации про -  Cash back за покупку");
        return text;
    }

    @Step("Пользователь переходит по ссылке: Подробнее о бонусах")
    public void clickOnLinkMoreAboutBonuses() {
        getMoreAboutBonuses().click();
        logger.info("ользователь переходит по ссылке: Подробнее о бонусах");
    }

  @Step("Пользователь проверяет, что на шильдике с количеством бонусов присутствует значок '+'")
    public void checkPlusOnBonusButton() {
      getPlusOnBonusButton().isElementDisplayed();
        logger.info("Пользователь проверяет, что на шильдике с количеством бонусов присутствует значок '+'");
    }


}
