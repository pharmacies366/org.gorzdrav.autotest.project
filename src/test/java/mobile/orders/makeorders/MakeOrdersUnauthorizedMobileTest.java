package mobile.orders.makeorders;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story("Оформление заказа на сайте Gorzdrav")
@DisplayName("Оформление заказа для неавторизованного пользователя")
@Tag("Mobile")
@Tag("Regression")
@Tag("Smoke")
public class MakeOrdersUnauthorizedMobileTest extends BaseSettingsMobileTests {
    @DisplayName("Оформление заказа доставкой. Неавторизованный пользователь")
    @Test
    public void delivery() {
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        mobileCheckOutPage.clickDeliveryMethod();
        mobileCheckOutPage.clickCheckDeliveryDetails();
        mobileCheckOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
      //  mobileSberPage.clickOnSubmitButton();
      //  mobileThankForTheOrderPage.checkPaymentError();
    }


    // баг на шаге Списком
    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        mobileCartPage.clickProductCard();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        pageActions.waitPageLoad();
        mobileProductCardPage.setInputSearchAddress("метро Фили");
        pageActions.waitPageLoad();
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickChangeAptekaList();
        mobileProductCardPage.clickBuyOneClick();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
       // mobileCheckOutPage.clickBookingButton();
       // mobileThankForTheOrderPage.checkSuccessMessage();
    }


/*
    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        pageActions.reloadPage();
        pageActions.waitPageLoad();
        mobileMainPage.clickLetterN();
        pageActions.waitPageLoad();
        mobileOspPage.clickShowAll();
        mobileOspPage.clickProductName();
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.setInputSearchAddres("метро Автозаводская");//возможно нужно кликнуть в пустое место
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
      //  mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }
*/


    @DisplayName("Неавторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.reloadPage();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        //mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.clickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
     //   mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        mobileMainPage.clickSiteLogo();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode2"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
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
