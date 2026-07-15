import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Тестовый набор FourthLoginTests - расчет комиссии")
public class FouthLoginTests {
        @BeforeAll
    static void before_all(TestInfo test_info) {
            Configuration.browser = "chrome";
    }
    @AfterAll
    static void after_all(){
        closeWindow();
    }
       @BeforeEach
    void before_each(TestInfo test_info) {
                open("https://slqa.ru/cases/fc/v01/");
            }
        @ParameterizedTest(name = "test01 - корректная сумма, {index}, sum: {0}")
    @ValueSource(strings = {"1", "1500", "100000"})
    void test01(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);

    }
    @ParameterizedTest(name = "test02 - граничные значения, {index}, sum: {0}")
    @ValueSource(strings = {"0", "150000"})
    void test02(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);
    }
    @ParameterizedTest(name = "test03 - некорректные данные, {index}, sum: {0}")
    @ValueSource(strings = {"тест", "summa", "+", "-100"})
    void test03(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);
    }
    @ParameterizedTest(name = "test04 - пустое поле, {index}, sum: {0}")
    @ValueSource(strings = {""})
    void test04(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);
    }
    @ParameterizedTest(name = "test05 - дробные числа, {index}, sum: {0}")
    @ValueSource(strings = {"5.5", "100.1"})
    void test05(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);
    }
}
