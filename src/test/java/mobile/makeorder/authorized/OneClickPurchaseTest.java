package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Оформление основного товара в 1 клик на сайте Gorzdrav")
@DisplayName("Оформление основного товара в 1 клик. Мобильная версия")
public class OneClickPurchaseTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithEmailAndPassword(
                propertiesManager.getProperty("mobileuserauthmail3"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileCartPage.checkCartQuantity();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickProductCard();
        mobileProductCardPage.buyOneClick();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        mobileProductCardPage.clickLupaButton();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.clickAptekaList();
        mobileProductCardPage.oneClickAptekaButtons();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        //  mobileCheckOutPage.clickBookingButton();
        //  mobileThankForTheOrderPage.checkSuccessMessage();
    }


}
