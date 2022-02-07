package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Пользователь покупает товар со страницы ОСП на сайте Gorzdrav")
@DisplayName("Оформление товара со страниц ОСП. Мобильная версия")
public class OspProductListTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickLetterN();
        pageActions.waitPageLoad();
        mobileOspPage.clickShowAll();
        pageActions.waitPageLoad();
        mobileOspPage.clickProductName();
        pageActions.waitPageLoad();
        mobileOspPage.clickBuyButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileCartPage.clickPickUpButton();
        pageActions.waitPageLoad();
        mobileCheckOutPage.setInputSearchAddres("метро Автозаводская");
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
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();

    }
}
