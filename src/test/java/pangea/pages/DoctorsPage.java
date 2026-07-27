package pangea.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
public class DoctorsPage {


    SelenideElement pageTitle = $("h1");
    SelenideElement body = $(".background");



    @Step("Открыть страницу врачей (офтальмолог)")
    public DoctorsPage open() {
        Selenide.open("https://www.pangea-center.ru/vrachi/oftalmolog");
        getWebDriver().manage().window().maximize();
        return this;
    }

    @Step("Проверить заголовок страницы: {expectedTitle}")
    public DoctorsPage verifyTitle(String expectedTitle) {
        pageTitle.shouldHave(text(expectedTitle))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверить наличие текста на странице: {expectedText}")
    public DoctorsPage shouldHaveText(String expectedText) {
        body.shouldHave(text(expectedText));
        return this;
    }
}
