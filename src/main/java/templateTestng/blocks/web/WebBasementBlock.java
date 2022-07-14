package templateTestng.blocks.web;

import io.qameta.allure.Step;
import templateTestng.actions.PageElementActions;
import templateTestng.driver.DriverManager;

public class WebBasementBlock {

    //элементы
    private static final String BASE_INPUT_XPATH = "xpath;//div[@class='c-block-view-ch__content']//child::a[@href='%s']";

    public PageElementActions webBasementBlock(){
        return PageElementActions.getInstance();
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getBaseInputBasementLocators(String xpath){
        PageElementActions.getInstance().initialize(xpath, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }
    public PageElementActions getBaseInputBasementLinks(String xpath){
        PageElementActions.getInstance().initialize(xpath, DriverManager.getDriver());
        return PageElementActions.getInstance();
    }


    //Методы

    @Step("Кликает по локатору {LOCATOR}")
    public void selectBasementButtons(String LOCATOR) {
        getBaseInputBasementLocators(String.format(BASE_INPUT_XPATH, LOCATOR)).click();
    }

    @Step("Проверка видимости и названия ссылки => {LINK_TEXT}")
    public void checkLinksValidation(String LOCATOR, String LINK_TEXT) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_XPATH, LOCATOR)).contentIsDisplayed(LINK_TEXT);
    }

}
