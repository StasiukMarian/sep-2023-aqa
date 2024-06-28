package base.config;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PageTools {
    protected String locatorFormatter(String locator, Object... args) {
        return String.format(locator, args);
    }

    // BY XPATH
    protected SelenideElement shouldBeByXpath(WebElementCondition condition, String locator, Object... args) {
        return $(byXpath(locatorFormatter(locator, args))).shouldBe(condition);
    }

    protected void clickByXpath(String locator, Object... args) {
        $(byXpath(locatorFormatter(locator, args))).click();
    }

    protected void typeByXpath(String locator, String text, Object... args) {
        $(byXpath(locatorFormatter(locator, args))).append(text);
    }

    protected boolean isElementExistByXpath(String locator, Object... args) {
        return $(byXpath(locatorFormatter(locator, args))).is(Condition.exist);
    }

    // BY ID

    protected SelenideElement shouldBeById(WebElementCondition condition, String locator, Object... args) {
        return $(byId(locatorFormatter(locator, args))).shouldBe(condition);
    }

    protected void clickById(String locator, Object... args) {
        $(byId(locatorFormatter(locator, args))).click();
    }

    protected void typeById(String locator, String text, Object... args) {
        $(byId(locatorFormatter(locator, args))).append(text);
    }

    protected boolean isElementExistById(String locator, Object... args) {
        return $(byId(locatorFormatter(locator, args))).is(Condition.exist);
    }

    // By name

    protected SelenideElement shouldBeByName(WebElementCondition condition, String locator, Object... args) {
        return $(byName(locatorFormatter(locator, args))).shouldBe(condition);
    }

    protected void clickByName(String locator, Object... args) {
        $(byName(locatorFormatter(locator, args))).click();
    }

    protected void typeByName(String locator, String text, Object... args) {
        $(byName(locatorFormatter(locator, args))).append(text);
    }

    protected boolean isElementExistByName(String locator, Object... args) {
        return $(byName(locatorFormatter(locator, args))).is(Condition.exist);
    }

    // By attribute
    protected SelenideElement shouldByAttribute(WebElementCondition condition, String attribute, String locator, Object... args) {
        return $(byAttribute(attribute, locatorFormatter(locator, args))).shouldBe(condition);
    }

    protected void typeByAttribute(String attribute, String locator, String text, Object... args) {
        $(byAttribute(attribute, locatorFormatter(locator, args))).append(text);
    }

    protected void clickByAttribute(String attribute, String locator, Object... args) {
        $(byAttribute(attribute, locatorFormatter(locator, args))).click();
    }

    protected boolean isElementExistByAttribute(String attribute, String locator, Object... args) {
        return $(byAttribute(attribute, locatorFormatter(locator, args))).is(Condition.exist);
    }
}
