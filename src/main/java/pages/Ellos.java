package pages;

import utils.ScreenShotMaker;
import utils.Util;
import utils.WebDriverWrapper;
import utils.WebElementsActions;


public class Ellos {

    public WebElementsActions web;
    public Util util;

    public MainPage mainPage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;
    public ProductPage productPage;
    public WishlistModalWindow wishlist;
    public CheckoutPage checkoutPage;
    public MyCabinetPage mycabinetPage;
    public ErrorPage errorPage;
    public HelpDeskPage helpDeskPage;

    public ScreenShotMaker screenShotMaker;


    public Ellos(WebDriverWrapper driver) {
        web  = new WebElementsActions(driver);
        util = new Util(driver);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        wishlist = new WishlistModalWindow(driver);
        checkoutPage = new CheckoutPage(driver);
        registrationPage = new RegistrationPage(driver);
        mycabinetPage = new MyCabinetPage(driver);
        errorPage = new ErrorPage(driver);
        helpDeskPage = new HelpDeskPage(driver);

        screenShotMaker = new ScreenShotMaker(driver);
    }
}

