package pt.ua.deti.tqs.lab2.stocks;

import org.hamcrest.MatcherAssert;
import org.hamcrest.number.IsCloseTo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    private IStockMarketService iStockMarketService;
    private StocksPortfolio stocksPortfolio;

    @BeforeEach
    void setUp() {
        stocksPortfolio = new StocksPortfolio(iStockMarketService);
    }

    @Test
    void getTotalValue () {

        Stock stock1 = new Stock("Tesla", 20);
        Stock stock2 = new Stock("Apple", 10);

        stocksPortfolio.addStock(stock1);

        Mockito.when(iStockMarketService.lookupPrice("Tesla")).thenReturn(10d);
        Mockito.when(iStockMarketService.lookupPrice("Apple")).thenReturn(30d);

        assertThat(stocksPortfolio.getTotalValue(), IsCloseTo.closeTo(200.0, 0.01));

        stocksPortfolio.addStock(stock2);

        assertThat(stocksPortfolio.getTotalValue(), IsCloseTo.closeTo(500.0, 0.01));

        Mockito.verify(iStockMarketService, Mockito.times(3)).lookupPrice(Mockito.any(String.class));

    }

    @Test
    void testAddStock() {

        assertThat(stocksPortfolio.getStocks(), empty());

        Stock stock1 = new Stock("Tesla", 20);
        stocksPortfolio.addStock(stock1);

        assertThat(stocksPortfolio.getStocks(), hasSize(1));

    }

}