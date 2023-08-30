package orderStatistic.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class TestKLargestOrderStatistics {
    
    private KLargestOrderStatisticsImpl<Integer> implementation;
    private Integer[] vetorPar;

    @Before
    public void setUp() {
        this.implementation = new KLargestOrderStatisticsImpl<Integer>();
        this.vetorPar = new Integer[] {8,12,4,9,1,6};
    }

    @Test
    public void testOrderStatistics() {
        Integer kth = implementation.orderStatistics(vetorPar, 3);
        assertEquals(6, (int)kth);
    }
}
 