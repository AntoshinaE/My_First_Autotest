import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Тесты XPath на учебной странице")
public class SimpleXPathTests {
    @BeforeAll
    static void before_all() {
        Configuration.browser = "firefox";
        sleep(10000);
    }
    @BeforeEach
    void before_each() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
    }

    @Test
    void testPageH1(){
        $x("//h1");
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
        $x("//h1").shouldBe(visible);
    }
    }


