package part3.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BestContributorToSelenide {
    @Test
    void solntsevShouldBeTheTopContributor() {
        // открыть страницу репозитория selenide
        open("https://github.com/selenide/selenide");

        // подвести мышь к первому аватару из блока contributors
        $(".BorderGrid")
                .$(byText("Contributors"))
                    .ancestor(".BorderGrid-row")
                .$$("ul li")
                .first()
                .hover();

        // проверка: во всплывающем сообщении есть текст "Andrey Solntsev"
        $$(".Popover .Popover-message")
                .findBy(visible)
                .shouldHave(text("Andrei Solntsev"));
    }
}
