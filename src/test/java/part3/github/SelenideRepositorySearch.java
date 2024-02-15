package part3.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // Arrange
        // Act
        //Assert

        // открыть главную страницу
        open("https://github.com/");

        // ввести в поле поиска selenide и нажать Enter
        $(".search-input-container")
                .click();
        $("#query-builder-test")
                .setValue("selenide")
                .pressEnter();

        // кликнуть на первый репозитарий из списка
        $$("[data-testid=results-list]>div")
                .first()
                .$(".search-title")
                .click();

        // проверка: заголовок selenide/selenide
        $("#repository-container-header")
                .shouldHave(text("selenide / selenide"));
    }
}
