package pt.ua.deti.tqs.covidinfo;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.ua.deti.tqs.covidinfo.pages.CountryStatisticsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryStatisticsSteps {

    private WebDriver driver;

    private CountryStatisticsPage countryStatisticsPage;

    @When("I navigate to country statistics at {string}")
    public void iNavigateToCountryStatistics(String url) {
        WebDriverManager.chromedriver().create();
        driver = new ChromeDriver();
        driver.get(url);
        countryStatisticsPage = new CountryStatisticsPage(driver);
    }

    @Then("I should see the country statistics title {string}")
    public void iShouldSeeTheCountryStatsTitle(String result) {
        try {
            assertThat(countryStatisticsPage.checkTitle(result)).isTrue();
        } catch (NoSuchElementException e) {
            throw new AssertionError(
                    "\"" + result + "\" not available in results");
        } finally {
            driver.quit();
        }
    }

    @And("I select the country {string}")
    public void selectCountry(String result) {
        countryStatisticsPage.selectCountry(result);
    }

    @Then("I should see the country statistic {string} with value {string}")
    public void iShouldSeeCountryStatistic(String result1, String result2) {
        assertThat(countryStatisticsPage.hasStatisticValue(result1, result2)).isTrue();
        driver.quit();
    }

    @Then("I should see the following country statistics:")
    public void iShouldSeeCountryStatistic(List<String> stringList) {
        for (String statistic : stringList)
            assertThat(countryStatisticsPage.hasStatisticTitle(statistic)).isTrue();
        driver.quit();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
