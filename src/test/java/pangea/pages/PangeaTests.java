package pangea.pages;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@DisplayName("Тесты для сайта Пангея-Центр")
public class PangeaTests {

     MainPage mainPage;
     DoctorsPage doctorsPage;
     PricePage pricePage;

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "eager";
        System.out.println("=== НАЧАЛО ВСЕХ ТЕСТОВ ===");
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println(" " + testInfo.getDisplayName() + " - начали выполнение.");
        mainPage = new MainPage();
        doctorsPage = new DoctorsPage();
        pricePage = new PricePage();
    }

        @AfterAll
    static void afterAll() {
        System.out.println("=== ВСЕ ТЕСТЫ ЗАВЕРШЕНЫ ===");
    }

    @Test
    @DisplayName("01. Проверка главной страницы на наличие ключевых элементов")
    void test01MainPage() {
        mainPage.open()
                .checkPromotions()
                .checkPrice();

    }

        @Test
    @DisplayName("02. Навигация по страницам (вперёд/назад)")
    void test02Navigation() {
        mainPage.open();

               mainPage.openLink("https://www.pangea-center.ru/vrachi/oftalmolog")
                .verifyUrlContains("oftalmolog");

               mainPage.openLink("https://www.pangea-center.ru/programms/dispancerization")
                .verifyUrlContains("dispancerization");

               mainPage.goBack()
                .verifyUrlContains("oftalmolog");

        mainPage.goBack()
                .verifyUrlContains("pangea-center");
    }

    @Test
    @DisplayName("03. Открытие меню и проверка прейскуранта")
    void test03MenuAndPrice() {
        mainPage.open()
                .openMenu();

           }
        @Test
    @DisplayName("04. Проверка страницы врачей-офтальмологов")
    void test04DoctorsPage() {
        doctorsPage.open()
                .verifyTitle("Офтальмолог")
                .shouldHaveText("офтальмолог");
    }

    @Test
    @DisplayName("05. Проверка наличия цен на сайте")
    void test05CheckPrices() {
        mainPage.open()
                .checkPrice()
                .shouldHaveText("руб");
    }
        @Test
    @DisplayName("06. Проверка наличия кнопки принять")
    void test06CheckCookie(){
        mainPage.open()
                .CheckCookie()
                .shouldBeVisible();

        }
}


