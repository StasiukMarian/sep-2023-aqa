package lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clipboard;

public class ProgressBarTest {
    @Test
    public void test() {
// PROGRESS - BAR
//        Selenide.open("https://demoqa.com/progress-bar");
//        $(byXpath("//div[@role='progressbar']")).scrollTo();
//        $(byId("startStopButton")).shouldBe(Condition.clickable).click();
//
//        $(byXpath("//div[@role='progressbar']")).shouldBe(Condition.text("100%"), Duration.ofSeconds(20));
//
//        Assert.assertTrue($(byId("resetButton")).is(Condition.visible));

//        while (true) {
//            if ($(byXpath("//div[@role='progressbar']")).text().equals("50%")) {
//                break;
//            }
//        }
//        $(byId("startStopButton")).scrollTo().shouldBe(Condition.clickable).click();
//
//
//        Assert.assertEquals($(byXpath("//div[@role='progressbar']")).text(), "50%");


        //ALERTS

//        Selenide.open("https://demoqa.com/alerts");
//
//        $(byId("confirmButton")).scrollTo().click();

//        Selenide.confirm();
//        String dismiss = Selenide.dismiss();
//
//        Assert.assertEquals("Do you confirm action?", dismiss);
//        Selenide.sleep(2000);
//
//        Assert.assertTrue($(byXpath("//*[@class='text-success']")).is(Condition.visible));

        // SHADOW DOM

//        Selenide.open("http://uitestingplayground.com/shadowdom");
//
//        $(shadowCss("#buttonGenerate", "guid-generator")).shouldBe(Condition.clickable).click();
//
//        String textFromInput = $(shadowCss("#editField", "guid-generator")).shouldBe(Condition.visible).getValue();
//
//        System.out.println(textFromInput);
//        $(shadowCss("#buttonCopy", "guid-generator")).shouldBe(Condition.clickable).click();
//
//        String textFromClipboard = clipboard().getText();
//
//        System.out.println(textFromClipboard);
//
//        Assert.assertEquals(textFromClipboard, textFromInput);

//        Selenide.open("https://github.com/StasiukMarian/sep-2023-aqa");
//
//        $(byXpath("//button//span[text()='Code']")).shouldBe(Condition.clickable).click();
//
//        $(byXpath("(//button[@data-component='IconButton'])[3]")).click();
//
//        System.out.println(clipboard().getText());
    }
}
