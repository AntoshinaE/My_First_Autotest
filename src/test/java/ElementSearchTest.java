import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
//import static com.codeborne.selenide.Condition.visible;
//
// import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ElementSearchTest {
    @Test
    void ElementSearch(){
        open("https://slqamsk.github.io/demo/search-demo/");
        sleep(10000);
        $(By.id("submit-button")).shouldBe(visible);
        $(By.name("interests")).shouldBe(visible);
        $(By.className("nav-link")).shouldBe(visible);
        $(By.tagName("input")).shouldBe(visible);
        $(By.linkText("Контакты и обратная связь")).shouldBe(visible);
        $(By.partialLinkText("длинный")).shouldBe(visible);

    }
}
