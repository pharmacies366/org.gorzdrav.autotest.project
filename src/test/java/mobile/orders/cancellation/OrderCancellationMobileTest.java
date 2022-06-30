package mobile.orders.cancellation;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Отмена заказа на сайте Gorzdrav")
@DisplayName("Отмена созданного заказа")
@Tag("Mobile")
@Tag("Regression")
public class OrderCancellationMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь отменяет созданный заказ")
    @Test
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
        Assertions.assertEquals("Отменен", mobileMyOrdersPage.getOrderStatus());
    }
}

