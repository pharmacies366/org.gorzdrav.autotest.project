package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story("Покупка дисконтного товара на сайте Gorzdrav")
@DisplayName("Оформление дисконтного товара в 1клик")
public class DiscountOrderingTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь покупает товар по дисконтной цене в 1клик")
    @Test
    public void discount() {
        mainPage.clickClosePopUp();
        topPanelPage.clickToLoginIcon();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithEmailAndPassword(
                propertiesManager.getProperty("userauthmail2"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkCartQuantity();
        mainPage.checkCatalogButton();
        catalogPage.clickMedicationsButton();
        medicationsPage.clickBuyCheaper();
        medicationsPage.clickSomeProduct();
        int usuallyPrice= productCardPage.getPriceValue().formatElementToValue();
        productCardPage.getDiscountPriceButton().clickIndex(3);
        productCardPage.getAptekaMap().elementIsVisibility();
        int discountPrice = productCardPage.getPriceValue().formatElementToValue();
        Assert.assertTrue(usuallyPrice > discountPrice);
        productCardPage.setInputSearchAddres("метро Автозаводская");
        productCardPage.clickAptekaList();
        productCardPage.buyOneClick();
        productCardPage.clickBuyOneClick();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        // cookiePage.reCaptchaKey();
        //  checkOutPage.clickBookingButton();
        //   thankForTheOrderPage.checkSuccessMessage();

    }

}
