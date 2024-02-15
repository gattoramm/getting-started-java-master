package part3.homework;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchInWiki {
    @Test
    void shouldBeCodeJunit5() {
        //    - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //    - Перейдите в раздел Wiki проекта
        $("#wiki-tab")
                .click();

        //    - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box")
                .$("[data-filterable-for=wiki-pages-filter] .Link--muted")
                .click();

        //    - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("#wiki-pages-box")
                .$(byText("SoftAssertions"))
                .click();
        $("#user-content-3-using-junit5-extend-test-class")
                .parent()
                .shouldHave(text("Using JUnit5 extend test class:"));
    }
}
