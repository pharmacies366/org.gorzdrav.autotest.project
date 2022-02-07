package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Оформление сплит заказа на сайте Gorzdrav")
@DisplayName("Оформление сплит заказа")
public class SplitTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь оформил заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        mainPage.clickClosePopUp();
        cookiePage.cookieAuthorization();
        cookiePage.reCaptchaKey();
        pageActions.reloadPage();
        cartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        pageActions.waitPageLoad();
        cartPage.clickBuyButton();
        cartPage.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickMakeOrder();
        checkOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        pageActions.waitPageLoad();
        checkOutPage.clickCheckout();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
    }
}
