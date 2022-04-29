package pt.ua.deti.tqs.covidinfo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountryStatisticsPage {

    private final WebDriver webDriver;

    By pageTitleElement = By.cssSelector("h4");
    By countryDropdown = By.cssSelector(".mb-3 > .form-control");

    public CountryStatisticsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean checkTitle(String expectedTitle) {
        return webDriver.findElement(pageTitleElement).getText().equals(expectedTitle);
    }

    public boolean hasStatisticTitle(String expectedStatisticTitle) {

        new WebDriverWait(webDriver, 2).until(driver -> driver.findElement(By.cssSelector(".mt-4:nth-child(3) > .mb-4:nth-child(1) .text-xs")));

        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 5; y++) {
                By statisticTitleElement = By.cssSelector(String.format(".mt-4:nth-child(%d) > .mb-4:nth-child(%d) .text-xs", x, y));
                try {
                    if (webDriver.findElement(statisticTitleElement).getText().equals(expectedStatisticTitle)) return true;
                } catch (NoSuchElementException ignored) { }
            }
        }

        return false;

    }

    public boolean hasStatisticValue(String statisticTitle, String expectedStatisticValue) {

        new WebDriverWait(webDriver, 2).until(driver -> driver.findElement(By.cssSelector(".mt-4:nth-child(3) > .mb-4:nth-child(1) .text-xs")));

        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 4; y++) {
                By statisticTitleElement = By.cssSelector(String.format(".mt-4:nth-child(%d) > .mb-4:nth-child(%d) .text-xs", x, y));
                By statisticValueElement = By.cssSelector(String.format(".mt-4:nth-child(%d) > .mb-4:nth-child(%d) .h5", x, y));
                try {
                    if (webDriver.findElement(statisticTitleElement).getText().equals(statisticTitle))
                        return webDriver.findElement(statisticValueElement).getText().equals(expectedStatisticValue);
                } catch (NoSuchElementException ignored) { }
            }
        }

        return false;

    }

    public void selectCountry(String country) {

        WebElement dropdown = webDriver.findElement(countryDropdown);

        dropdown.click();
        dropdown.findElement(By.xpath(String.format("//option[. = '%s']", country))).click();
        webDriver.findElement(pageTitleElement).click();

    }

}
