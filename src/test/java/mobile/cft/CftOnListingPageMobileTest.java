package mobile.cft;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

/**
 * @author Михаил
 */

@Feature(value = "Мобильная версия")
@DisplayName("ЦФТ на сайте Горздрав")
@Story("Проверка работы ЦФТ на странице с листингом товаров сайта Горздрав")
@Tag("Regression")
@Tag("CFT")
@Tag("Mobile")
public class CftOnListingPageMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов")
    @Description("Цвет заднего фона кнопки должен быть: #1560bd - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        String actualColor = commonActionsOnMobilePages.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#1560bd", actualColor);
    }

    @DisplayName("Проверка фона текста кнопки с расчётом бонусов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        String actualColor = commonActionsOnMobilePages.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка, что на шильдике с количеством бонусов присутствует значок '+'")
    @Description("На шильдике с бонусами должен присутствовать знак '+'")
    @Test
    public void checkInfoProductGalleryBonus() {
        commonActionsOnMobilePages.checkPlusOnBonusButton();
    }


    @Disabled
    @DisplayName("Проверка на наличия начисляемых бонусов за покупку товара")
    @Description("Если цена товара больше или равно 50 р., то шильдик должен быть")
    @Test
    public void checkVisibilityBonuses() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.getCostButton().click();
        pageActions.waitPageLoad();
        commonActionsOnMobilePages.getPriceText().isElementDisplayed();
        commonActionsOnMobilePages.changePricesRangeWithHands("50", "1000");
        pageActions.reloadPage();
        commonActionsOnMobilePages.checkBonusesOnProducts();
     /*   pageActions.reloadPage();
        int price = commonActionsOnMobilePages.checkProductsPrices();*/
       // Assertions.assertTrue(price >= 50);
       // commonActionsOnMobilePages.getProductGalleryBonusesButton().isElementNotVisible();
    }
}
