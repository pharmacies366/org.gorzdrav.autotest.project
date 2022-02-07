package web.makeorder.unauthorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Пользователь покупает товар со страницы ОСП")
@DisplayName("Оформление товара со страниц ОСП")
public class OspProductListTest extends BaseSettingsWebTests {

    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mainPage.clickLetterN();
        pageActions.waitPageLoad();
        ospPage.clickProductName();
        pageActions.waitPageLoad();
        ospPage.clickBuyButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        cartPage.clickPickUpButton();
        productCardPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("username"));
        pageActions.waitPageLoad();
        checkOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
    }
}
