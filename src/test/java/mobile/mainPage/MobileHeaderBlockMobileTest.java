package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка шапки сайта gorzdrav")
@DisplayName("Проверка шапки сайта")
public class MobileHeaderBlockMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogo(){
        mobileHeaderBlock.clickSiteLogo();
        logger.info("Логотип кликабелен");
    }

    @DisplayName("Проверка работы поиска")
    @Test
    public void testingTheSearch(){
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.checkUrl("https://gorzdrav.org/search/?text=44226");
        logger.info("Поиск работает корректно");
    }

    @DisplayName("Проверка корекного перехода к любимым аптекам")
    @Test
    public void checkClickableFavoritesPharmacies(){
        mobileHeaderBlock.clickFavoritesPharmacies();
        mobileFavoritesPharmaciesPage.checkNamePage();
        logger.info("Переход на страницу Любимые аптеки выполнен корректно");
    }

    @DisplayName("Проверки работы корзины")
    @Test
    public void testingTheCart(){
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.clickAddToCardButton();
        pageActions .waitPageLoad();
        int quantity = mobileHeaderBlock.checkCartQuantity();
        Assert.assertEquals(1, quantity);
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        pageActions.contentIsDisplayed("Корзина");
        logger.info("Проверки прошли успешно");
    }

    @DisplayName("Проверка работы кнопки попапа главной панели")
    @Test
    public void checkBurgerPopUp(){
        mobileHeaderBlock.clickBurgerButton();
        pageActions.contentIsDisplayed("Войти");
    }

}
