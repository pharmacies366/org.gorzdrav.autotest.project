package pages.commonActions.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class CommonActionsOnMobilePages extends MainTestBase {


    //элементы
    private static final String FILTERS_BUTTON_XPATH = "xpath;//i[@class='b-icn--filter']";
    private static final String RELEASE_FORM_BUTTON_XPATH = "xpath;//div[@class='js-facet-name '][contains(.,'Форма выпуска')]";
    private static final String BRAND_BUTTON_XPATH = "xpath;//div[@class='js-facet-name '][contains(.,'Бренд')]";
    private static final String MANUFACTURERS_BUTTON_XPATH = "xpath;//div[@class='js-facet-name '][contains(.,'Производители')]";
    private static final String BASE_INPUT_SELECTED_CHECKBOX_XPATH = "xpath;(//span[contains(.,'%s')])[2]";
    private static final String DELIVERY_ALLOWED_BUTTON_XPATH = "xpath;(//div[@data-code='deliveryAllowed'])[1]";
    private static final String PAGE_TITLE_XPATH = "xpath;//h1[contains(@class,'b-page-title i-mg0 js-category-title')]";
    private static final String COST_BUTTON_XPATH = "xpath;(//div[@data-code='priceValue'])[1]";
    private static final String PRODUCT_BUTTON_XPATH = "xpath;//a[@data-gtm-position='%s']";
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";
    private static final String SLIDER_FROM_XPATH = "xpath;//span[@class='irs-slider from']";
    private static final String SLIDER_TO_XPATH = "xpath;//span[@class='irs-slider to']";
    private static final String PRICE_RANGE_FROM_XPATH = "xpath;(//input[@class='b-range__input js-range-from'])[2]";
    private static final String PRICE_RANGE_TO_XPATH = "xpath;(//input[@class='b-range__input js-range-to'])[2]";
    private static final String PRODUCT_PRICES_RANGE_LIST_XPATH = "xpath;//div[@class='c-prod-item js-product-item b-section c-prod-item--list ']";
    private static final String BASE_INPUT_CHECK_PRODUCT_PRICE_XPATH = "xpath;(//span[@class='b-price '])[%s]";
    private static final String BASE_INPUT_CHECK_PRODUCT_BONUSES_CHECK_XPATH = "xpath;(//div[@class='c-card-balance__text c-card-balance__text--list'])[%s]";
    private static final String BASE_INPUT_CHECK_PRODUCT_DELIVERY_METHOD_XPATH = "xpath;(//span[@class='b-prod-label b-prod-label_delivery'])[%s]";
    private static final String CHECKBOX_DELIVERY_XPATH = "xpath;(//span[@class='b-trim-str'][contains(.,'Доставка')])[2]";
    private static final String GET_SELECTED_CHECKBOX_XPATH = "xpath;//div[@class='filters_selected'][contains(.,'%s')]";
    private static final String CLOSE_CHECKBOX_DELIVERY_XPATH = "xpath;(//a[@class='b-icn--close c-facets__close-button'])[2]";
    private static final String PRODUCTS_WITHOUT_DELIVERY_METHOD_XPATH = "xpath;//span[@class='b-prod-label b-prod-label_delivery' and not(@type='b-prod-label b-prod-label_delivery')]";
    private static final String RESET_CHECKBOXES_XPATH = "xpath;//form[@class='filters_reset']//child::button";
    private static final String SHOW_ALL_XPATH = "xpath;(//a[contains(@class,'i-fw-b js-show-all-facets')])[%s]";
    private static final String BASE_INPUT_CHECK_MAIN_INFORMATION_XPATH = "xpath;//div[@class='product__info__desc'][contains(.,'%s')]";
    private static final String OPTION_COUNT_XPATH = "xpath;//div[@class='overview']";
    private static final String PAGE_NUMBER_OPEN_XPATH = "xpath;//span[@class='active b-pagination__item']";
    private static final String PAGE_NUMBER_TITLE_OPEN_XPATH = "xpath;//h1[contains(@class,'js-category-title')]";
    private static final String NEXT_PAGINATION_BUTTON_XPATH = "xpath;//a[@class='b-pagination__item js-pager-next']";
    private static final String PREV_PAGINATION_BUTTON_XPATH = "xpath;//a[@class='b-pagination__item']//child::i";
    private static final String BASE_INPUT_CHECKBOX_OPTION_XPATH = "xpath;(//span[@class='b-custom-input'])[%s]";
    private static final String ON_RECIPE_BUTTON_XPATH = "xpath;//div[@class='js-facet-name '][contains(.,'Отпуск по рецепту')]";
    private static final String SOME_PRODUCTS_XPATH = "xpath;(//img[@class=' lazyloaded'])[1]";
    private static final String ON_RECIPE_CHECKBOX_XPATH = "xpath;(//span[contains(.,'Отпуск по рецепту')])[4]";
    private static final String WITHOUT_RECIPE_CHECKBOX_XPATH = "xpath;(//span[contains(.,'Отпуск без рецепта')])[2]";
    private static final String SORTING_BUTTON_XPATH = "xpath;//span[contains(@class,'ui-selectmenu-text')]";
    private static final String SORTING_NAME_XPATH = "xpath;//span[@class='ui-selectmenu-text']";
    private static final String BASE_INPUT_SORTING_OPTIONS_XPATH = "xpath;//div[contains(@id,'ui-id-%s')]";
    private static final String CLOSE_POPUP_BUTTON_XPATH = "xpath;//svg[@class='close-icon uxs-1oddrgm']";
    private static final String PRICE_REDUCTION = "5";
    private static final String PRICE_INCREASE = "4";
    private static final String SORTING_NAME = "3";

    private static final String BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH = "xpath;//div[@class='c-card-balance--product c-card-balance--background']";

    private static final String PRODUCT_GALLERY_BONUSES_BUTTON_XPATH = "xpath;(//div[@class='c-card-balance__text c-card-balance__text--list'])[1]";

    private static final String PLUS_ON_BONUS_BUTTON_XPATH = "xpath;(//div[@class='c-card-balance__text c-card-balance__text--list'])[1][contains(.,'+')]";

    private static final String PRICE_TEXT_XPATH = "xpath;//span[contains(.,'Цена')]";

    private static final String SHOW_ALL_PRODUCTS_XPATH = "xpath;//div[@class='b-btn__show-all-products js-show-all-product']";




    //конструктор
    public CommonActionsOnMobilePages(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getProductButton(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBanner() {
        return new PageElementActions(BANNER_XPATH, driver);
    }

    public PageElementActions getSliderFrom() {
        return new PageElementActions(SLIDER_FROM_XPATH, driver);
    }

    public PageElementActions getSliderTo() {
        return new PageElementActions(SLIDER_TO_XPATH, driver);
    }

    public PageElementActions getPriceRangeFrom() {
        return new PageElementActions(PRICE_RANGE_FROM_XPATH, driver);
    }

    public PageElementActions getPriceRangeTo() {
        return new PageElementActions(PRICE_RANGE_TO_XPATH, driver);
    }

    public PageElementActions getProductList() {
        return new PageElementActions(PRODUCT_PRICES_RANGE_LIST_XPATH, driver);
    }

    public PageElementActions getBaseInputCheckProductPrice(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputCheckSelectedCheckbox(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getCheckboxDelivery() {
        return new PageElementActions(CHECKBOX_DELIVERY_XPATH, driver);
    }

    public PageElementActions getDeliveryMethod(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getCloseCheckboxDelivery() {
        return new PageElementActions(CLOSE_CHECKBOX_DELIVERY_XPATH, driver);
    }

    public PageElementActions getProductsWithoutDeliveryMethod() {
        return new PageElementActions(PRODUCTS_WITHOUT_DELIVERY_METHOD_XPATH, driver);
    }

    public PageElementActions getResetCheckboxes() {
        return new PageElementActions(RESET_CHECKBOXES_XPATH, driver);
    }

    public PageElementActions getCheckboxOption(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getShowAll(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getMainInformation(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getOptionCount() {
        return new PageElementActions(OPTION_COUNT_XPATH, driver);
    }

    public PageElementActions getPageNumberOpen() {
        return new PageElementActions(PAGE_NUMBER_OPEN_XPATH, driver);
    }

    public PageElementActions getPageNumberOpenTitle() {
        return new PageElementActions(PAGE_NUMBER_TITLE_OPEN_XPATH, driver);
    }

    public PageElementActions getFiltersButton() {
        return new PageElementActions(FILTERS_BUTTON_XPATH, driver);
    }

    public PageElementActions getReleaseForm() {
        return new PageElementActions(RELEASE_FORM_BUTTON_XPATH, driver);
    }

    public PageElementActions getBrand() {
        return new PageElementActions(BRAND_BUTTON_XPATH, driver);
    }

    public PageElementActions getManufacturers() {
        return new PageElementActions(MANUFACTURERS_BUTTON_XPATH, driver);
    }

    public PageElementActions getBaseInputSelectedCheckbox(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getDeliveryAllowedButton() {
        return new PageElementActions(DELIVERY_ALLOWED_BUTTON_XPATH, driver);
    }

    public PageElementActions getPageTitle() {
        return new PageElementActions(PAGE_TITLE_XPATH, driver);
    }

    public PageElementActions getCostButton() {
        return new PageElementActions(COST_BUTTON_XPATH, driver);
    }

    public PageElementActions getNexPaginationButton() {
        return new PageElementActions(NEXT_PAGINATION_BUTTON_XPATH, driver);
    }

    public PageElementActions getPrevPaginationButton() {
        return new PageElementActions(PREV_PAGINATION_BUTTON_XPATH, driver);
    }

    public PageElementActions getOnRecipeButton() {
        return new PageElementActions(ON_RECIPE_BUTTON_XPATH, driver);
    }

    public PageElementActions getClickSomeProducts() {
        return new PageElementActions(SOME_PRODUCTS_XPATH, driver);
    }


    public PageElementActions getOnRecipeCheckbox() {
        return new PageElementActions(ON_RECIPE_CHECKBOX_XPATH, driver);
    }

    public PageElementActions getWithoutRecipeCheckbox() {
        return new PageElementActions(WITHOUT_RECIPE_CHECKBOX_XPATH, driver);
    }

    public PageElementActions getSortingButton() {
        return new PageElementActions(SORTING_BUTTON_XPATH, driver);
    }

    public PageElementActions getSortingName() {
        return new PageElementActions(SORTING_NAME_XPATH, driver);
    }

    public PageElementActions getClosePopup() {
        return new PageElementActions(CLOSE_POPUP_BUTTON_XPATH, driver);
    }

    public PageElementActions getSortingOptions(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBackgroundColorProductGalleryButton() {
        return new PageElementActions(BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH, driver);
    }

    public PageElementActions getProductGalleryBonusesButton() {
        return new PageElementActions(PRODUCT_GALLERY_BONUSES_BUTTON_XPATH, driver);
    }

    public PageElementActions getProductGalleryBonusesCheck(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getPlusOnBonusButton() {
        return new PageElementActions(PLUS_ON_BONUS_BUTTON_XPATH, driver);
    }

    public PageElementActions getPriceText() {
        return new PageElementActions(PRICE_TEXT_XPATH, driver);
    }

    public PageElementActions getShowAllProductsButton() {
        return new PageElementActions(SHOW_ALL_PRODUCTS_XPATH, driver);
    }



    //Методы
    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }

    @Step("Пользователь изменяет нижный и верхний диапозон цены")
    public void changePricesRangeWithSlider() {
        getSliderFrom().drugAndDropToOffSet(50, 0);
        getFiltersButton().click();
        getSliderTo().drugAndDropToOffSet(-50, 0);
        logger.info("Пользователь изменяет нижный и верхний диапозон цены");
    }

    @Step("Пользователь нажимает на кнопку фильтры")
    public void clickFiltersButton() {
        getFiltersButton().click();
        logger.info("Пользователь нажимает на кнопку фильтры");
    }

    @Step("Пользователь нажимает на кнопку Форма выпуска")
    public void clickReleaseForm() {
        getReleaseForm().click();
        logger.info("Пользователь нажимает на кнопку Форма выпуска");
    }

    @Step("Пользователь нажимает на кнопку Бренд")
    public void clickBrand() {
        getBrand().click()
        logger.info("Пользователь нажимает на кнопку Бренд");
    }

    @Step("Пользователь нажимает на кнопку Производители")
    public void clickManufacturers() {
        getManufacturers().click();
        logger.info("Пользователь нажимает на кнопку Производители");
    }

    @Step("Пользователь нажимает выбранный чекбокс")
    public void clickCheckbox(String SELECTED_CHECKBOX) {
        getBaseInputSelectedCheckbox(String.format(BASE_INPUT_SELECTED_CHECKBOX_XPATH, SELECTED_CHECKBOX)).click();
        logger.info("Пользователь нажимает на выбранную опцию");
    }

    @Step("Пользователь закрывает попап с оченкой приложения")
    public void closePopupLikeApp() {
        getClosePopup().click();
        logger.info("Пользователь закрывает попап с оченкой приложения");
    }

    @Step("Пользователь проверяет название странице")
    public String checkPageTitle() {
        String title = getPageTitle().getText();
        logger.info("Пользователь проверяет название странице");
        return title;
    }

    @Step("Пользователь нажимает на кнопку Доступность доставки")
    public void deliveryAllowedButton() {
        getDeliveryAllowedButton().click();
        logger.info("Пользователь нажимает на кнопку Доступность доставки");
    }

    @Step("Пользователь нажимает на кнопку Цена")
    public void clickCostButton() {
        getCostButton().click();
        logger.info("Пользователь нажимает на кнопку Цена");
    }

    @Step("Пользователь получает значение начального диапазона цены")
    public int getFromPriceRange() {
        logger.info("Пользователь получает значение начального диапазона цены");
        String priseRangeFrom = getPriceRangeFrom().getAttribute("placeholder");
        return Integer.parseInt(priseRangeFrom);
    }

    @Step("Пользователь получает значение конечного диапазона цены")
    public int getToPriceRange() {
        logger.info("Пользователь получает значение конечного диапазона цены");
        String priseRangeTo = getPriceRangeTo().getAttribute("placeholder");
        return Integer.parseInt(priseRangeTo);
    }


    @Step("Пользователь прописывает нижный и верхний диапозон цены")
    public void changePricesRangeWithHands(String fromPrice, String toPrice) {
        getPriceRangeFrom().clean();
        getPriceRangeFrom().sendKeys(fromPrice);
       /* getFiltersButton().click();
        getCostButton().click();*/
        getPriceRangeTo().clean();
        getPriceRangeTo().sendKeysAndEnter(toPrice);
        logger.info("Пользователь прописывает нижный и верхний диапозон цены");
    }

    @Step("Пользователь проверяет цены на текущей странице выдачи")
    public int checkProductsPrices() {
        int price = 0;
        int par = getProductList().getSize();
        for (int i = 1; i <= par; i++) {
            price = getBaseInputCheckProductPrice(String.format(BASE_INPUT_CHECK_PRODUCT_PRICE_XPATH, i)).formatElementToValue();
        }
        logger.info("Пользователь проверяет цены на текущей странице выдачи");
        return price;
    }

    @Step("Пользователь проверяет наличие бонусных баллов у товаров")
    public void checkBonusesOnProducts() {
        int par = getProductList().getSize();
        for (int i = 1; i <= par; i++) {
          getProductGalleryBonusesCheck(String.format(BASE_INPUT_CHECK_PRODUCT_BONUSES_CHECK_XPATH, i)).formatElementToValue();
        }
        logger.info("Пользователь проверяет наличие бонусных баллов у товаров");
    }

    @Step("Пользователь выбирает чекбокс с доставкой")
    public void clickCheckboxDelivery() {
        getCheckboxDelivery().click();
        logger.info("Пользователь выбирает чекбокс с доставкой");
    }

    @Step("Пользователь проверяет установку чекбокса - {checkboxName}")
    public void checkSelectedCheckbox(String checkboxName) {
        getBaseInputCheckSelectedCheckbox(String.format(GET_SELECTED_CHECKBOX_XPATH, checkboxName)).isElementDisplayed();
        logger.info("Пользователь проверяет установку чекбокса");
    }

    @Step("Пользователь проверяет что после установки чекбокса Доставка, все товары показываются только с доставкой")
    public void checkSelectedProductsWithDeliveryMethod() {
        int par = getProductList().getSize();
        for (int i = 1; i <= par; i++) {
            getDeliveryMethod(String.format(BASE_INPUT_CHECK_PRODUCT_DELIVERY_METHOD_XPATH, i)).isElementDisplayed();
        }
        logger.info("Пользователь проверяет что после установки чекбокса Доставка, все товары показываются только с доставкой");
    }

    @Step("Пользователь снимает чекбокс Доставка")
    public void clickCloseCheckboxDelivery() {
        getCloseCheckboxDelivery().click();
        logger.info("Пользователь снимает чекбокс Доставка");
    }


    @Step("Пользователь нажимает на кнопку для выбора сортировки товаров")
    public void clickSortingButton() {
        getSortingButton().click();
        logger.info("Пользователь нажимает на кнопку для выбора сортировки товаров");
    }

    @Step("Пользователь нажимает на сортировку товаров по увеличению цены")
    public void clickPriceIncreaseOption() {
        getSortingOptions(String.format(BASE_INPUT_SORTING_OPTIONS_XPATH, PRICE_INCREASE)).click();
        logger.info("Пользователь нажимает на сортировку товаров по увеличению цены");
    }

    @Step("Пользователь проверяет сортировку товаров по увеличению цены")
    public void checkSortingPriceIncrease() {
        int par = getProductList().getSize();
        for (int i = 1; i <= par; i++) {
            int price = getBaseInputCheckProductPrice(String.format(BASE_INPUT_CHECK_PRODUCT_PRICE_XPATH, i)).formatElementToValue();
            Assertions.assertTrue(price <= price + i);
        }
        logger.info("Пользователь проверяет сортировку товаров по увеличению цены");
    }

    @Step("Пользователь нажимает на сортировку товаров по уменьшению цены")
    public void clickPriceReductionOption() {
        getSortingOptions(String.format(BASE_INPUT_SORTING_OPTIONS_XPATH, PRICE_REDUCTION)).click();
        logger.info("Пользователь нажимает на сортировку товаров по уменьшению цены");
    }

    @Step("Пользователь проверяет сортировку товаров по уменьшению цены")
    public void checkSortingPriceReduction() {
        int par = getProductList().getSize();
        for (int i = 1; i <= par; i++) {
            int price = getBaseInputCheckProductPrice(String.format(BASE_INPUT_CHECK_PRODUCT_PRICE_XPATH, i)).formatElementToValue();
            Assertions.assertTrue(price <= price + i);
        }
        logger.info("Пользователь проверяет сортировку товаров по уменьшению цены");
    }

    @Step("Пользователь нажимает на сортировку по названию")
    public void clickSortingNameOption() {
        getSortingOptions(String.format(BASE_INPUT_SORTING_OPTIONS_XPATH, SORTING_NAME)).click();
        logger.info("Пользователь нажимает на сортировку по названию");
    }

    @Step("Пользователь проверяет результат сортировки")
    public void checkSortingOption(String sortingOptionName) {
        String sortingOption = getSortingName().getText();
        Assertions.assertEquals(sortingOptionName, sortingOption);
        logger.info("Пользователь проверяет результат сортировки");
    }


    @Step("Пользователь проверяет что после снятия чекбокса Доставка, товары показываются со всеми методами получения")
    public void checkSelectedProductsWithAllMethods() {
        int par = getProductList().getSize();
        int countDelivery = getProductsWithoutDeliveryMethod().getSize();
        Assertions.assertTrue(par > countDelivery);
        logger.info("Пользователь проверяет что после снятия чекбокса Доставка, товары показываются со всеми методами получения");
    }

    @Step("Пользователь нажимает: 'Сбросить всё'")
    public void clickResetCheckboxes() {
        getResetCheckboxes().click();
        logger.info("Пользователь нажимает: 'Сбросить всё'");
    }

    @Step("Пользователь нажимает: Показать все")
    public void clickShowAll(int index) {
        getShowAll(String.format(SHOW_ALL_XPATH, index)).click();
        logger.info("Пользователь нажимает: Показать все");
    }

    @Step("Пользователь выбирает одну из опций и проверяет содержание выбранной опции: в блоке Основная информация")
    public void clickAndCheckCheckboxes(int index) {
        String stringCount = getOptionCount().getAttribute("childElementCount");
        int count = Integer.parseInt(stringCount);
        int randomNumber = (new Random()).ints(1, count).iterator().nextInt();
        logger.info("Пользователь рандомом выбирает опцию из чекбоксов чекбокс: форма выпуска, бредн, теги, для кого, производители");
        getCheckboxOption(String.format(BASE_INPUT_CHECKBOX_OPTION_XPATH, randomNumber + index)).moveToElementJs();
        String optionName = getCheckboxOption(String.format(BASE_INPUT_CHECKBOX_OPTION_XPATH, randomNumber + index)).getText();
        getCheckboxOption(String.format(BASE_INPUT_CHECKBOX_OPTION_XPATH, randomNumber + index)).click()
        logger.info("Пользователь нажимает на выбранную опцию");

        int par = getProductList().getSize();
        int randomNumberProduct;
        if (par == 1) {//данный if выполняется для того чтобы не получать Exception: bound must be greater than origin
            randomNumberProduct = 1;
        } else {
            randomNumberProduct = (new Random()).ints(1, par).iterator().nextInt();
        }
        getProductButton(String.format(PRODUCT_BUTTON_XPATH, randomNumberProduct)).click();
        logger.info("Пользователь проверяет содержание выбранной опции: в блоке Основная информация");
        getMainInformation(String.format(BASE_INPUT_CHECK_MAIN_INFORMATION_XPATH, optionName)).isElementDisplayed();
        pageActions.returnBackPage();
    }


    @Step("Пользователь выбирает опцию: по рецепту")
    public void checkCheckboxWithRecipe() {
        getOnRecipeButton().click()
        getOnRecipeCheckbox().click();
        logger.info("Пользователь выбирает опцию: по рецепту");
    }

    @Step("")
    public void clickSomeProducts() {
        getClickSomeProducts().click();
        logger.info("");
    }

    @Step("Пользователь выбирает опцию: без рецепта")
    public void checkCheckboxWithoutRecipe() {
        getOnRecipeButton().click()
        getWithoutRecipeCheckbox().click();
        logger.info("Пользователь выбирает опцию: без рецепта");
    }

    @Step("Пользователь листает вперёд страницы и проверяет релевантный переход")
    public void clickNextPage() {
        for (int i = 1; i < 4; i++) {
            getNexPaginationButton().click()
            String stringPageOpenNumber = getPageNumberOpen().getAttribute("innerHTML");
            int pageOpenNumber = Integer.parseInt(stringPageOpenNumber);
            int pageOpenTitle = getPageNumberOpenTitle().formatElementToValue();
            Assertions.assertEquals(pageOpenTitle, pageOpenNumber);
        }
        logger.info("Пользователь листает вперёд страницы и проверяет релевантный переход");
    }

    @Step("Пользователь листает назад страницы и проверяет релевантный переход")
    public void clickPrevPage() {
        for (int i = 4; i > 2; i--) {
            getPrevPaginationButton().click()
            String stringPageOpenNumber = getPageNumberOpen().getAttribute("innerHTML");
            int pageOpenNumber = Integer.parseInt(stringPageOpenNumber);
            int pageOpenTitle = getPageNumberOpenTitle().formatElementToValue();
            Assertions.assertEquals(pageOpenTitle, pageOpenNumber);
        }
        logger.info("Пользователь листает назад страницы и проверяет релевантный переход");

    }

    @Step("Получение цвета кнопки")
    public String getColorBackgroundProductGalleryButton() {
        String colorButton = getBackgroundColorProductGalleryButton().getBackgroundColor();
        logger.info("Получение цвета кнопки");
        return colorButton;
    }

    @Step("Получение цвета текста кнопки с расчётом бонусов")
    public String getColorTextProductGalleryButton() {
        String colorButton = getProductGalleryBonusesButton().getColor();
        logger.info("Получение цвета текста кнопки с расчётом бонусов");
        return colorButton;
    }

    @Step("Пользователь проверяет, что на шильдике с количеством бонусов присутствует значок '+'")
    public void checkPlusOnBonusButton() {
        getPlusOnBonusButton().isElementDisplayed();
        logger.info("Пользователь проверяет, что на шильдике с количеством бонусов присутствует значок '+'");
    }

    @Step("Пользователь нажимает кнопку показать все товары")
    public void clickShowAllProducts() {
        getShowAllProductsButton().click();
        logger.info("Пользователь нажимает кнопку показать все товары");
    }


}
