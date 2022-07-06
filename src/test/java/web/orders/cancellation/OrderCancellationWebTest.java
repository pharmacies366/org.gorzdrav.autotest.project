package web.orders.cancellation;/*
package web.orders.cancellation;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story(value = "Отмена заказа на сайте Gorzdrav")
@DisplayName("Отмена созданного заказа")
@Tag("Web")
@Tag("Regression")
public class OrderCancellationWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь отменяет созданный заказ")
    @Test
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
        Assertions.assertEquals("Отменен", myOrdersPage.getOrderStatus());
    }

}
*/
