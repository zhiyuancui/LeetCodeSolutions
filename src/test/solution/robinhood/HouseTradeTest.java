package test.solution.robinhood;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import solutions.robinhood.HouseTrade;

import java.util.List;


public class HouseTradeTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExactMatchWithExampleInput() {
        HouseTrade h = new HouseTrade();
        String[] houseTrades = {
                "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"
        };
        String[] streetTrades = {
                "FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123"
        };
        String[] expected = new String[]{"AAPL,B,0100,ABC123","FB,B,0100,GBGGGG","GOOG,S,0050,CDC333"};

        List<String> result = h.findUnMatchOrders(houseTrades, streetTrades);

        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }

    @Test
    public void testExactMatch2() {
        HouseTrade h = new HouseTrade();
        String[] houseTrades = new String[] {
                "AAPL,B,0100,ABC123",
                "GOOG,S,0050,CDC333"
        };
        String[] streetTrades = new String[] {
                "FB,B,0100,GBGGGG",
                "AAPL,B,0100,ABC123"
        };

        String[] expected = new String[]{"FB,B,0100,GBGGGG","GOOG,S,0050,CDC333"};

        List<String> result = h.findUnMatchOrders(houseTrades, streetTrades);

        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }

    @Test
    public void testExactMatch3() {
        HouseTrade h = new HouseTrade();
        String[] houseTrades = new String[] {
                "AAPL,S,0010,ZYX444",
                "AAPL,S,0010,ZYX444",
                "AAPL,B,0010,ABC123",
                "GOOG,S,0050,GHG545"
        };

        String[] streetTrades = new String[] {
                "GOOG,S,0050,GHG545",
                "AAPL,S,0010,ZYX444",
                "AAPL,B,0010,TTT222"
        };

        String[] expected = new String[]{"AAPL,B,0010,ABC123","AAPL,B,0010,TTT222","AAPL,S,0010,ZYX444"};

        List<String> result = h.findUnMatchOrders(houseTrades, streetTrades);

        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }

    @Test
    public void testExactMatch4() {
        HouseTrade h = new HouseTrade();
        String[] houseTrades = new String[] {
                "AAPL,B,0010,ABC123",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "GOOG,S,0050,GHG545"
        };
        String[] streetTrades = new String[] {
                "GOOG,S,0050,GHG545",
                "AAPL,S,0015,ZYX444",
                "AAPL,B,0500,TTT222"
        };

        String[] expected = new String[]{"AAPL,B,0010,ABC123","AAPL,B,0500,TTT222","AAPL,S,0015,ZYX444"};

        List<String> result = h.findUnMatchOrders(houseTrades, streetTrades);

        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }

    @Test
    public void testAttributeMatch() {
        HouseTrade h = new HouseTrade();
        String[] houseTrades = new String[] {
                "AAPL,B,0100,ABC123",
                "AAPL,B,0100,BCD123",
                "AAPL,B,0100,XYZ123",
                "GOOG,S,0050,CDC333"
        };
        String[] streetTrades = new String[] {
                "FB,B,0100,GBGGGG",
                "AAPL,B,0100,ABC123",
                "AAPL,B,0100,ABC123",
                "GOOG,S,0050,CDC333",
        };

        String[] expected = new String[]{"AAPL,B,0100,XYZ123", "FB,B,0100,GBGGGG"};

        List<String> result = h.findUnMatchOrders2(houseTrades, streetTrades);

        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }

    @Test
    public void testAttributeMatch2() {
        HouseTrade h = new HouseTrade();
        String[] houseTrades = {
                "AAPL,B,0100,ABC123",
                "AAPL,B,0100,ABC123",
                "AAPL,B,0100,ABC123",
                "GOOG,S,0050,CDC333"
        };
        String[] streetTrades = new String[] {
                "FB,B,0100,GBGGGG",
                "AAPL,B,0100,ABC123",
                "AAPL,B,0100,BDC123",
                "GOOG,S,0050,CDC333",
                "AAPL,S,0100,ABC124"
        };

        String[] expected = new String[]{"AAPL,B,0100,ABC123", "FB,B,0100,GBGGGG", "AAPL,S,0100,ABC124"};

        List<String> result = h.findUnMatchOrders2(houseTrades, streetTrades);

        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }

    @Test
    public void testOffsetMatch() {
        HouseTrade h = new HouseTrade();
        String[] houseTrades = new String[] {
                "AAPL,B,0010,ABC123",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "GOOG,S,0050,GHG545"
        };
        String[] streetTrades = new String[] {
                "GOOG,S,0050,GHG545",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "AAPL,S,0015,ZYX444",
                "AAPL,B,0500,TTT222"
        };
        String[] expected = new String[]{"AAPL,B,0010,ABC123, AAPL,B,0500,TTT222, AAPL,S,0015,ZYX444"};

        List<String> result = h.findUnMatchOrders(houseTrades, streetTrades);

        Assert.assertArrayEquals(expected, result.toArray(new String[result.size()]));
    }
}
