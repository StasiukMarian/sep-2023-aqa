package lesson7;

import base.Pages;
import base.config.BaseTest;
import base.helpers.Constants;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FrameworkTest extends BaseTest {

    @Test
    public void test(){
        Pages.loginPage().typeUserName(Constants.userName);
        Pages.loginPage().typePasswordByPlaceholder(Constants.password);

        Assert.assertTrue(Pages.loginPage().isLoginButtonExist());

        Pages.loginPage().clickLoginButton();

//        Pages.mainPage().clickItemHeaderByID(3);
        Pages.mainPage().clickItemHeaderByName("Sauce Labs Bike Light");

    }
}
