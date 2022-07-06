package web.cft;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Михаил
 */

@Feature(value = "Web")
@Story("Проверка работы ЦФТ на странице с листингом товаров сайта Горздрав")
public class CftOnListingPageWebTest extends BaseSettingsWebTests {

    @Description("Проверка заднего фона кнопки с расчётом бонусов")
    @Test(groups = { "Web", "Regression", "CFT" })
    @Step("Цвет заднего фона кнопки должен быть: #1560bd - Синий")
    public void checkBackgroundColorProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        String actualColor = commonActionsOnWebPages.getColorBackgroundProductGalleryButton();
        Assert.assertEquals("#1560bd", actualColor);
    }

    @Description("Проверка фона текста кнопки с расчётом бонусов")
    @Test(groups = { "Web", "Regression", "CFT" })
    @Step("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    public void checkColorTextProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        String actualColor = commonActionsOnWebPages.getColorTextProductGalleryButton();
        Assert.assertEquals("#ffffff", actualColor);
    }

    @Description("Проверка, что на шильдике с количеством бонусов присутствует значок '+'")
    @Test(groups = { "Web", "Regression", "CFT" })
    @Step("На шильдике с бонусами должен присутствовать знак '+'")
    public void checkInfoProductGalleryBonus() {
        mainPage.checkPlusOnBonusButton();
    }

    @Description("Проверка на наличие начисляемых бонусов за покупку товара")
    @Test(groups = { "Web", "Regression", "CFT" })
    @Step("Если цена товара больше или равно 50 р., то шильдик должен быть")
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
        Assert.assertTrue(price >= FromPriceRange);
        Assert.assertTrue(price <= ToPriceRange);
        commonActionsOnWebPages.getProductGalleryBonusesButton().isElementDisplayed();
    }
}
