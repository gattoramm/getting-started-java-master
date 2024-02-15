package part1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    @Test
    void successFullLoginTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;

        open("https://qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));
        $("[name=email]").setValue("verrt@yandex.ru");
        $("[name=password]").setValue("ghvc").pressEnter();
        $(".main-header__login").click();
        $(".logined-form").shouldHave(text("Здравствуйте, verrt"));

    }

    @Test
    void unSuccessFullLoginTestWithoutPassword() {
        Configuration.holdBrowserOpen = true;
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("verrt@yandex.ru").pressEnter();
        $(".form-buttons").shouldHave(text("Не заполнено поле Пароль"));
    }

    @Test
    void unSuccessFullLoginTestWithoutEmail() {
        Configuration.holdBrowserOpen = true;
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("").pressEnter();
        $(".form-buttons").shouldHave(text("Не заполнено поле E-Mail"));
    }
}
