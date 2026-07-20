import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class SimpleWikiTest {
    @Test
    void test01() {
        open("https://slqa.ru/AT/articles/how-to-install-git.html ");
        $("body").shouldHave(text("Git"));
    }
    @Test
    void test02() {
        open("https://slqa.ru/AT/articles/how-to-install-git.html ");
        $("body").shouldHave(text("Mercurial"));
    }
}

