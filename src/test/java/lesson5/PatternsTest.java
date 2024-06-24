package lesson5;

import base.config.BaseTest;
import base.pages.*;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static base.Pages.*;
import static base.helpers.Constants.*;

public class PatternsTest extends BaseTest {
//    MainPage mainPage = new MainPage();
//    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
//    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
//    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
//    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @BeforeMethod
    public void login() {
        loginPage().typeUserName(userName);
        loginPage().typePassword(password);
        loginPage().clickLoginButton();
    }

    @Test
    public void patternsTest() {
        mainPage().waitAppLogo();

        String backPackItem = mainPage().getItemHeadersText().get(0);

        mainPage().clickAddToCartButton();
        mainPage().clickShoppingCartButton();

        Selenide.sleep(1000);

        String backPackItemFromShoppingCart = shoppingCartPage().getItemNamesText().get(0);

        Assert.assertEquals(backPackItem, backPackItemFromShoppingCart, "Items are not the same");

        shoppingCartPage().clickCheckoutButton();

        checkoutYourInformationPage().fillYourInformationInputs(firstName, lastName, zip);
        checkoutYourInformationPage().clickSubmitButton();

        Selenide.sleep(1000);

        String backPackItemFromOverview = checkoutOverviewPage().getItemNamesText().get(0);

        Assert.assertEquals(backPackItem, backPackItemFromOverview, "Items are not the same");
        checkoutOverviewPage().clickFinishButton();

        Selenide.sleep(1000);

        Assert.assertTrue(checkoutCompletePage().isCompleteMessageExist(), "Complete message is not visible");
        checkoutCompletePage().clickBackHomeButton();
    }

    @AfterMethod
    public void logout() {
        mainPage().clickBurgerMenuButton();
        mainPage().clickLogoutButton();
    }
}
