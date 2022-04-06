package pt.ua.deti.tqs.lab4.lab4_2;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@ExtendWith(SeleniumJupiter.class)
public class BuyflightTest {

  @Test
  public void buyflight(ChromeDriver driver) {

    driver.get("https://blazedemo.com/");
    driver.manage().window().setSize(new Dimension(1512, 944));
    driver.findElement(By.name("fromPort")).click();
    {
      WebElement dropdown = driver.findElement(By.name("fromPort"));
      dropdown.findElement(By.xpath("//option[. = 'Boston']")).click();
    }
    driver.findElement(By.name("toPort")).click();
    {
      WebElement dropdown = driver.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = 'London']")).click();
    }
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
    driver.findElement(By.id("inputName")).click();
    driver.findElement(By.id("inputName")).sendKeys("Hugo");
    driver.findElement(By.id("address")).click();
    driver.findElement(By.id("address")).sendKeys("Rua ");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Porto");
    driver.findElement(By.id("state")).click();
    driver.findElement(By.id("state")).sendKeys("Porto");
    driver.findElement(By.id("zipCode")).click();
    driver.findElement(By.id("zipCode")).sendKeys("4000-300");
    driver.findElement(By.id("creditCardNumber")).click();
    driver.findElement(By.id("creditCardNumber")).sendKeys("110101010101");
    driver.findElement(By.cssSelector(".control-group:nth-child(10)")).click();
    driver.findElement(By.id("creditCardYear")).click();
    driver.findElement(By.id("creditCardYear")).sendKeys("2025");
    driver.findElement(By.id("nameOnCard")).click();
    driver.findElement(By.id("nameOnCard")).sendKeys("Hugo Gonçalves");
    driver.findElement(By.id("rememberMe")).click();
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector(".hero-unit")).click();

    org.junit.jupiter.api.Assertions.assertEquals("BlazeDemo Confirmation", driver.getTitle());

  }
}
