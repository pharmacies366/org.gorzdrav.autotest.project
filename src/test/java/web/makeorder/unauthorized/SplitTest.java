package web.makeorder.unauthorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Оформление сплит заказа на сайте Gorzdrav")
@DisplayName("Оформление сплит заказа")
public class SplitTest extends BaseSettingsWebTests {

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        cartPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickMakeOrder();
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        pageActions.waitPageLoad();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("username"));
        pageActions.waitPageLoad();
        checkOutPage.clickCheckout();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
    }



}
