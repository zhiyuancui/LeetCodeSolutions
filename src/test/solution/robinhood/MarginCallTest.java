package test.solution.robinhood;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import solutions.robinhood.MarginCall;

import java.util.Arrays;
import java.util.List;

public class MarginCallTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private void verify(List<List<String>> expected, List<List<String>> actual) {
        Assert.assertEquals(expected.size(), actual.size());

        int i =0;
        int j = 0;

        while(i < expected.size() && j < actual.size()) {
            List<String> e = expected.get(i);
            List<String> a = actual.get(i);

            Assert.assertEquals(e.get(0), a.get(0));
            Assert.assertEquals(e.get(1), a.get(1));
            i++;
            j++;
        }


    }

    @Test
    public void testUserPortfolio() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String [][]{
                {"1", "AAPL", "B", "10", "10"},
                {"3", "GOOG", "B", "20", "5"},
                {"10", "AAPL", "S", "5", "15"}
        };
        List<List<String>> result = m.getUserPortfolio(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","875"),Arrays.asList("AAPL","5"),Arrays.asList("GOOG","20") );

        verify(expected, result);
    }

    @Test
    public void testUserPortfolio2() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String [][]{
                {"1", "AAPL", "B", "10", "10"},
                {"3", "GOOG", "B", "20", "5"},
                {"4", "FB", "B", "5", "12"},
                {"3", "GOOG", "S", "3", "8"},
                {"3", "GOOG", "B", "5", "10"},
                {"10", "AAPL", "S", "5", "15"}
        };

        List<List<String>> result = m.getUserPortfolio(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","789"),Arrays.asList("AAPL","5"), Arrays.asList("FB","5"), Arrays.asList("GOOG","22"));

        verify(expected, result);
    }

    @Test
    public void testUserPortfolioWithMarginCall() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String [][]{
                {"1", "AAPL", "B", "10", "100"},
                {"2", "AAPL", "S", "2", "80"},
                {"3", "GOOG", "B", "15", "20"}
        };

        List<List<String>> result = m.getUserPortfolioWithMarginCall(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","20"),Arrays.asList("AAPL","6"), Arrays.asList("GOOG","15"));

        verify(expected, result);
    }

    @Test
    public void testUserPortfolioWithMarginCallButPriceHasTie() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String [][]{
                {"1", "AAPL", "B", "5", "100"},
                {"2", "ABPL", "B", "5", "100"},
                {"3", "AAPL", "S", "2", "80"},
                {"4", "ABPL", "S", "2", "80"},
                {"5", "GOOG", "B", "15", "30"}
        };

        List<List<String>> result = m.getUserPortfolioWithMarginCall(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","30"),Arrays.asList("AAPL","1"), Arrays.asList("ABPL","3"),Arrays.asList("GOOG","15"));

        verify(expected, result);
    }

    @Test
    public void testUserPortfolioWithMarginCallAndPickHighestPrice() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String [][]{
                {"1", "AAPL", "B", "5", "100"},
                {"2", "ABPL", "B", "5", "100"},
                {"3", "AAPL", "S", "2", "80"},
                {"4", "ABPL", "S", "2", "120"},
                {"5", "GOOG", "B", "15", "30"}
        };

        List<List<String>> result = m.getUserPortfolioWithMarginCall(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","70"),Arrays.asList("AAPL","3"), Arrays.asList("ABPL","2"),Arrays.asList("GOOG","15"));

        verify(expected, result);
    }

    @Test
    public void testUserPortfolioWithMarginCallWithMultipleSell() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String [][]{
                {"1", "AAPL", "B", "5", "100"},
                {"2", "ABPL", "B", "5", "100"},
                {"3", "AAPL", "S", "2", "80"},
                {"4", "ABPL", "S", "2", "120"},
                {"5", "GOOG", "B", "10", "80"}
        };

        List<List<String>> result = m.getUserPortfolioWithMarginCall(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","40"),Arrays.asList("AAPL","2"), Arrays.asList("GOOG","10"));

        verify(expected, result);
    }

    @Test
    public void testUserPortfolioWithMarginCallSellBuyStock() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String [][]{
                {"1", "AAPL", "B", "5", "100"},
                {"2", "ABPL", "B", "5", "100"},
                {"3", "AAPL", "S", "2", "80"},
                {"4", "ABPL", "S", "2", "120"},
                {"5", "GOOG", "B", "10", "150"}
        };

        List<List<String>> result = m.getUserPortfolioWithMarginCall(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","100"),Arrays.asList("AAPL","3"), Arrays.asList("ABPL","3"), Arrays.asList("GOOG","2"));

        verify(expected, result);
    }

    @Test
    public void testUserPortfolioWithCollateral() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String[][]{
                {"1", "AAPL", "B", "5", "100"},
                {"2", "GOOG", "B", "5", "75"},
                {"3", "AAPLO", "B", "5", "50"}
        };

        List<List<String>> result = m.getUserPortfolioWithCollatoral(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","25"),Arrays.asList("AAPL","5"), Arrays.asList("AAPLO","5"),Arrays.asList("GOOG","3"));

        verify(expected, result);
    }

    @Test
    public void testUserPortfolioWithCollateralAndSellCollecteral() {
        MarginCall m = new MarginCall(1000);
        String[][] records = new String[][]{
                {"1", "AAPL", "B", "5", "100"},
                {"2", "GOOG", "B", "2", "35"},
                {"3", "AAPLO", "B", "3", "50"},
                {"3", "FB", "B", "30", "30"},
        };

        List<List<String>> result = m.getUserPortfolioWithCollatoral(records);
        List<List<String>> expected = Arrays.asList(Arrays.asList("CASH","30"),Arrays.asList("FB","30"), Arrays.asList("GOOG","2"));

        verify(expected, result);
    }
}
