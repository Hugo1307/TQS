package pt.ua.deti.tqs.lab2.stocks;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {

    private final List<Stock> stocks;
    private final IStockMarketService stockMarket;

    public StocksPortfolio(IStockMarketService stockMarket) {
        this.stocks = new ArrayList<>();
        this.stockMarket = stockMarket;
    }

    void addStock(Stock stock) {
        stocks.add(stock);
    }

    double getTotalValue() {
        return stocks.stream()
                .map(stock -> stock.getQuantity() * stockMarket.lookupPrice(stock.getLabel()))
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public List<Stock> getStocks() {
        return stocks;
    }

}
