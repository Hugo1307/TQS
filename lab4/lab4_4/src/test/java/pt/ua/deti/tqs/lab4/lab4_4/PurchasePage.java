package pt.ua.deti.tqs.lab4.lab4_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

    private WebDriver webDriver;

    private By nameInput = By.id("inputName");
    private By addressInput = By.id("address");
    private By cityInput = By.id("city");
    private By stateInput = By.id("state");
    private By zipCodeInput = By.id("zipCode");
    private By cardNumberInput = By.id("creditCardNumber");
    private By cardTypeInput = By.cssSelector(".control-group:nth-child(10)");
    private By cardYearInput = By.id("creditCardYear");
    private By nameOnCardInput = By.id("nameOnCard");
    private By rememberMeInput = By.id("rememberMe");
    private By purchaseButton = By.cssSelector(".btn-primary");

    public PurchasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillName(String name) {
        webDriver.findElement(nameInput).click();
        webDriver.findElement(nameInput).sendKeys(name);
    }

    public void fillAddress(String address) {
        webDriver.findElement(addressInput).click();
        webDriver.findElement(addressInput).sendKeys(address);
    }

    public void fillCity(String city) {
        webDriver.findElement(cityInput).click();
        webDriver.findElement(cityInput).sendKeys(city);
    }

    public void fillState(String state) {
        webDriver.findElement(stateInput).click();
        webDriver.findElement(stateInput).sendKeys(state);
    }

    public void fillZipCode(String zipCode) {
        webDriver.findElement(zipCodeInput).click();
        webDriver.findElement(zipCodeInput).sendKeys(zipCode);
    }

    public void selectCardType() {
        webDriver.findElement(cardTypeInput).click();
    }

    public void fillCreditCardNumber(String creditCardNumber) {
        webDriver.findElement(cardNumberInput).click();
        webDriver.findElement(cardNumberInput).sendKeys(creditCardNumber);
    }

    public void fillCardYear(String cardYear) {
        webDriver.findElement(cardYearInput).click();
        webDriver.findElement(cardYearInput).sendKeys(cardYear);
    }

    public void fillNameOnCard(String nameOnCard) {
        webDriver.findElement(nameOnCardInput).click();
        webDriver.findElement(nameOnCardInput).sendKeys(nameOnCard);
    }

    public void checkRememberMe() {
        webDriver.findElement(rememberMeInput).click();
    }

    public void clickOnPurchase() {
        webDriver.findElement(purchaseButton).click();
    }

}
