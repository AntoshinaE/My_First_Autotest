import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
public class MyLocator {
    @Test
    public void findElementsOnPage() {
        open("https://slqamsk.github.io/demo/search-demo/");
        By myLocator = By.id("submit-button");
        /*SelenideElement myElement = Selenide.element(myLocator);
        myElement.shouldBe(visible);*/
        sleep(1_000);
        $(By.id("submit-button")).shouldBe(visible);
        $(By.id("user-password")).shouldBe(visible);
        $(By.name("interests")).shouldBe(visible);
        $(By.name("user_email")).shouldBe(visible);
        $(By.className("nav-link")).shouldBe(visible);
        $(By.className("btn")).shouldBe(visible);
        $(By.tagName("input")).shouldBe(visible);
        $(By.tagName("h3")).shouldBe(visible);
        $(By.linkText("Контакты и обратная связь")).shouldBe(visible);
        $(By.linkText("Регистрация нового пользователя в системе")).shouldBe(visible);
        $(By.partialLinkText("длинный")).shouldBe(visible);
        $(By.partialLinkText("Контакты")).shouldBe(visible);
    }
}