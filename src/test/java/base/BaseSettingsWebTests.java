package base;

import actions.PageElementActions;
import blocks.web.WebBasementBlock;
import blocks.web.WebHeaderBlock;
import core.MainTestBase;
import org.junit.Before;
import pages.commonActions.web.CommonActionsOnWebPages;
import pages.web.*;


public class BaseSettingsWebTests extends MainTestBase {

    protected CommonActionsOnWebPages commonActionsOnWebPages;
    protected MainPage mainPage;
    protected PageElementActions pageElementActions;
    protected CookiePage cookiePage;
    protected AuthPopUpPage authPopUpPage;
    protected ProductCardPage productCardPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected SberPage sberPage;
    protected ThankForTheOrderPage thankForTheOrderPage;
    protected OspPage ospPage;
  //  protected MyOrdersPage myOrdersPage;
    protected WebHeaderBlock headerBlock;
    protected WebBasementBlock basementBlock;
  //  protected PersonalDataPage personalDataPage;
  //  protected BonusCardPopUpPage bonusCardPopUpPage;
  //  protected ChangePasswordPage changePasswordPage;
  //  protected FavoritesPage favoritesPage;
    protected CatalogPage catalogPage;
    protected TopPanelPage topPanelPage;
    protected MedicationsPage medicationsPage;
  //  protected CitiesPopUpPage citiesPopUpPage;
  //  protected BotConsultantPopUpPage botConsultantPopUpPage;



    @Before
    public void PagesInitialization() {
        commonActionsOnWebPages = new CommonActionsOnWebPages(driver);
        mainPage = new MainPage(driver);
        pageElementActions = new PageElementActions(driver);
        cookiePage = new CookiePage(driver);
        authPopUpPage = new AuthPopUpPage(driver);
        productCardPage = new ProductCardPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        sberPage = new SberPage(driver);
        thankForTheOrderPage = new ThankForTheOrderPage(driver);
        ospPage = new OspPage(driver);
     //   myOrdersPage = new MyOrdersPage(driver);
        headerBlock = new WebHeaderBlock(driver);
        basementBlock = new WebBasementBlock(driver);
     //   personalDataPage = new PersonalDataPage(driver);
     //   bonusCardPopUpPage = new BonusCardPopUpPage(driver);
     //   changePasswordPage = new ChangePasswordPage(driver);
     //   favoritesPage = new FavoritesPage(driver);
        catalogPage = new CatalogPage(driver);
        topPanelPage = new TopPanelPage(driver);
        medicationsPage = new MedicationsPage(driver);
     //   citiesPopUpPage = new CitiesPopUpPage(driver);
     //   botConsultantPopUpPage = new BotConsultantPopUpPage(driver);
    }

}






