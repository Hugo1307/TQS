package pt.ua.deti.tqs.covidinfo.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Getter
public class WorldStatisticsPage {

    private final WebDriver webDriver;

    By titleElement = By.cssSelector("h4");

    By totalCasesTitleElement = By.cssSelector(".mt-4:nth-child(1) > .mb-4:nth-child(1) .text-xs");
    By totalCasesValueElement = By.cssSelector(".mt-4:nth-child(1) > .mb-4:nth-child(1) .h5");

    By newDeathsTitleElement = By.cssSelector(".mt-4:nth-child(2) > .mb-4:nth-child(1) .text-xs");
    By newDeathsValueElement = By.cssSelector(".mt-4:nth-child(2) > .mb-4:nth-child(1) .h5");

    By newRecoveredTitleElement = By.cssSelector(".mt-4:nth-child(3) > .mb-4:nth-child(1) .text-xs");
    By newRecoveredValueElement = By.cssSelector(".mt-4:nth-child(3) > .mb-4:nth-child(1) .h5");

    By deathsPerMillionTitleElement = By.cssSelector(".mt-4:nth-child(4) > .mb-4:nth-child(1) .text-xs");
    By deathsPerMillionValueElement = By.cssSelector(".mt-4:nth-child(4) > .mb-4:nth-child(1) .h5");

    By newCasesTitleElement = By.cssSelector(".mt-4:nth-child(1) > .mb-4:nth-child(2) .text-xs");
    By newCasesValueElement = By.cssSelector(".mt-4:nth-child(1) > .mb-4:nth-child(2) .h5");

    By totalRecoveredTitleElement = By.cssSelector(".mt-4:nth-child(2) > .mb-4:nth-child(2) .text-xs");
    By totalRecoveredValueElement = By.cssSelector(".mt-4:nth-child(2) > .mb-4:nth-child(2) .h5");

    By activeCasesTitleElement = By.cssSelector(".mt-4:nth-child(3) > .mb-4:nth-child(2) .text-xs");
    By activeCasesValueElement = By.cssSelector(".mt-4:nth-child(3) > .mb-4:nth-child(2) .h5");

    By caseFatalityRateTitleElement = By.cssSelector(".mt-4:nth-child(4) > .mb-4:nth-child(2) .text-xs");
    By caseFatalityRateValueElement = By.cssSelector(".mt-4:nth-child(4) > .mb-4:nth-child(2) .h5");

    By totalDeathsTitleElement = By.cssSelector(".mt-4:nth-child(1) > .mb-4:nth-child(3) .text-xs");
    By totalDeathsValueElement = By.cssSelector(".mt-4:nth-child(1) > .mb-4:nth-child(3) .h5");

    public WorldStatisticsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkTitle(String expectedTitle) {
        return webDriver.findElement(titleElement).getText().equals(expectedTitle);
    }

    public boolean containsStatisticTitle(String statisticTitle) {

        List<By> statisticsTitles = List.of(totalCasesTitleElement, newDeathsTitleElement, newRecoveredTitleElement, deathsPerMillionTitleElement, newCasesTitleElement,
                totalRecoveredTitleElement, activeCasesTitleElement, caseFatalityRateTitleElement, totalDeathsTitleElement);

        for (By statisticTitleElement : statisticsTitles) {
            try {
                if (webDriver.findElement(statisticTitleElement).getText().equals(statisticTitle))
                    return true;
            } catch (NoSuchElementException ignored) { }
        }
        return false;

    }

}
