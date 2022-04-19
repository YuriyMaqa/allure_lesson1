package allure.lesson1;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("YuriyMaqa")
@Severity(SeverityLevel.BLOCKER)
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории")
public class AnnotatedStepTest {

    private static final String REPOSITORY = "YuriyMaqa/lesson3";
    private static final int ISSUE_NUMBER = 3;

    @Test
    @DisplayName("Мой тест")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssuesWithNumber(ISSUE_NUMBER);
    }
}
