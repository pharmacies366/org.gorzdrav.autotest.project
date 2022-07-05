package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка шапки сайта Gorzdrav")
public class MobileHeaderBlockMobileTest extends BaseSettingsMobileTests {

    @Description("Проверка кликабельности логотипа")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Клик по логотипу должен вести на главную страницу")
    public void checkClickableLogo() {
        mobileHeaderBlock.clickSiteLogo();
        logger.info("Логотип кликабелен");
    }

    @Description("Проверка работы поиска")
    @Test(groups = {"Mobile", "Regression"})
    @Step("после ввода артикула товара должна открытся соответствующая станица с товаром")
    public void testingTheSearch() {
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.checkUrl("https://gorzdrav.org/search/?text=44226");
        logger.info("Поиск работает корректно");
    }

    @Description("Проверки работы корзины")
    @Test(groups = {"Mobile", "Regression"})
    @Step("проверка добавления товара в корзину и реливантный переход")
    public void testingTheCart() {
        mobileMainPage.AddToCartClick();
        pageActions.waitPageLoad();
        int quantity = mobileHeaderBlock.checkCartQuantity();
        Assert.assertEquals(1, quantity);
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        pageActions.contentIsDisplayed("Очистить все");
    }


}
