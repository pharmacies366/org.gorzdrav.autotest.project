package web.monitoring;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Web")
@Story("Мониторинг доступности сайта Gorzdrav")
@DisplayName("Мониторинг сайта Gorzdrav")
@Tag("monitoring")
public class SignInPositiveWebTest extends BaseSettingsWebTests {

    @DisplayName("Мониторинг доступности сайта https://gorzdrav.org/")
    @Description("Открывается главная страница сайта и на ней проверяется наличие текста: Интернет-аптека Горздрав")
    @Test
    public void checkUiWebTestSiteGorzdrav() {
        pageActions.contentIsDisplayed("Интернет-аптека Горздрав");
    }
}
