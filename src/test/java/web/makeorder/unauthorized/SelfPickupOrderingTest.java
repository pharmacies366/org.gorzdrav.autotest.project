package web.makeorder.unauthorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "оформление заказа самовывозом")
@DisplayName("Оформление заказа самовывозом")
public class SelfPickupOrderingTest extends BaseSettingsWebTests {

    @DisplayName("Неавторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        cartPage.clickMakeOrder();
        checkOutPage.getPharmacyAddressInput().sendKeys("метро Фили");
        productCardPage.checkVisibilityMap();
        pageActions.waitPageLoad();
        productCardPage.clickChangeAptekaList();
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
