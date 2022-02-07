package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Оформление основного товара в 1 клик на сайте Gorzdrav")
@DisplayName("Оформление основного товара в 1 клик. Мобильная версия")
public class OneClickPurchaseTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickProductCard();
        pageActions.waitPageLoad();
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickLupaButton();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAptekaList();
        pageActions.waitPageLoad();
        mobileProductCardPage.oneClickAptekaButtons();
        pageActions.waitPageLoad();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickBookingButton();//на этом шаге иногда появляется капча
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }


}
