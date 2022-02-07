package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Оформление сплит заказа на сайте Gorzdrav")
@DisplayName("Оформление сплит заказа. Мобильная версия")
public class SplitTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    //Данный тест ещё дублирует проверку на недоступность одного из товаров в корзине
    public void split() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickBuyButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        mobileCartPage.clickBuyButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        mobileCheckOutPage.getAvailabilityAndChooseThisPharmacy();
        pageActions.waitPageLoad();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("username"));
        pageActions.waitPageLoad();
        mobileCheckOutPage.getInputFio().click();//ещё один клик для того чтобы не перекрывалась кнопка "Оформить Заказ"
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickCheckout();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }

}
