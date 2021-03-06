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
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileMainPage.checkCatalogButton();//изменить на mobileTopPanelPage
        mobileCatalogPage.clickMedicationsButton();
        mobileCatalogPage.allMedicationsPageButton();
        mobileMedicationsPage.clickFilterButton();
        mobileMedicationsPage.clickBuyCheaperButtons();
        mobileMedicationsPage.clickDiscontProduct();
        int usuallyPrice = mobileProductCardPage.getProductPrice();
        mobileProductCardPage.selectDiscountProduct();
        int discountPrice = mobileProductCardPage.getProductPrice();
        Assert.assertTrue(usuallyPrice > discountPrice);
        logger.info("Выбран дисконтный товар");
        pageActions.waitPageLoad();
        mobileProductCardPage.buyOneClick();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        mobileProductCardPage.clickLupaButton();
        mobileProductCardPage.checkVisibilityMap();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAptekaList();
        mobileProductCardPage.oneClickAptekaButtons();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        //   mobileCheckOutPage.clickBookingButton();//на этом шаге иногда появляется капча
        //   mobileThankForTheOrderPage.checkSuccessMessage();

    }

}
