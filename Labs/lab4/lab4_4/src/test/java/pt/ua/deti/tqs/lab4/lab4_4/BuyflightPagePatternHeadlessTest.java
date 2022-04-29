package pt.ua.deti.tqs.lab4.lab4_4;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.function.BooleanSupplier;

@ExtendWith(SeleniumJupiter.class)
public class BuyflightPagePatternHeadlessTest {

  @Test
  void buyflight(HtmlUnitDriver htmlUnitDriver) {

    BlazeDemoPage mainPage = new BlazeDemoPage(htmlUnitDriver);
    ReservePage reservePage = new ReservePage(htmlUnitDriver);
    PurchasePage purchasePage = new PurchasePage(htmlUnitDriver);
    ConfirmationPage confirmationPage = new ConfirmationPage(htmlUnitDriver);

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
