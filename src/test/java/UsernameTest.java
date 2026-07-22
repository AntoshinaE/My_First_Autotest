import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class UsernameTest {
    @Test
    void test01_Username(){
        open("https://www.saucedemo.com/");
        $(By.id("user-name")).sendKeys("Елена");

          }
          @Test
    void test02(){
        open("https://www.saucedemo.com/");
        $("#user-name").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce");
        $("#login-button").click();
        $(".app_logo").shouldHave(text("Swag Labs"));
             // $("[name=inventory_container]").shouldBe(visible);
          }
          @Test
    void test03(){
              open("https://www.saucedemo.com/");
              $("#user-name").sendKeys("standard_user");
              $("#password").sendKeys("123456");
              $("#login-button").click();
              $("[data-test='error']").shouldHave(text("Epic sadface: Username and password do not match any user in this service"));

          }
          @Test
    void test04(){open("https://www.saucedemo.com/");
              $("#login-button").click();
              $("[data-test='error']").shouldHave(text("Epic sadface: Username is required"));

          }
          @Test
    void test05(){
              open("https://www.saucedemo.com/");
              $("#user-name").sendKeys("Helen");
              $("#password").sendKeys("secret_sauce");
              $("#login-button").click();
              $("[data-test='error']")
                      .shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
          }
          @Test
    void test06(){
              open("https://www.saucedemo.com/");
              $("#user-name").sendKeys("standard_user");
              $("#password").sendKeys("");
              $("#login-button").click();
              $("[data-test='error']").shouldHave(text("Epic sadface: Password is required"));
          }


}

