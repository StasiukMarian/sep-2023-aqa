package lesson4;

import base.config.BaseTest;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ConditionTest extends BaseTest {

    @Test
    public void checkBoxTest() {
//        $(byXpath("//input[@type='checkbox']")).click();

//        Assert.assertTrue($(byXpath("//input[@type='checkbox']")).is(Condition.checked), "checkbox is not checked");

        ElementsCollection checkboxes = $$(byXpath("//input[@type='checkbox']"));

        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).shouldBe(Condition.visible).click();
            Assert.assertTrue(checkboxes.get(i).is(Condition.checked));
        }

        $(byXpath("//input[@name='num']")).shouldHave(Condition.value("100"));

        String actualValue = $(byXpath("//input[@name='num']")).shouldBe(Condition.visible).getValue();

        Assert.assertEquals(actualValue, "100", "Values are not equal");


    }


    //    @Test
    public void conditionTest() {
        System.out.println($(byXpath("//div[@class='error-message-container error']/h3")).is(Condition.hidden));

//        $(byXpath("//input[@placeholder='Username']")).shouldBe(Condition.visible, Duration.ofSeconds(30)).append("standard_user");
//        $(byXpath("//input[@placeholder='Username']")).shouldNotHave(Condition.id("user-name")).append("standard_user");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.id("user-name")).append("standard_user");
        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.attribute("data-test", "username")).append("standard_user");
//        $(byXpath("//input[@placeholder='Username']")).shouldHave(Condition.name("user-name")).append("standard_user");
//        $(byXpath("//input[@placeholder='Password']")).shouldHave(Condition.cssClass("input_error")).append("standard_user");
//        $(byXpath("//input[@placeholder='Password']")).shouldHave(Condition.type("password")).append("standard_user");
        $(byXpath("//input[@placeholder='Password']")).shouldHave(Condition.type("password")).append("secret_sauce");

//        $(byName("password")).shouldBe(Condition.visible).append("secret_sauce");
//        $(byName("password")).shouldBe(Condition.readonly).append("secret_sauce");
//        $(byName("password")).shouldBe(Condition.empty).append("secret_sauce");

//        $(byXpath("//input[@placeholder='Password']")).shouldBe(Condition.and("inputCondition", Condition.visible, Condition.empty)).append("standard_user");
        System.out.println($(byXpath("//div[@class='login_logo']")).shouldHave(Condition.text("swag")).text());
        System.out.println($(byXpath("//div[@class='login_logo']")).shouldHave(Condition.textCaseSensitive("Swag")).text());
        System.out.println($(byXpath("//div[@class='login_logo']")).shouldHave(Condition.exactTextCaseSensitive("Swag Labs")).text());

        $(byId("login-button")).shouldBe(Condition.and("clickable", Condition.visible, Condition.enabled)).shouldHave(Condition.value("Login")).click();

        System.out.println($(byXpath("//div[@class='error-message-container error']/h3")).is(Condition.hidden));

//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.empty).texts());
        $$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.size(6));

//        $(byXpath("//select[@class='product_sort_container']")).selectOption("Name (Z to A)");
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.sizeNotEqual(5)).texts());

        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.texts(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.textsInAnyOrder(List.of("Sauce Labs Bike Light", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
//        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.(List.of("Sauce Labs Bike Light","Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.exactTexts(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"))).texts());
        System.out.println($$(byXpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.containExactTextsCaseSensitive(List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie"))).texts());
        sleep(2000);


        List<String> expectedItemsFromMainPage = List.of("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");

        List<String> actualItemsFromMainPage = $$(byXpath("//div[@class='inventory_item_name ']")).texts();

        Assert.assertFalse(actualItemsFromMainPage.isEmpty());

        Assert.assertEquals(actualItemsFromMainPage, expectedItemsFromMainPage, "Lists are not equal");

        Assert.assertEquals(actualItemsFromMainPage.size(), 6);

        Assert.assertTrue(actualItemsFromMainPage.contains("Sauce Labs Bike Light"));

    }
}
