import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FindElement {

    @Test
    void test01() {
        open("https://www.saucedemo.com/");
        // $(By.tagName("")).shouldHave(text("username"));
        $(By.id("user-name")).sendKeys("Елена");
        sleep(10_000);
    }
}

