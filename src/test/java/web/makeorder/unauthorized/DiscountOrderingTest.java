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
        pageActions.waitPageLoad();
        mainPage.checkCatalogButton();
        pageActions.waitPageLoad();
        catalogPage.clickMedicationsButton();
        pageActions.waitPageLoad();
        medicationsPage.clickBuyCheaper();
        pageActions.waitPageLoad();
        medicationsPage.clickSomeProduct();
        int usuallyPrice= productCardPage.getPriceValue().formatElementToValue();
        productCardPage.getDiscountPriceButton().clickIndex(3);
        pageActions.waitPageLoad();
        productCardPage.getAptekaMap().elementIsVisibility();
        int discountPrice = productCardPage.getPriceValue().formatElementToValue();
        Assert.assertTrue(usuallyPrice > discountPrice);
        productCardPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        productCardPage.clickAptekaList();
        pageActions.waitPageLoad();
        productCardPage.buyOneClick();
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        pageActions.waitPageLoad();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        pageActions.waitPageLoad();
        checkOutPage.clickBookingButton();
       // pageActions.waitPageLoad();
        //thankForTheOrderPage.checkSuccessMessage();
    }

}
