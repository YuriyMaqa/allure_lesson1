package allure.lesson1;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;
@Owner("YuriyMaqa")
@Severity(SeverityLevel.BLOCKER)
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории")
public class SelenideTest {

    @Test
    @DisplayName("Мой тест")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").setValue("yuriymaqa/lesson3");
        $(".header-search-input").submit();

        $(linkText("YuriyMaqa/lesson3")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#3")).click();
    }
}
