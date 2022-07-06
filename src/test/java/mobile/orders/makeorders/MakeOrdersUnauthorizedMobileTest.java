package mobile.orders.makeorders;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story("Оформление заказа на сайте Gorzdrav для неавторизованного пользователя")
public class MakeOrdersUnauthorizedMobileTest extends BaseSettingsMobileTests {
/*    @Description("Оформление заказа доставкой")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ с доставкой")
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
    }*/


    // баг на шаге Списком
    @Description("Оформление заказа в один клик")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь покупает товар в 1клик")
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
    @Description("Оформление заказа со страниц ОСП")
 @Test(groups = {"Mobile", "Smoke", "Regression"})
 @Step("Пользователь оформляет заказ со страниц ОСП")
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


    @Description("Оформление заказа со способом получения - 'Самовывоз'")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь покупает товар со способом получения - 'Самовывоз'")
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

    @Description("Оформление заказа, включающего в себя Партнерский и Не партнерский товары")
    @Test(groups = {"Mobile", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    public void split() {
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
