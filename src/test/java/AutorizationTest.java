import com.codeborne.selenide.WebElementCondition;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;
public class AutorizationTest {
    @Test
    void Test01(){
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).setValue("standard_user");
        $(By.id("password")).setValue("stand_pass1");
        $(By.tagName("button")).click();
        $(By.className("greeting")).shouldHave(text("Добро пожаловать, Иванов Иван Иванович!"));

    }
@Test
        void Test02(){
        open("https://slqamsk.github.io/cases/slflights/v01/");

    $(By.id("username")).setValue("standard_user");
    $(By.id("password")).setValue("asdfasdfasdfasdfasdf");
    $(By.id("loginButton")).click();
    $(By.className("error")).shouldHave(text("Неверное имя пользователя или пароль."));
    sleep(10000);
}
}
