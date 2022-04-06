package pt.ua.deti.tqs.lab4.lab4_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage {

    WebDriver driver;

    By reserveButton = By.cssSelector("tr:nth-child(1) .btn");

    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    public void createReservation() {
        driver.findElement(reserveButton).click();
    }

}
