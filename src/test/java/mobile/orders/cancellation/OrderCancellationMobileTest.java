
package mobile.orders.cancellation;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
@Feature(value = "Мобильная версия")
@Story(value = "Отмена заказа на сайте Gorzdrav")
public class OrderCancellationMobileTest extends BaseSettingsMobileTests {

/*    @Description("Пользователь отмены созданного заказа")
    @Test(groups = {"Mobile", "Regression"})
    @Step("Пользователь отменяет созданный заказ")
    public void orderCancellation() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber6"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.reloadPage();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.clickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileCheckOutPage.closePopUpQuestion();
        mobileThankForTheOrderPage.checkSuccessMessage();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        pageActions.staticWait(3000);
        mobileMainPopUpBlock.clickMyOrders();
        mobileMyOrdersPage.clickOrderNumber();
        mobileMyOrdersPage.clickCancelNumber();
        Assert.assertEquals("Отменен", mobileMyOrdersPage.getOrderStatus());
    }*/
}

