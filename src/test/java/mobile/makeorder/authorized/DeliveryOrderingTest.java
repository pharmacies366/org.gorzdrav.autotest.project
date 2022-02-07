package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Оформление заказа доставкой на сайте Gorzdrav")
@DisplayName("Оформление заказа доставкой. Мобильная версия")
public class DeliveryOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Оформление заказа доставкой. Авторизованный пользователь")
    @Test
    public void delivery() {
        mobileMainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCookiePage.cookieAuthorization();
        mobileCookiePage.reCaptchaKey();
        pageActions.reloadPage();
        pageActions.waitPageLoad();
        mobileCartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickBuyButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickDeliveryMethod();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickDataDetailButton();
        mobileCheckOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        pageActions.waitPageLoad();
        mobileCheckOutPage.getInputFio().click();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickToFinalButton();
        pageActions.waitPageLoad();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        pageActions.waitPageLoad();
        mobileSberPage.clickOnSubmitButton();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkPaymentError();
    }

}
