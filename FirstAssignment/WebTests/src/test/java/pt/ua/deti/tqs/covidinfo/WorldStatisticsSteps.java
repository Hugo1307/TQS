package pt.ua.deti.tqs.covidinfo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.ua.deti.tqs.covidinfo.pages.WorldStatisticsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldStatisticsSteps {

    private WebDriver driver;

    private WorldStatisticsPage worldStatisticsPage;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.chromedriver().create();
        driver = new ChromeDriver();
        driver.get(url);
        worldStatisticsPage = new WorldStatisticsPage(driver);
    }

    @Then("I should see the title {string}")
    public void iShouldSee(String result) {
        assertThat(worldStatisticsPage.checkTitle(result)).isTrue();
        driver.quit();
    }

    @Then("I should see the world statistics:")
    public void iShouldSeeWorldStatistic(List<String> result) {
        for (String value : result)
            assertThat(worldStatisticsPage.containsStatisticTitle(value)).isTrue();
        driver.quit();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
