package mobile.cft;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка работы ЦФТ на странице с листингом товаров сайта Горздрав")
public class CftOnListingPageMobileTest extends BaseSettingsMobileTests {

    @Description("Проверка заднего фона кнопки с расчётом бонусов")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("Цвет заднего фона кнопки должен быть: #1560bd - Синий")
    public void checkBackgroundColorProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        String actualColor = commonActionsOnMobilePages.getColorBackgroundProductGalleryButton();
        Assert.assertEquals("#1560bd", actualColor);
    }

    @Description("Проверка фона текста кнопки с расчётом бонусов")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    public void checkColorTextProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        String actualColor = commonActionsOnMobilePages.getColorTextProductGalleryButton();
        Assert.assertEquals("#ffffff", actualColor);
    }
    @Description("Проверка, что на шильдике с количеством бонусов присутствует значок '+'")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("На шильдике с бонусами должен присутствовать знак '+'")
    public void checkInfoProductGalleryBonus() {
        commonActionsOnMobilePages.checkPlusOnBonusButton();
    }

    @Description("Проверка на наличия начисляемых бонусов за покупку товара")
    @Test(groups = { "Mobile", "Regression", "CFT" })
    @Step("Если цена товара больше или равно 50 р., то шильдик должен быть")
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
