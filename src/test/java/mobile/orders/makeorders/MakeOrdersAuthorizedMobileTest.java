package mobile.orders.makeorders;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story("Оформление заказа на сайте Gorzdrav для авторизованного пользователя")
public class MakeOrdersAuthorizedMobileTest extends BaseSettingsMobileTests {
/*    @Description("Оформление заказа доставкой")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ с доставкой")
    public void delivery() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber1"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        mobileMainPage.clickSiteLogo();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickDeliveryMethod();
        mobileCheckOutPage.clickCheckDeliveryDetails();
        mobileCheckOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        //  mobileSberPage.clickOnSubmitButton();
        //  mobileThankForTheOrderPage.checkPaymentError();
    }*/


    @Description("Оформление заказа в один клик")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь покупает товар в 1клик")
    public void oneClick() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber2"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        mobileCartPage.clickProductCard();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.setInputSearchAddress("метро Фили");
        pageActions.waitPageLoad();
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickChangeAptekaList();
        mobileProductCardPage.clickBuyOneClick();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        mobileCookiePage.reCaptchaKey();
        //  mobileCheckOutPage.clickBookingButton();
        //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

/*    @Description("Оформление заказа со страниц ОСП")
 @Test(groups = {"Mobile", "Smoke", "Regression"})
 @Step("Пользователь оформляет заказ со страниц ОСП")
    public void checkOsp() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber3"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.waitPageLoad();
        mobileMainPage.clickSiteLogo();
        pageActions.waitPageLoad();
        mobileMainPage.clickLetterN();
        pageActions.waitPageLoad();
        mobileOspPage.clickShowAll();
        pageActions.waitPageLoad();
        mobileOspPage.clickProductName();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
       // mobileCheckOutPage.clickSelectApteka();
        mobileCheckOutPage.setInputSearchAddres("Москва");
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.clickSelect();
        //  mobileCheckOutPage.clickMakeOrder();
        //  mobileThankForTheOrderPage.checkSuccessMessage();
    }*/

    @Description("Оформление заказа со способом получения - 'Самовывоз'")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь покупает товар со способом получения - 'Самовывоз'")
    public void pickup() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber4"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.reloadPage();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        // mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.clickSelect();
        //pageActions.waitPageLoad();
        // mobileCheckOutPage.clickMakeOrder();
        //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @Description("Оформление заказа, включающего в себя Партнерский и Не партнерский товары")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    public void split() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber5"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.waitPageLoad();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        mobileMainPage.clickSiteLogo();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode2"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        // mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        pageActions.waitPageLoad();
        mobileCheckOutPage.setInputSearchAddres("Москва");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        //   mobileCheckOutPage.clickMakeOrder();
        //  mobileThankForTheOrderPage.checkSuccessMessage();
    }
}

