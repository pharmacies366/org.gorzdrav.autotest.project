package web.makeorder.unauthorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Пользователь покупает товар со страницы ОСП на сайте Gorzdrav")
@DisplayName("Оформление товара со страниц ОСП")
public class OspProductListTest extends BaseSettingsWebTests {

    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        ospPage.clickBuyButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        cartPage.clickPickUpButton();
        productCardPage.setInputSearchAddres("метро Автозаводская");
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("username"));
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
    }
}
