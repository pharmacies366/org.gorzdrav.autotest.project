package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Покупка товара в 1 клик на сайте Gorzdrav")
@DisplayName("Оформление основного товара в 1 клик")
public class OneClickPurchaseTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mainPage.clickClosePopUp();
        topPanelPage.clickToLoginIcon();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithEmailAndPassword(
                propertiesManager.getProperty("userauthmail3"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkCartQuantity();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode4"));
        cartPage.clickProductCard();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddres("Москва");
        productCardPage.scaleDownMap();
        productCardPage.scaleDownMap();
        productCardPage.clickBuyOneClick();
        pageActions.waitPageLoad();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        //  cookiePage.reCaptchaKey();
        //  checkOutPage.clickBookingButton();
        //   thankForTheOrderPage.checkSuccessMessage();
    }

}
