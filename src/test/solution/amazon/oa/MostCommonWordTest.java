package test.solution.amazon.oa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import solutions.amazon.oa.MostCommonWord;

import java.util.List;


public class MostCommonWordTest {

    @Test
    public void test() {
        MostCommonWord solution = new MostCommonWord();
        String[] reviews = new String[]{
                "Anacell provides the best services in the city",
        "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell",
};
        String[] keywords = new String[]{"anacell", "cetracular", "betacellular"};
        List<String> result = solution.mostCommonWord(2, reviews, keywords);

        for(String s : result){
            System.out.println(s);
        }
    }
}
