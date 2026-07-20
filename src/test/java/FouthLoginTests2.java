import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Тестовый набор FourthLoginTests - проверка аутентификации")
public class FouthLoginTests2 {
    //String[] browsers = {"chrome", "firefox", "edge"};

    @BeforeAll
    static void before_all(TestInfo test_info) {
        // System.out.println(test_info.getDisplayName() + " - начали выполнение.");
        Configuration.browser = "firefox"; //"chrome", "firefox", "edge"
    }

    /*@AfterAll
    static void after_all(TestInfo test_info) {
        System.out.println(test_info.getDisplayName() + " - закончили выполнение.");
    }*/

    @BeforeEach
    void before_each(TestInfo test_info) {
        //System.out.println("Тест " + test_info.getDisplayName() + " - начали выполнение.");
        //Configuration.browser = browsers[new Random().nextInt(3)];
        open("https://slqa.ru/cases/fc/v01/");
        //open("https://slqa.ru/cases/ChatGPTLogin/index_v02.html");
        //open("https://slqa.ru/cases/ChatGPTLogin/index_v03.html");
    }

    /* @AfterEach
     void after_each(TestInfo test_info) {
         //closeWindow();
         System.out.println("Тест " + test_info.getDisplayName() + " - закончили выполнение.\n");
     }*/
    //01. Корректные логин и пароль - успешный вход в систему по нажатию кнопки "Login"
    //12. Проверить вход в систему под несколькими разными логинами
    @ParameterizedTest(name = "test01, #{index}, sum: {0}")
    @ValueSource(strings = {"1", "1500", "100000"})
    void test01(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);

    }
    @ParameterizedTest(name = "test02, #{index}, sum: {0}")
    @ValueSource(strings = {"0", "-100", "150000"})
    void test02(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);
    }
    @ParameterizedTest(name = "test03, #{index}, sum: {0}")
    @ValueSource(strings = {"тест", "summa", "+"})
    void test03(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);
    }
    @ParameterizedTest(name = "test04, #{index}, sum: {0}")
    @ValueSource(strings = {""})
    void test04(String sum) {
        $("[name=sum]").setValue(sum);
        $("[name= submit]").click();
        sleep(2000);
    }
    }
