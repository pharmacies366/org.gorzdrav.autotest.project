package web.makeorder.unauthorized;

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

    @DisplayName("Неавторизованный пользователь покупает товар по дисконтной цене в 1клик")
    @Test
    public void discount() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
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
       // checkOutPage.clickBookingButton();
        // pageActions.waitPageLoad();
        // thankForTheOrderPage.checkSuccessMessage();
    }

}
