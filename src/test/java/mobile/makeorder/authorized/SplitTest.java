package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Оформление сплит заказа. Мобильная версия")
@DisplayName("Оформление сплит заказа. Мобильная версия")
public class SplitTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCookiePage.cookieAuthorization();
        mobileCookiePage.reCaptchaKey();
        pageActions.reloadPage();
        mobileCartPage.checkCartQuantity();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickBuyButton();
        mobileCartPage.clickToCartButton();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        mobileCartPage.clickBuyButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.getAvailabilityAndChooseThisPharmacy();
        mobileCheckOutPage.getInputFio().click();//ещё один клик для того чтобы не перекрывалась кнопка "Оформить Заказ"
        mobileCheckOutPage.clickCheckout();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }

}
