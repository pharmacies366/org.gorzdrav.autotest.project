/*
package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Пользователь покупает товар со страницы ОСП")
@DisplayName("Оформление товара со страниц ОСП")
public class OspProductListTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mainPage.clickClosePopUp();
        cookiePage.cookieAuthorization();
        cookiePage.reCaptchaKey();
        pageActions.reloadPage();
        cartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mainPage.clickSiteLogo();
        pageActions.waitPageLoad();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        ospPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        productCardPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        pageActions.waitPageLoad();
        checkOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
    }
}
*/
