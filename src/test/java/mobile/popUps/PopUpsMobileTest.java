package mobile.popUps;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка попапов на сайте Горздрав")
public class PopUpsMobileTest extends BaseSettingsMobileTests {

    @Description("Проверка наличия и закрытия попапа с куки файлами")
    @Test(groups = {"Mobile", "Regression"})
    public void checkCookiesPopUp() {
        mobileMainPage.clickCloseMobileAppPopUp();
    }

    @Description("Проверка наличия и закрытия попапа для скачивания мобильного приложения")
    @Test(groups = {"Mobile", "Regression"})
    public void checkMobileAppPopUp() {
        mobileMainPage.clickCloseMobileAppPopUp();
    }
}
