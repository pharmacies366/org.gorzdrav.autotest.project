package web.cft;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Михаил
 */

@Feature(value = "Web")
@DisplayName("ЦФТ на сайте Горздрав")
@Story("Проверка работы ЦФТ на странице с листингом товаров сайта Горздрав")
@Tag("Web")
@Tag("Regression")
@Tag("CFT")
public class CftOnListingPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов")
    @Description("Цвет заднего фона кнопки должен быть: #1560bd - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        String actualColor = commonActionsOnWebPages.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#1560bd", actualColor);
    }

    @DisplayName("Проверка фона текста кнопки с расчётом бонусов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        String actualColor = commonActionsOnWebPages.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка, что на шильдике с количеством бонусов присутствует значок '+'")
    @Description("На шильдике с бонусами должен присутствовать знак '+'")
    @Test
    public void checkInfoProductGalleryBonus() {
        mainPage.checkPlusOnBonusButton();
    }

    @DisplayName("Проверка на наличие начисляемых бонусов за покупку товара")
    @Description("Если цена товара больше или равно 50 р., то шильдик должен быть")
    @Test
    public void checkVisibilityBonuses() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        pageActions.waitPageLoad();
        commonActionsOnWebPages.getPriceText().isElementDisplayed();
        commonActionsOnWebPages.changePricesRangeWithHands("50", "1000");
        pageActions.waitPageLoad();
        int ToPriceRange = commonActionsOnWebPages.getToPriceRange();
        int FromPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int price = commonActionsOnWebPages.checkProductsPrices();
        Assertions.assertTrue(price >= FromPriceRange);
        Assertions.assertTrue(price <= ToPriceRange);
        commonActionsOnWebPages.getProductGalleryBonusesButton().isElementDisplayed();
    }
}
