package mobile.makeorder.unauthorized;
//Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами


/*
package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Оформление заказа доставкой на сайте Gorzdrav")
@DisplayName("Оформление заказа доставкой. Мобильная версия")
public class DeliveryOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Оформление заказа доставкой. Неавторизованный пользователь")
    @Test
    public void delivery() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickBuyButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickDeliveryMethod();
        mobileCheckOutPage.clickDataDetailButton();
        mobileCheckOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("username"));
        mobileCheckOutPage.getInputFio().click();
        mobileCheckOutPage.clickToFinalButton();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        mobileSberPage.clickOnSubmitButton();
        mobileThankForTheOrderPage.checkPaymentError();
    }

}

*/
