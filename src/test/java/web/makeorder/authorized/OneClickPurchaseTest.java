package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Покупка в 1 клик")
@DisplayName("Оформление основного товара в 1 клик")
public class OneClickPurchaseTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.authorizeWithEmailAndPassword(
                propertiesManager.getProperty("userauthmail1"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickProductCard();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        productCardPage.getEmptyPlace().click();//делаем клик в пустое место, так как иначе на дальнейшем шаге идёт бесконечная загрузка лоудера
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        pageActions.waitPageLoad();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        checkOutPage.clickBookingButton();//на этом шаге иногда появляется капча
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
    }

}
