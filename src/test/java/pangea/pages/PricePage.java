package pangea.pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PricePage {
       SelenideElement body = $("body");
       SelenideElement priceList = $x("//*[contains(text(), 'Прейскурант')]");

        @Step("Проверить, что на странице есть текст: {expectedText}")
    public PricePage shouldHaveText(String expectedText) {
        body.shouldHave(text(expectedText))
                .shouldBe(visible);
        return this;
    }

    @Step("Проверить наличие слова 'Прейскурант'")
    public PricePage checkPriceList() {
        priceList.shouldHave(text("Прейскурант"))
                .shouldBe(visible).click();
        return this;
    }
}

