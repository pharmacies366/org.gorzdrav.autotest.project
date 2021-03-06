package web.front;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story("Проверка суммы 2-х товаров в корзине на сайте Gorzdrav")
@DisplayName("Проверка суммы 2-х товаров в корзине")
public class VariableSampleTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void test() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        productCardPage.clickToCartButton();
        int firstPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        productCardPage.clickToCartButton();
        int secondPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }
}