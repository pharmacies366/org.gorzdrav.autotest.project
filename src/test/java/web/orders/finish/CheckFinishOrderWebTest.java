package web.orders.finish;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature(value = "Web")
@Story(value = "Проверка создания заказа на сайте Gorzdrav")
public class CheckFinishOrderWebTest extends BaseSettingsWebTests {
    @Description("Проверка информации по заказу")
    @Test(groups = {"Web", "Regression"})
    @Step("Пользователь проверяет информацию по заказу: Адрес аптеки, код заказа")
    public void OrderCancellation() {
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
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
       // checkOutPage.clickMakeOrder();
       // thankForTheOrderPage.checkSuccessMessage();
      //  thankForTheOrderPage.checkOrderNumberWithAddress();

    }
}
