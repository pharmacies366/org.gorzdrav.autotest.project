package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Пользователь покупает товар со страницы ОСП на сайте Gorzdrav")
@DisplayName("Оформление товара со страниц ОСП")
public class OspProductListTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mainPage.clickClosePopUp();
        topPanelPage.clickToLoginIcon();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithEmailAndPassword(
                propertiesManager.getProperty("userauthmail4"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        cartPage.checkCartQuantity();
        headerBlock.clickSiteLogo();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        ospPage.clickBuyButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
       // checkOutPage.clickPickUpButton();
        checkOutPage.sendAddressPickUp("метро Автозаводская");
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        //  checkOutPage.clickMakeOrder();
        //   thankForTheOrderPage.checkSuccessMessage();
    }
}
