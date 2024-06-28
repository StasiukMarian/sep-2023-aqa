package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.Condition;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageTools {
    private final String userNameInput = "//input[@placeholder='Username']";
    private final String passwordInput = "password";
    private final String passwordPlaceholder = "Password";
    private final String loginButton = "//input[@value='Login']";

    public void typeUserName(String userName) {
        shouldBeByXpath(inputCondition, userNameInput);
        typeByXpath(userNameInput, userName);
    }

    public void typePassword(String password) {
        shouldBeById(inputCondition, passwordInput);
        typeById(passwordInput, password);
    }

    public void typePasswordByPlaceholder(String password) {
        shouldByAttribute(inputCondition, "placeholder", passwordPlaceholder);
        typeByAttribute("placeholder", passwordPlaceholder, password);
    }

    public void clickLoginButton() {
        shouldBeByXpath(Condition.clickable, loginButton);
        clickByXpath(loginButton);
    }

    public boolean isLoginButtonExist() {
        return isElementExistByXpath(loginButton);
    }
}
