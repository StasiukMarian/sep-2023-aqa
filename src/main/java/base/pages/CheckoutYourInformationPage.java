package base.pages;

import static base.helpers.CustomConditions.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckoutYourInformationPage {
    private final String firstNameInput = "//input[@placeholder='First Name']";
    private final String lastNameInput = "//input[@placeholder='Last Name']";
    private final String zipInput = "//input[@placeholder='Zip/Postal Code']";
    private final String submitButton = "//input[@value='Continue']";

    public void fillYourInformationInputs(String firstName, String lastName, String zip) {
        $(byXpath(firstNameInput)).shouldBe(inputCondition).append(firstName);
        $(byXpath(lastNameInput)).shouldBe(inputCondition).append(lastName);
        $(byXpath(zipInput)).shouldBe(inputCondition).append(zip);
    }

    public void clickSubmitButton() {
        $(byXpath(submitButton)).shouldBe(clickableCondition).submit();
    }
}
