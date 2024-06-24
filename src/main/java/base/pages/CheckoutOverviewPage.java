package base.pages;

import java.util.List;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutOverviewPage {
    private final String itemNames = "//div[@class='inventory_item_name']";
    private final String finishButton = "finish";

    public List<String> getItemNamesText() {
        return $$(byXpath(itemNames)).texts();
    }
    public void clickFinishButton (){
        $(byId(finishButton)).shouldBe(clickableCondition).click();
    }
}
