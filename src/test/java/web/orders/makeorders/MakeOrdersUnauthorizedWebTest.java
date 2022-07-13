package web.orders.makeorders;


import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Web")
@Story("Оформление заказа на сайте Gorzdrav")
public class MakeOrdersUnauthorizedWebTest extends BaseSettingsWebTests {

  /*  @Description("Оформление заказа доставкой")
    @Test(groups = {"Web", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ с доставкой")
    public void delivery() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        checkOutPage.clickDeliveryMethod();
        pageActions.waitPageLoad();
        checkOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        pageActions.waitPageLoad();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
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
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickProductCard();
        pageActions.waitPageLoad();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddress("Москва");
        pageActions.waitPageLoad();
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
       // checkOutPage.clickBookingButton();
       // thankForTheOrderPage.checkSuccessMessage();
    }

      // так как локатор на добавление отличается индексом ждём задачу от разрабов
/*    @Description("Оформление заказа со страниц ОСП")
 @Test(groups = {"Web", "Smoke", "Regression"})
 @Step("Пользователь оформляет заказ со страниц ОСП")
    public void checkOsp() {
       // mainPage.ClickClosePopUpNewsButton();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        cartPage.clickAddCartButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
      //  checkOutPage.clickMakeOrder();
      //  thankForTheOrderPage.checkSuccessMessage();
    }*/



    @Description("Оформление заказа со способом получения - 'Самовывоз'")
    @Test(groups = {"Web", "Smoke", "Regression"})
    @Step("Пользователь покупает товар со способом получения - 'Самовывоз'")
    public void pickup() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.checkVisibilityMap();
        checkOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
      //  checkOutPage.clickMakeOrder();
      //  thankForTheOrderPage.checkSuccessMessage();
    }

    @Description("Оформление заказа, включающего в себя Партнерский и Не партнерский товары")
    @Test(groups = {"Web", "Smoke", "Regression"})
    @Step("Пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    public void split() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        pageActions.waitPageLoad();
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
