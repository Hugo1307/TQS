package pt.ua.deti.tqs.lab4.lab4_3;

import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleEquals(String text) {
        return driver.getTitle().equals(text);
    }

}
