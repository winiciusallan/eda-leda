package roteiro.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatisticsSelectionImpl;

public class TestOrderStatisticsSelection {
    
    private Integer[] vetorPar;
    private Integer[] vetorImpar;

    public OrderStatisticsSelectionImpl<Integer> implementation;

    @Before
    public void setUp() {
        vetorPar = new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23,
            31};
        vetorImpar = new Integer[]{6, 41, 32, 7, 26, 4, 37, 49,
            11, 18, 36};

        this.implementation = new OrderStatisticsSelectionImpl<>();
    }

    @Test
    public void testaKthVetorPar() {
        Integer kth = implementation.getOrderStatistics(vetorPar, 2);
        assertEquals(7, (int) kth);
    }
}
