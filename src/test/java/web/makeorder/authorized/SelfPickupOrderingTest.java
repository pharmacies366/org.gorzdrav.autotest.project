package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "оформление заказа самовывозом")
@DisplayName("Оформление заказа самовывозом")
public class SelfPickupOrderingTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        mainPage.clickClosePopUp();
        cookiePage.cookieAuthorization();
        cookiePage.reCaptchaKey();
        pageActions.reloadPage();
        cartPage.checkCartQuantity();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickBuyButton();
        cartPage.clickToCartButton();
        cartPage.clickMakeOrder();
        checkOutPage.getPharmacyAddressInput().sendKeys("метро Фили");
        productCardPage.checkVisibilityMap();
        productCardPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickCheckout();
        thankForTheOrderPage.checkSuccessMessage();
    }

}
