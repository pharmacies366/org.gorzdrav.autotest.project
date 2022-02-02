package base;

import actions.PageElementActions;
import core.MainTestBase;
import org.junit.Before;
import pages.mobile.*;

public class BaseSettingsMobileTests extends MainTestBase {


    protected PageElementActions pageElementActions;
    protected MobileTopPanelPage mobileTopPanelPage;
    protected MobileAuthPopUpPage mobileAuthPopUpPage;
    protected MobileCartPage mobileCartPage;
    protected MobileCheckOutPage mobileCheckOutPage;
    protected MobileProductCardPage mobileProductCardPage;
    protected MobileMainPage mobileMainPage;
    protected MobileOspPage mobileOspPage;
    protected MobileSberPage mobileSberPage;
    protected MobileThankForTheOrderPage mobileThankForTheOrderPage;
    protected MobileCookiePage mobileCookiePage;
    protected MobileCatalogPage mobileCatalogPage;
    protected MobileMedicationsPage mobileMedicationsPage;


    @Before
    public void PagesInitialization() {
        pageElementActions = new PageElementActions(driver);
        mobileTopPanelPage = new MobileTopPanelPage(driver);
        mobileCheckOutPage = new MobileCheckOutPage(driver);
        mobileCartPage = new MobileCartPage(driver);
        mobileAuthPopUpPage = new MobileAuthPopUpPage(driver);
        mobileProductCardPage = new MobileProductCardPage(driver);
        mobileMainPage = new MobileMainPage(driver);
        mobileOspPage = new MobileOspPage(driver);
        mobileSberPage = new MobileSberPage(driver);
        mobileCookiePage = new MobileCookiePage(driver);
        mobileThankForTheOrderPage = new MobileThankForTheOrderPage(driver);
        mobileCatalogPage = new MobileCatalogPage(driver);
        mobileMedicationsPage = new MobileMedicationsPage(driver);
    }

}