package templateTestng.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class PageActions {
    public Logger logger = LogManager.getLogger();

    private WebDriver driver;


    public void initialize(WebDriver driver) {
        this.driver = driver;
    }

    private static PageElementActions instance;

    public PageActions() {
        // nothing to do this time
    }

    static {
        instance = new PageElementActions();
    }

    public static PageElementActions getInstance() {
        return instance;
    }

    //Методы


    //Переход по url
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Обновить страницу
    public void reloadPage() {
        logger.info("ПОЛЬЗОВАТЕЛЬ ОБНОВЛЯЕТ СТРАНИЦУ");
        driver.navigate().refresh();
        logger.info("СТРАНИЦА ОБНОВЛЕНА");
    }

    //
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    //Переключиться на другое окно
    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles())
            driver.switchTo().window(windowHandle);
    }

    //Возвращение на предыдущую страницу
    public void returnBackPage() {
        driver.navigate().back();
    }

    //Переключиться на iFrame по индексу
    public void switchToiFrame(int index) {
        driver.switchTo().frame(index);
    }

    //Переключиться на iFrame по title
    public void switchToiFrame(String titleName) {
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='" + titleName + "']")));
    }


    //Проверка url
    public void checkUrl(String url) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(url, actualUrl);
    }

    //Получить Title
    public String getTitle() {
        return driver.getTitle();
    }

    //Сравнить два текста
    public void assertEqualsTwoObject(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    //Проверка видимости текста на странице
    public void contentIsDisplayed(String text) {
        driver.findElement(By.xpath("//*[text()='" + text + "']")).isDisplayed();
    }

    //Статичное ожидание на странице
    public void staticWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Ожидание загрузки на странице Javascript
    public void waitPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebDriverWait jqWait = new WebDriverWait(driver, Duration.ofSeconds(25));

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) js.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        try {
            jqWait.until(jQueryLoad);
        } catch (org.openqa.selenium.TimeoutException ex) {
            //test
        }
        wait.until(jsLoad);
    }
}
