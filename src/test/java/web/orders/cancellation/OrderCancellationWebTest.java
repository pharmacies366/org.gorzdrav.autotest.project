package web.orders.cancellation;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;


@Feature(value = "Web")
@Story(value = "Отмена заказа на сайте Gorzdrav")
@DisplayName("Отмена созданного заказа")
@Tag("Regression")
public class OrderCancellationWebTest extends BaseSettingsWebTests {

/*    @DisplayName("Пользователь отменяет созданный заказ")
    @Test
    public void orderCancellation() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber6"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.сlickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        checkOutPage.setInputSearchAddres("метро Фили");
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
        pageActions.reloadPage();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickMyOrders();
        pageActions.staticWait(5000);
        pageActions.reloadPage();
        myOrdersPage.clickOrderNumber();
        myOrdersPage.clickCancelNumber();
        Assert.assertEquals("Отменен", myOrdersPage.getOrderStatus());
    }*/

}
