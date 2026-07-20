import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Тесты XPath на учебной странице")

public class SimpleXPathTests {

    @BeforeAll
    static void before_all() {
        Configuration.browser = "chrome";

    }

    @BeforeEach
    void before_each() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
    }

    @Test
    void testPageH1() {
        $x("//h1");
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
        $x("//h1").shouldBe(visible);
        sleep(1000);
    }

    @Test
    void testSpecialParagraph01() {
        $x("//p[@class='special-paragraph']");
        $x("//p[@class='special-paragraph']")
                .shouldHave(text("""
                        Этот параграф особенный - 
                        он единственный на странице 
                        с таким классом.."""));
        $x("//p[@class='special-paragraph']")
                .shouldBe(visible);
        sleep(1000);

    }

    @Test
    void testSpecialParagraph02() {
        $x("//p[@class='info-text']");
        $x("//p[@class='info-text']")
                .shouldHave(text("Это первый информационный текст."));
        $x("//p[@class='info-text']").shouldBe(visible);
        sleep(1000);
    }

    @Test
    void testSpecialParagraph03() {
        $x("//p[@class='info-text'][2]");
        $x("//p[@class='info-text'][2]")
                .shouldHave(text("Это второй информационный текст."));
        $x("//p[@class='info-text']").shouldBe(visible);
        sleep(1000);

    }

    @ParameterizedTest(name = "Проверка info-text #{index}")
    @CsvSource({
            "1, Это первый информационный текст.",
            "2, Это второй информационный текст.",
            "3, Это третий информационный текст."
    })
    void testInfoTextsCount(String index, String expectedText) {
        // Ищем по классу и индексу
        $x("(//p[@class='info-text'])[" + index + "]")
                .shouldHave(text(expectedText))
                .shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка внутренней ссылки")
    void testInternalLink() {
        $x("//a[contains(@href, '#')]")
                .shouldHave(text("Внутренняя ссылка (О нас)"))
                .shouldBe(visible);
    }

    // ========== ТЕСТ 9: Проверка всех ссылок ==========
  /* @Test
    @DisplayName("Проверка количества ссылок")
    void testAllLinks() {
        // Всего на странице 3 ссылки
        $$x("//a").shouldHaveSize(3);
    }*/
    @Test
    void testTextSearch() {
        open("https://slqa.ru/cases/xPathSimpleForm/");


// Так - правильно, т.к. он не выбирает родительский div
        $x("//div[contains(text(),'Питер')]").shouldHave(text("180 единиц"));

// Так - неправильно, т.к. он вместо нужного элемента возьмёт родительский div
       /* $x("//div[contains(.,'Москва')]").shouldHave(text("250 единиц"));
    }*/
    }

    @Test
    void testTextSearch01() {
        open("https://slqa.ru/cases/xPathSimpleForm/");


// Так - правильно, т.к. он не выбирает родительский div
        // $x("//div[starts-with(text(),'Казахстан')]").shouldHave(text("площадь 2 724 902"));
        // $(By.xpath("//button[contains(text(),'Маргарита')]")).click();
        // $(By.xpath("//button[contains(text(),'Четыре сыра')]")).click();

// Так - неправильно, т.к. он вместо нужного элемента возьмёт родительский div
       /* $x("//div[contains(.,'Москва')]").shouldHave(text("250 единиц"));
    }*/
    }

    @Test
    void testTextSearch03() {
        open("https://slqamsk.github.io/cases/pizza/v08/ ");
        $x("//h3[contains(.,'Маргарита')]/../button")
                .shouldBe(exist)
                .shouldBe(visible)
                .click();
        $x("//h3[contains(.,'Четыре сыра')]/../button").click();
// Так - правильно, т.к. он не выбирает родительский div
        // $x("//div[starts-with(text(),'Казахстан')]").shouldHave(text("площадь 2 724 902"));
        // $(By.xpath("//button[contains(text(),'Маргарита')]")).click();
        // $(By.xpath("//button[contains(text(),'Четыре сыра')]")).click();
    }

    @Test
    void testFindFormViaAncestor() {

        open("https://slqa.ru/cases/cinema/index_only_age.html");
        String ancestorXpath = "//button[contains(text(),'Рассчитать')]/ancestor::form";
        $x("//button[contains(text(),'Рассчитать')]").shouldBe(visible);

    }

    @Test
    void testDynamicContent() {

        open("https://slqa.ru/cases/WaitsSimpleForm/");

        $("#dynamic_content").shouldHave(text("за 10000 миллисекунд."));
    }
    @Test
    void testDynamicContentWithXPath() {
                open("https://slqa.ru/cases/WaitsSimpleForm/");


        $x("//*[@id='dynamic_content']").shouldHave(text("за 10000 миллисекунд."));


        String actualText = $x("//*[@id='dynamic_content']").getText();




        sleep(2_000);

    }
    @Test
    void test02IFrameByIndex() {
        Configuration.pageLoadStrategy = "eager";

        open("https://demoqa.com/frames");
        getWebDriver().manage().window().maximize();

        switchTo().frame(0);
        $x("//h1").shouldHave(text("This is a sample page"));
        switchTo().defaultContent();
    }

}



