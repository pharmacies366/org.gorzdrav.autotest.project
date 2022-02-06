package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Покупка дисконтного товар. Мобильная версия")
@DisplayName("Оформление дисконтного товара в 1клик. Мобильная версия")
public class DiscountOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизованный пользователь покупает товар по дисконтной цене в 1клик")
    @Test
    public void discount() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCookiePage.cookieAuthorization();
        mobileCookiePage.reCaptchaKey();
        pageActions.reloadPage();
        mobileCartPage.checkCartQuantity();
        mobileTopPanelPage.clickBurgerButton();
        mobileMainPage.checkCatalogButton();//изменить на mobileTopPanelPage
        mobileCatalogPage.clickMedicationsButton();
        mobileCatalogPage.allMedicationsPageButton();
        mobileMedicationsPage.clickFilterButton();
        mobileMedicationsPage.clickBuyCheaperButtons();
        mobileMedicationsPage.clickDiscontProduct();
        int usuallyPrice = mobileProductCardPage.getProductPrice();
        int discountPrice = mobileProductCardPage.getProductPrice();
        Assert.assertTrue(usuallyPrice > discountPrice);
        logger.info("Выбран дисконтный товар");
        mobileProductCardPage.buyOneClick();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.setInputSearchAddres("метро Автозаводская");
        mobileProductCardPage.clickLupaButton();
        mobileProductCardPage.clickAptekaList();
        mobileProductCardPage.oneClickAptekaButtons();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        mobileCheckOutPage.clickBookingButton();
        mobileThankForTheOrderPage.checkSuccessMessage();

    }

}
