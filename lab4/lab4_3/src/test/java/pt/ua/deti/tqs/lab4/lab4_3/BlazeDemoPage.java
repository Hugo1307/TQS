package pt.ua.deti.tqs.lab4.lab4_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoPage {

    WebDriver driver;

    By fromPortInput = By.name("fromPort");
    By toPortInput = By.name("toPort");
    By pageTitle = By.tagName("h3");
    By submitButton = By.cssSelector(".btn-primary");

    public BlazeDemoPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://blazedemo.com");
    }

    public void findFlight(String fromCity, String toCity) {
        driver.findElement(fromPortInput).click();
        driver.findElement(fromPortInput).findElement(By.xpath(String.format("//option[. = '%s']", fromCity))).click();

        driver.findElement(toPortInput).click();
        driver.findElement(toPortInput).findElement(By.xpath(String.format("//option[. = '%s']", toCity))).click();

        driver.findElement(submitButton).click();
    }

}
