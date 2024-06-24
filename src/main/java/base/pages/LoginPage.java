package base.pages;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final String userNameInput = "//input[@placeholder='Username']";
    private final String passwordInput = "password";
    private final String loginButton = "Login";

    public void typeUserName(String userName) {
        $(byXpath(userNameInput)).shouldBe(inputCondition).append(userName);
    }

    public void typePassword(String password) {
        $(byId(passwordInput)).shouldBe(inputCondition).append(password);
    }
    public void clickLoginButton(){
        $(byValue(loginButton)).shouldBe(clickableCondition).submit();
    }
}
