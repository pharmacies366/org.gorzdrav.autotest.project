package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Пользователь покупает товар со страницы ОСП. Мобильная версия")
@DisplayName("Оформление товара со страниц ОСП. Мобильная версия")
public class OspProductListTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCookiePage.cookieAuthorization();
        mobileCookiePage.reCaptchaKey();
        pageActions.reloadPage();
        mobileCartPage.checkCartQuantity();
        mobileMainPage.clickSiteLogo();
        mobileMainPage.clickLetterN();
        mobileOspPage.clickShowAll();
        mobileOspPage.clickProductName();
        mobileOspPage.clickBuyButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCartPage.clickPickUpButton();
        mobileCheckOutPage.setInputSearchAddres("метро Автозаводская");
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.getAvailabilityAndChooseThisPharmacy();
        mobileCheckOutPage.getInputFio().click();//ещё один клик для того чтобы не перекрывалась кнопка "Оформить Заказ"
        mobileCheckOutPage.clickMakeOrder();
        mobileThankForTheOrderPage.checkSuccessMessage();

    }
}
