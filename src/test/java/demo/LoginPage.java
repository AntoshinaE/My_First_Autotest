import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement usernameInput = $("#username");
    SelenideElement passwordInput = $("#password");
    SelenideElement loginButton = $("#loginButton");
    SelenideElement message = $("#message");
    SelenideElement greeting = $("#greeting");

    public LoginPage login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return this;
    }
    // Метод: проверка успешного логина
    public LoginPage isLoginSuccessful(String fullName) {
        message.shouldHave(text("Вход в систему выполнен успешно! Загрузка..."));
        message.shouldBe(visible);
        return this;
    }

    // Метод: проверка неуспешного логина
    public LoginPage isLoginUnsuccessful() {
        message.shouldHave(text("Неверное имя пользователя или пароль."));
        message.shouldBe(visible);
        return this;
    }
}
