package pangea.pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MainPage {

    SelenideElement body = $(".background");
    SelenideElement menuTitle = $(".menutitle");
    SelenideElement promotions = $x("//*[contains(text(), 'АКЦИИ')]");
    SelenideElement priceText = $x("//*[contains(text(), '9 450 руб')]");
    SelenideElement uzicheck = $x("//*[contains(text(), 'УЗИ чекап')]");
    SelenideElement cookiecons = $(".cookie-consent-button");


    @Step("Открыть главную страницу")
    public MainPage open() {
        Selenide.open("https://www.pangea-center.ru/");
        getWebDriver().manage().window().maximize();
        return this;
    }

    @Step("Проверить, что на странице есть текст: {expectedText}")
    public MainPage shouldHaveText(String expectedText) {
        body.shouldHave(text(expectedText));
        return this;
    }

    @Step("Проверить, что текст {expectedText} виден")
    public MainPage shouldBeVisible() {
        body.shouldBe(visible);
        return this;
    }

    @Step("Проверить наличие акций")
    public MainPage checkPromotions() {
        promotions.shouldHave(text("АКЦИИ"))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверить наличие цены 9 450 руб")
    public MainPage checkPrice() {
        priceText.shouldHave(text("9 450 руб"))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверить наличие УЗИ чекап")
    public MainPage checkUziCheck() {
        uzicheck.shouldHave(text("УЗИ чекап"))
                .shouldBe(visible);
        return this;
    }

    @Step("Открыть меню")
    public MainPage openMenu() {
        menuTitle.shouldBe(visible).click();
        return this;
    }

    @Step("Перейти по ссылке: {url}")
    public MainPage openLink(String url) {
        Selenide.open(url);
        return this;


    }

    @Step("Вернуться назад")
    public MainPage goBack() {
        back();
        return this;
    }

    @Step("Вернуться вперёд")
    public MainPage goForward() {
        forward();
        return this;
    }

    @Step("Проверить, что текущий URL содержит {expectedUrl}")
    public MainPage verifyUrlContains(String expectedUrl) {
        getWebDriver().getCurrentUrl().contains(expectedUrl);
        return this;
    }
    @Step("Проверить наличие кнопки 'Принять'")
    public MainPage checkCookie() {
        cookiecons.shouldBe(visible).click();
        return this;
    }
}

