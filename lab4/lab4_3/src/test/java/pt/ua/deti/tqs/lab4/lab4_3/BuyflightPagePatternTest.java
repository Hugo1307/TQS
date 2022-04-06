package pt.ua.deti.tqs.lab4.lab4_3;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.BooleanSupplier;

@ExtendWith(SeleniumJupiter.class)
public class BuyflightPagePatternTest {

  @Test
  void buyflight(ChromeDriver chromeDriver) {

    BlazeDemoPage mainPage = new BlazeDemoPage(chromeDriver);
    ReservePage reservePage = new ReservePage(chromeDriver);
    PurchasePage purchasePage = new PurchasePage(chromeDriver);
    ConfirmationPage confirmationPage = new ConfirmationPage(chromeDriver);

    mainPage.findFlight("Boston", "London");
    reservePage.createReservation();

    purchasePage.fillName("Hugo");
    purchasePage.fillAddress("Rua ");
    purchasePage.fillCity("Porto");
    purchasePage.fillState("Porto");
    purchasePage.fillZipCode("4000-300");
    purchasePage.fillCreditCardNumber("110101010101");
    purchasePage.selectCardType();
    purchasePage.fillCardYear("2025");
    purchasePage.fillNameOnCard("Hugo Gonçalves");
    purchasePage.checkRememberMe();
    purchasePage.clickOnPurchase();

    Assertions.assertTrue(confirmationPage.isTitleEquals("BlazeDemo Confirmation"));

  }

}
