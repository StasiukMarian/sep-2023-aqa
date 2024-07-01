package lesson7;

import base.Pages;
import base.config.BaseTest;
import base.helpers.Constants;
import base.pages.Item;
import com.sun.source.tree.AssertTree;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DetailItemTest extends BaseTest {

    @Test
    public void detailTest() {
        Pages.loginPage().typeUserName(Constants.userName);
        Pages.loginPage().typePassword(Constants.password);
        Pages.loginPage().clickLoginButton();

        Pages.mainPage().waitAppLogo();

        List<Item> itemListFromMainPage = Pages.mainPage().getItemList();

        Pages.mainPage().clickItemHeaderByName("Sauce Labs Onesie");

        Item detailedItem = Pages.detailsItemPage().getDetailedItem();

        Assert.assertTrue(itemListFromMainPage.contains(detailedItem), "Item is not exist in List");

    }
}
