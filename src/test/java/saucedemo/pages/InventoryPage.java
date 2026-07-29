package saucedemo.pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {

    SelenideElement logo = $(".app_logo");
    SelenideElement inventoryContainer = $("[data-test='inventory-container']");
    SelenideElement cartIcon = $("#shopping_cart_container");

    @Step("Проверить, что страница загружена")
    public InventoryPage checkInventoryVisible() {
        inventoryContainer.shouldBe(visible);
        return this;
    }

    @Step("Проверить логотип: {expectedText}")
    public InventoryPage checkLogo(String expectedText) {
        logo.shouldHave(text(expectedText));
        logo.shouldBe(visible);
        return this;
    }

    @Step("Проверить корзину")
    public void checkCartVisible() {
        cartIcon.shouldBe(visible);
           }
}