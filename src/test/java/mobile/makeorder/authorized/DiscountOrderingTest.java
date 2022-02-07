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
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCookiePage.cookieAuthorization();
        mobileCookiePage.reCaptchaKey();
        pageActions.reloadPage();
        pageActions.waitPageLoad();
        mobileCartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mobileTopPanelPage.clickBurgerButton();
        pageActions.waitPageLoad();
        mobileMainPage.checkCatalogButton();//изменить на mobileTopPanelPage
        mobileCatalogPage.clickMedicationsButton();
        pageActions.waitPageLoad();
        mobileCatalogPage.allMedicationsPageButton();
        pageActions.waitPageLoad();
        mobileMedicationsPage.clickFilterButton();
        pageActions.waitPageLoad();
        mobileMedicationsPage.clickBuyCheaperButtons();
        pageActions.waitPageLoad();
        mobileMedicationsPage.clickDiscontProduct();
        int usuallyPrice = mobileProductCardPage.getProductPrice();
        pageActions.waitPageLoad();
        int discountPrice = mobileProductCardPage.getProductPrice();
        pageActions.waitPageLoad();
        Assert.assertTrue(usuallyPrice > discountPrice);
        pageActions.waitPageLoad();
        logger.info("Выбран дисконтный товар");
        pageActions.waitPageLoad();
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
