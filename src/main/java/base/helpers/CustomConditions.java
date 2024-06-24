package base.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebElementCondition;

public class CustomConditions {
    public static WebElementCondition inputCondition = Condition.and("empty and visible", Condition.visible, Condition.empty);
    public static WebElementCondition clickableCondition = Condition.and("clickable", Condition.visible, Condition.enabled);
}
