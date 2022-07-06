package web.orders.makeorders;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature(value = "Web")
@Story("Оформление заказа на сайте Gorzdrav")
public class MakeOrdersAuthorizedWebTest extends BaseSettingsWebTests {

/*   @Description("Оформление заказа доставкой")
    @Test(groups = {"Web", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ с доставкой")
    public void delivery() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber1"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickDeliveryMethod();
        checkOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        pageActions.waitPageLoad();
        checkOutPage.clickToFinalButton();
        pageActions.waitPageLoad();
        sberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        // sberPage.clickOnSubmitButton();
        // thankForTheOrderPage.checkPaymentError();
    }*/

    @Description("Оформление заказа в один клик")
    @Test(groups = {"Web", "Smoke", "Regression"})
    @Step("Пользователь покупает товар в 1клик")
    public void oneClick() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber2"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickProductCard();
        pageActions.waitPageLoad();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddress("Фили");
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        cookiePage.reCaptchaKey();
        // checkOutPage.clickBookingButton();
        // thankForTheOrderPage.checkSuccessMessage();
    }

  /*  @Description("Оформление заказа со страниц ОСП")
 @Test(groups = {"Web", "Smoke", "Regression"})
 @Step("Пользователь оформляет заказ со страниц ОСП")
    public void checkOsp() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber3"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        pageActions.waitPageLoad();
        headerBlock.clickSiteLogo();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
       // checkOutPage.clickSelectApteka();
        productCardPage.setInputSearchAddress("метро Автозаводская");
        checkOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        // checkOutPage.clickMakeOrder();
        // thankForTheOrderPage.checkSuccessMessage();
    }*/

    @Description("Оформление заказа со способом получения - 'Самовывоз'")
    @Test(groups = {"Web", "Smoke", "Regression"})
    @Step("Пользователь покупает товар со способом получения - 'Самовывоз'")
    public void pickup() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber4"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
       // checkOutPage.clickSelectApteka();
        checkOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        //checkOutPage.clickMakeOrder();
    }

    @Description("Оформление заказа, включающего в себя Партнерский и Не партнерский товары")
    @Test(groups = {"Web", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    public void split() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber5"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.clickSiteLogo();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        pageActions.waitPageLoad();
        pageActions.reloadPage();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode2"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        //  checkOutPage.clickMakeOrder();
        //  thankForTheOrderPage.checkSuccessMessage();
    }
}
