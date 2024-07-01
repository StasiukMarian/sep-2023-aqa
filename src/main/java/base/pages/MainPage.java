package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends PageTools {
    private final String appLogo = "//div[@class='app_logo']";
    private final String itemHeaders = "//div[@class='inventory_item_name ']";
    private final String itemDescriptions = "//div[@class='inventory_item_desc']";
    private final String itemPrices = "//div[@class='inventory_item_price']";
    private final String itemHeadersByID = "(//div[@class='inventory_item_name '])[%d]";
    private final String itemHeadersByName = "//div[text()='%s']";
    private final String burgerMenuButton = "//div[@class='bm-burger-button']";
    private final String filterButton = "//select[@class='product_sort_container']";
    private final String shoppingCart = "//a[@class='shopping_cart_link']";
    private final String addToCart = "//button[text()='Add to cart']";
    private final String logoutButton = "//a[text()='Logout']";

    public void waitAppLogo() {
        $(byXpath(appLogo)).shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public ElementsCollection getItemHeaders() {
        return $$(byXpath(itemHeaders)).shouldBe(CollectionCondition.size(6));
    }

    public List<String> getItemHeadersText() {
        return $$(byXpath(itemHeaders)).shouldBe(CollectionCondition.size(6)).texts();
    }

    public List<Item> getItemList() {
        List<Item> itemList = new ArrayList<>();

        List<String> headersList = getElementsTextByXPath(itemHeaders);
        List<String> descriptionsList = getElementsTextByXPath(itemDescriptions);
        List<String> pricesList = getElementsTextByXPath(itemPrices);
        for (int i = 0; i < headersList.size(); i++) {
            Item item = new Item();

            item.setName(headersList.get(i));
            item.setDescription(descriptionsList.get(i));
            item.setPrice(pricesList.get(i));
            itemList.add(item);
        }
        return itemList;
    }

    public void clickBurgerMenuButton() {
        $(byXpath(burgerMenuButton)).shouldBe(clickableCondition).click();
    }

    public void selectFilterOption(String filterOption) {
        $(byXpath(filterButton)).shouldBe(clickableCondition).selectOption(filterOption);
    }

    public void clickShoppingCartButton() {
        $(byXpath(shoppingCart)).shouldBe(clickableCondition).click();
    }

    public void clickAddToCartButton() {
        $(byXpath(addToCart)).shouldBe(clickableCondition).click();
    }

    public void clickLogoutButton() {
        $(byXpath(logoutButton)).shouldBe(clickableCondition).click();
    }

    public void clickItemHeaderByID(int id) {
        shouldBeByXpath(Condition.clickable, itemHeadersByID, id);
        clickByXpath(itemHeadersByID, id);
    }

    public void clickItemHeaderByName(String name) {
        shouldBeByXpath(Condition.clickable, itemHeadersByName, name);
        clickByXpath(itemHeadersByName, name);
    }


}
