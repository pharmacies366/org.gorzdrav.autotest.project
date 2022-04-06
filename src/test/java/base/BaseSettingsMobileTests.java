package base;

import actions.PageElementActions;
import blocks.mobile.MobileBasementBlock;
import blocks.mobile.MobileHeaderBlock;
import blocks.mobile.MobileMainPopUpBlock;
import core.MainTestBase;
import org.junit.Before;
import pages.commonActions.mobile.CommonActionsOnMobilePages;
import pages.mobile.*;


public class BaseSettingsMobileTests extends MainTestBase {


    protected CommonActionsOnMobilePages commonActionsOnMobilePages;
    protected PageElementActions pageElementActions;
    protected MobileTopPanelPage mobileTopPanelPage;
    protected MobileAuthPopUpPage mobileAuthPopUpPage;
    protected MobileCartPage mobileCartPage;
    protected MobileCheckOutPage mobileCheckOutPage;
    protected MobileProductCardPage mobileProductCardPage;
    protected MobileMainPage mobileMainPage;
    protected MobileCatalogPage mobileCatalogPage;
    protected MobileOspPage mobileOspPage;
    protected MobileSberPage mobileSberPage;
    protected MobileThankForTheOrderPage mobileThankForTheOrderPage;
    protected MobileCookiePage mobileCookiePage;
    protected MobileFavoritesPharmaciesPage mobileFavoritesPharmaciesPage;
  //  protected MobileMedicationsCategorysPopUpPage mobileMedicationsCategoryPage;
  //  protected MobileMyOrdersPage mobileMyOrdersPage;
    protected MobileHeaderBlock mobileHeaderBlock;
    protected MobileBasementBlock mobileBasementBlock;
    protected MobileMainPopUpBlock mobileMainPopUpBlock;
  //  protected MobilePersonalAccountPage mobilePersonalAccountPage;
   // protected MobileChangePasswordPage mobileChangePasswordPage;
  //  protected MobileFavoritesPage mobileFavoritesPage;
  //  protected MobilePersonalDataPage mobilePersonalDataPage;
  //  protected MobileMedicationsCategorysPopUpPage mobileMedicationsCategorysPopUpPage;
    protected MobileMedicationsPage mobileMedicationsPage;
  //  protected MobileAllergyPage mobileAllergyPage;
  //  protected MobileCitiesPopUpPage mobileCitiesPopUpPage;
  //  protected MobileBotConsultantPopUpPage mobileBotConsultantPopUpPage;



    @Before
    public void PagesInitialization() {
        commonActionsOnMobilePages = new CommonActionsOnMobilePages(driver);
        pageElementActions = new PageElementActions(driver);
        mobileCheckOutPage = new MobileCheckOutPage(driver);
        mobileCartPage = new MobileCartPage(driver);
        mobileAuthPopUpPage = new MobileAuthPopUpPage(driver);
        mobileProductCardPage = new MobileProductCardPage(driver);
        mobileMainPage = new MobileMainPage(driver);
        mobileOspPage = new MobileOspPage(driver);
        mobileSberPage = new MobileSberPage(driver);
        mobileThankForTheOrderPage = new MobileThankForTheOrderPage(driver);
        mobileCookiePage = new MobileCookiePage(driver);
        mobileCatalogPage = new MobileCatalogPage(driver);
       // mobileMedicationsCategoryPage = new MobileMedicationsCategorysPopUpPage(driver);
      //  mobileMyOrdersPage = new MobileMyOrdersPage(driver);
        mobileHeaderBlock = new MobileHeaderBlock(driver);
        mobileBasementBlock = new MobileBasementBlock(driver);
        mobileMainPopUpBlock = new MobileMainPopUpBlock(driver);
        mobileFavoritesPharmaciesPage = new MobileFavoritesPharmaciesPage(driver);
      //  mobilePersonalAccountPage = new MobilePersonalAccountPage(driver);
      //  mobileChangePasswordPage = new MobileChangePasswordPage(driver);
      //  mobileFavoritesPage = new MobileFavoritesPage(driver);
      //  mobilePersonalDataPage = new MobilePersonalDataPage(driver);
      //  mobileAllergyPage = new MobileAllergyPage(driver);
        mobileMedicationsPage = new MobileMedicationsPage(driver);
        mobileTopPanelPage = new MobileTopPanelPage(driver);
       // mobileMedicationsCategorysPopUpPage = new MobileMedicationsCategorysPopUpPage(driver);
      //  mobileCitiesPopUpPage = new MobileCitiesPopUpPage(driver);
      //  mobileBotConsultantPopUpPage = new MobileBotConsultantPopUpPage(driver);
    }

}