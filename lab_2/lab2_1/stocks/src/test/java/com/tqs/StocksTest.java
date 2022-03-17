package com.tqs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StocksTest {

    @Mock
    IStockMarketService market;

    @InjectMocks
    StocksPortfolio portfolio;

    @BeforeEach
    public void setUp() {
        portfolio = new StocksPortfolio(market);
    }

    @Test
    public void getTotalValue() {
        portfolio.addStock(new Stock("EBAY", 323));
        portfolio.addStock(new Stock("AAPL", 453));

        when(market.lookUpPrice("EBAY")).thenReturn(26.0);
        when(market.lookUpPrice("AAPL")).thenReturn(8.0);

        double total = 323 * 26 + 453 * 8;

        assertThat(portfolio.getTotalValue(), is(total));

        verify(market, times(2)).lookUpPrice(anyString());
    }


}
