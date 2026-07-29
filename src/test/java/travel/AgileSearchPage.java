package travel;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AgileSearchPage {

    SelenideElement fromCity = $("#from");
    SelenideElement toCity = $("#to");
    SelenideElement departDate = $("#departDate");
    SelenideElement returnDate = $("#returnDate");
    SelenideElement searchButton = $("#searchButton");
    SelenideElement resultMessage = $("#resultMessage");

    @Step("Поиск рейсов")
    public AgileSearchPage search(String from, String to, String depart, String returnDateValue) {
        fromCity.setValue(from);
        toCity.setValue(to);
        departDate.setValue(depart);
        returnDate.setValue(returnDateValue);
        searchButton.click();
        return this;
    }

    @Step("Проверить, что рейсы найдены")
    public AgileSearchPage isFlightsFound() {
        resultMessage.shouldHave(text("Найдены рейсы"));
        resultMessage.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что рейсов нет")
    public AgileSearchPage isNoFlights() {
        resultMessage.shouldHave(text("Рейсов не найдено"));
        resultMessage.shouldBe(visible);
        return this;
    }
}
