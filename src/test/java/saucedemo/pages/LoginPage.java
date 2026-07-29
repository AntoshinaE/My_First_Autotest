package saucedemo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement usernameInput = $("#user-name");
    SelenideElement passwordInput = $("#password");
    SelenideElement loginButton = $("#login-button");
    SelenideElement errorMessage = $("[data-test='error']");

    @Step("Открыть страницу логина")
    public LoginPage open() {
        Selenide.open("https://www.saucedemo.com/");
        return this;
    }

    @Step("Выполнить логин: {username}")
    public InventoryPage login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return new InventoryPage();
    }

       @Step("Выполнить логин с ошибкой: {username}")
    public LoginPage loginWithError(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return this;
    }

    @Step("Проверить ошибку: {expectedText}")
    public LoginPage checkError(String expectedText) {
        errorMessage.shouldHave(text(expectedText));
        errorMessage.shouldBe(visible);
        return this;
    }
}