package web.makeorder.unauthorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Покупка в 1 клик")
@DisplayName("Оформление основного товара в 1 клик")
public class OneClickPurchaseTest extends BaseSettingsWebTests {

    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickProductCard();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddres("метро Фили");
        productCardPage.getEmptyPlace().click();//делаем клик в пустое место, так как иначе на дальнейшем шаге идёт бесконечная загрузка лоудера
        productCardPage.clickBuyOneClick();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        checkOutPage.clickBookingButton();//на этом шаге иногда появляется капча
        cookiePage.reCaptchaKey();
        thankForTheOrderPage.checkSuccessMessage();

    }


}
