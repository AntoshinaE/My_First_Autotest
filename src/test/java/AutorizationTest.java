

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AutorizationTest {
    @Test
    void Test01(){
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).type("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.className("greeting")).shouldHave(text("Добро пожаловать, Иванов Иван Иванович!"));
        sleep(5000);

    }
@Test
        void Test02(){
        open("https://slqamsk.github.io/cases/slflights/v01/");

    $(By.id("username")).setValue("standard_user");
    $(By.id("password")).setValue("123456");
    $(By.id("loginButton")).click();
    $(By.className("error")).shouldHave(text("Неверное имя пользователя или пароль."));
    sleep(5000);

}
@Test
    void test03() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("loginButton")).click();
        $(By.id("message")).shouldBe(visible);
        sleep(5000);
    }
    @Test
    void test04(){
        open("https://the-internet.herokuapp.com/login");
        $(By.id("username")).setValue("tomsmith");
        $(By.name("password")).sendKeys("SuperSecretPassword!");
        $(By.className("radius")).click();
        //$(By.id("flash")).shouldBe(visible);
        $(By.id("flash")).shouldHave(text("You logged into a secure area!"));
              sleep(5000);

    }
    }


