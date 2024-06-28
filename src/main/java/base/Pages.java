package base;

import base.pages.*;

public class Pages {
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static ShoppingCartPage shoppingCartPage;
    private static CheckoutYourInformationPage checkoutYourInformationPage;
    private static CheckoutOverviewPage checkoutOverviewPage;
    private static CheckoutCompletePage checkoutCompletePage;

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static ShoppingCartPage shoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage();
        }
        return shoppingCartPage;
    }

    public static CheckoutYourInformationPage checkoutYourInformationPage() {
        if (checkoutYourInformationPage == null) {
            checkoutYourInformationPage = new CheckoutYourInformationPage();
        }
        return checkoutYourInformationPage;
    }

    public static CheckoutOverviewPage checkoutOverviewPage() {
        if (checkoutOverviewPage == null) {
            checkoutOverviewPage = new CheckoutOverviewPage();
        }
        return checkoutOverviewPage;
    }

    public static CheckoutCompletePage checkoutCompletePage() {
        if (checkoutCompletePage == null) {
            checkoutCompletePage = new CheckoutCompletePage();
        }
        return checkoutCompletePage;
    }
}
