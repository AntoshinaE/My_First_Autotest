package travel;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AgileLoginPage {

    SelenideElement usernameInput = $("#username");
    SelenideElement passwordInput = $("#password");
    SelenideElement loginButton = $("#login");
    SelenideElement message = $("#message");

    @Step("Войти в систему")
    public AgileLoginPage login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return this;
    }

    @Step("Проверить успешный вход")
    public AgileLoginPage isLoginSuccessful() {
        message.shouldHave(text("Добро пожаловать!"));
        message.shouldBe(visible);
        return this;
    }

    @Step("Проверить ошибку входа")
    public AgileLoginPage isLoginUnsuccessful() {
        message.shouldHave(text("Invalid username or password"));
        message.shouldBe(visible);
        return this;
    }
}
