package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Оформление основного товара в 1 клик. Мобильная версия")
@DisplayName("Оформление основного товара в 1 клик. Мобильная версия")
public class OneClickPurchaseTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickProductCard();
        mobileProductCardPage.buyOneClick();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        mobileProductCardPage.clickLupaButton();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.clickAptekaList();
        pageActions.waitPageLoad();
        mobileProductCardPage.oneClickAptekaButtons();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        mobileCheckOutPage.clickBookingButton();//на этом шаге иногда появляется капча
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }


}
