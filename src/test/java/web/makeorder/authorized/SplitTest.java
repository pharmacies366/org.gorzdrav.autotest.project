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
        topPanelPage.clickToLoginIcon();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithEmailAndPassword(
                propertiesManager.getProperty("userauthmail6"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        cartPage.checkCartQuantity();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickBuyButton();
        cartPage.clickToCartButton();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        cartPage.clickBuyButton();
        cartPage.clickToCartButton();
        cartPage.clickMakeOrder();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        //  checkOutPage.clickCheckout();
        //  thankForTheOrderPage.checkSuccessMessage();
    }
}
