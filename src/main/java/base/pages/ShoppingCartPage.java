package base.pages;

import java.util.List;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ShoppingCartPage {
    private final String itemNames = "//div[@class='inventory_item_name']";
    private final String checkoutButton = "checkout";

    // get methods
    public List<String> getItemNamesText() {
        return $$(byXpath(itemNames)).texts();
    }

    // click methods
    public void clickCheckoutButton() {
        $(byId(checkoutButton)).shouldBe(clickableCondition).click();
    }
}
