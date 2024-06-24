package base.pages;

import com.codeborne.selenide.Condition;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutCompletePage {
    private final String completeHeader = "//h2[@class='complete-header']";
    private final String backHomeButton = "//button[text()='Back Home']";

    public boolean isCompleteMessageExist() {
        return $(byXpath(completeHeader)).is(Condition.visible);
    }

    public void clickBackHomeButton() {
        $(byXpath(backHomeButton)).shouldBe(clickableCondition).click();
    }
}
