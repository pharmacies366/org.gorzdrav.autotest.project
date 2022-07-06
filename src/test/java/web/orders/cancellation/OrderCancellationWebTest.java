package web.orders.cancellation;/*
package web.orders.cancellation;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;


@Feature(value = "Web")
@Story(value = "Отмена заказа на сайте Gorzdrav")
public class OrderCancellationWebTest extends BaseSettingsWebTests {

    @Description("Пользователь отмены созданного заказа")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь отменяет созданный заказ")
    public void orderCancellation() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber6"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
        pageActions.reloadPage();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickMyOrders();
        pageActions.staticWait(3000);
        pageActions.reloadPage();
        myOrdersPage.clickOrderNumber();
        myOrdersPage.clickCancelNumber();
        Assert.assertEquals("Отменен", myOrdersPage.getOrderStatus());
    }

}
*/
