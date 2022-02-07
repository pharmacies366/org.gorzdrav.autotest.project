package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Покупка дисконтного товара на сайте Gorzdrav")
@DisplayName("Оформление дисконтного товара в 1клик. Мобильная версия")
public class DiscountOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар по дисконтной цене в 1клик")
    @Test
    public void discount() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileTopPanelPage.clickBurgerButton();
        pageActions.waitPageLoad();
        mobileMainPage.checkCatalogButton();//изменить на mobileTopPanelPage
        pageActions.waitPageLoad();
        mobileCatalogPage.clickMedicationsButton();
        pageActions.waitPageLoad();
        mobileCatalogPage.allMedicationsPageButton();
        pageActions.waitPageLoad();
        mobileMedicationsPage.clickFilterButton();
        pageActions.waitPageLoad();
        mobileMedicationsPage.clickBuyCheaperButtons();
        pageActions.waitPageLoad();
        mobileMedicationsPage.clickDiscontProduct();
        pageActions.waitPageLoad();
        int usuallyPrice = mobileProductCardPage.getProductPrice();
        mobileProductCardPage.selectDiscountProduct();
        pageActions.waitPageLoad();
        int discountPrice = mobileProductCardPage.getProductPrice();
        Assert.assertTrue(usuallyPrice > discountPrice);
        logger.info("Выбран дисконтный товар");
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickLupaButton();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAptekaList();
        pageActions.waitPageLoad();
        mobileProductCardPage.oneClickAptekaButtons();
        pageActions.waitPageLoad();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        mobileCheckOutPage.clickBookingButton();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();

    }

}
