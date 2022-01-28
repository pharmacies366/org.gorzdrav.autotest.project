package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Оформление сплит заказа")
@DisplayName("Оформление сплит заказа")
public class SplitTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь оформил заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        cookiePage.cookieAuthorization();
        cartPage.checkCartQuantity();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        cartPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        cartPage.clickMakeOrder();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("username"));
        checkOutPage.clickCheckout();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
        cookiePage.deleteAllCookie();
    }
}
