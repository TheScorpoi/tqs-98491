package com.tqs;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {

    private List<Stock> stocks = new ArrayList<Stock>();
    IStockMarketService stockMarketService;

    public StocksPortfolio(IStockMarketService stockMarketService) {
        this.stockMarketService = stockMarketService;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getTotalValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stockMarketService.lookUpPrice(stock.getLabel()) * stock.getQuantity();
        }
        return totalValue;
    }
    
}
