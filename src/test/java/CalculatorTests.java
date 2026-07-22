import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CalculatorTests {

    @BeforeAll
    static void setUp() {
        // Настройка браузера
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void test01() {
        open("https://slqamsk.github.io/cases/loan-calc/v01");
        getWebDriver().manage().window().maximize();
        $("#amount").setValue("500000");
        $("#term").setValue("24");
        $("#rate").setValue("21.5");
        $("#calculate-btn").click();
        $("#results-container").shouldBe(visible);
        $x("//p[contains(text(), 'Сумма кредита:')]")
                .shouldHave(text("500000"));
        $x("//p[contains(text(), 'Срок кредита:')]")
                .shouldHave(text("24"));
        $x("//p[contains(text(), 'Процентная ставка:')]")
                .shouldHave(text("21.5"));
        $x("//p[contains(text(), 'Тип платежа:')]")
                .shouldHave(text("Аннуитетный"));
        $x("//p[contains(text(), 'Ежемесячный платёж:')]")
                .shouldHave(text("25815.79"));
        $x("//p[contains(text(), 'Переплата по кредиту:')]")
                .shouldHave(text("119578.86"));
        $x("//p[contains(text(), 'Общая сумма выплат:')]")
                .shouldHave(text("619578.86"));
        sleep(2000);
        $("#show-schedule-btn").click();
        switchTo().window(1);
        sleep(2000);
        $x("//p[contains(text(), 'Сумма кредита:')]")
                .shouldHave(text("500000"));
        $x("//p[contains(text(), 'Срок кредита:')]")
                .shouldHave(text("24 месяцев"));
        $x("//p[contains(text(), 'Процентная ставка:')]")
                .shouldHave(text("21.5% годовых"));
        $x("//p[contains(text(), 'Тип платежа:')]")
                .shouldHave(text("Аннуитетный"));
        sleep(2000);
        closeWindow();
              }


    @ParameterizedTest(name = "Проверка аннуитетного платежа: сумма {0}, срок {1} мес., ставка {2}% , платёж {3}")
    @CsvSource({
            "500000, 24, 21.5, 25815.79",
            "500000, 12, 21.5, 46676.95",
            "500000, 36, 21.5, 18966.14",
            "500000, 60, 21.5, 13667.69",
              })
    void test02(String amount, String term, String rate, String expectedPayment) {
        open("https://slqamsk.github.io/cases/loan-calc/v01");
        getWebDriver().manage().window().maximize();
        $("#amount").setValue(amount);
        $("#term").setValue(term);
        $("#rate").setValue(rate);
        $("#calculate-btn").click();
        $("#results-container").shouldBe(visible);
           }
}