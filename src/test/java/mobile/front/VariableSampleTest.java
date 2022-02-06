package mobile.front;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка суммы 2-х товаров в корзине")
@DisplayName("Проверка суммы 2-х товаров в корзине")
public class VariableSampleTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void test() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickToCartButton();
        int firstPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        mobileProductCardPage.clickToCartButton();
        int secondPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice,totalPrice);
    }
}