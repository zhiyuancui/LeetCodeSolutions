package solutions.instacart;

import org.junit.Assert;

import java.util.*;

/**
 * Instacart onsite 面经
 */
public class Formula {


    /**
     * 第一问：第一小问 expression:["T2", ["T1 = 1", "T2 = T3", "T3 = T1"]] output: T2值
     * 公式都是左边一个变量， 右边是变量或者数值
     * @param target
     * @param expression
     * @return
     * @throws Exception
     */
    public int question1(String target, String[] expression) throws Exception{
        Map<String, String> formulaMapping = new HashMap<>();

        for(int i = 0; i < expression.length; i++) {
            String formula = expression[i];

            formula = formula.replaceAll("\\s+","");
            String[] parts = formula.split("=");

            formulaMapping.put(parts[0], parts[1]);
        }

        return dfs1(target, formulaMapping);
    }

    private int dfs1(String key, Map<String, String> formulaMapping) throws Exception{
        if(!formulaMapping.containsKey(key)) {
            throw new Exception("IMPOSSIBLE");
        }

        String formula = formulaMapping.get(key);
        if(Character.isDigit(formula.charAt(0))) {
            return Integer.parseInt(formula);
        } else {
            return dfs1(formula, formulaMapping);
        }
    }

    /**
     * 第二小问 expression: ["T2", ["T1 = 1", "T2 = 2 + T4", "T3 = T1 - 4", "T4 = T1 + T3]]
     * output:T2值
     * 公式左边为变量，右边为一个或多个变量/数值，包括加减操作
     * @param target
     * @param expression
     * @return
     * @throws Exception
     */
    public int question2WithDFS(String target, String[] expression) throws Exception {
        Map<String, String> formulaMapping = new HashMap<>();

        for(int i = 0; i < expression.length; i++) {
            String formula = expression[i];

            formula = formula.replaceAll("\\s+","");
            String[] parts = formula.split("=");

            formulaMapping.put(parts[0], parts[1]);
        }

        //DFS
        Map<String, Integer> cache = new HashMap<>();
        Set<String> visited = new HashSet<>();
        return dfs(target, formulaMapping, cache, visited);
    }

    private int dfs(String key, Map<String, String> formulaMapping, Map<String, Integer> cache, Set<String> visited) throws Exception{
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        if (!formulaMapping.containsKey(key) || visited.contains(key)) {
            throw new Exception("IMPOSSIBLE");
        }
        visited.add(key);
        String formula = formulaMapping.get(key);

        formula = formula.replaceAll("\\s+","");
        int len = formula.length();

        int sign = 1;
        int result = 0;
        for(int i = 0; i < len; i++) {
            if(Character.isDigit(formula.charAt(i))) {
                int sum = formula.charAt(i) -'0';
                while(i+1<len && Character.isDigit(formula.charAt(i+1))) {
                    sum = sum * 10 + formula.charAt(i+1) - '0';
                    i++;
                }
                result += sign * sum;
            } else if(Character.isLetter(formula.charAt(i))) {
                String nextKey = formula.substring(i, i+2);
                //如果是extra follow up
                //String nextKey = findKey(formula, i);
                int value = dfs(nextKey, formulaMapping, cache,visited);
                if(!cache.containsKey(nextKey)) {
                    cache.put(nextKey, value);
                }
                result += sign * value;
                i++;
            } else if(formula.charAt(i) == '+') {
                sign = 1;
            } else if(formula.charAt(i) == '-') {
                sign = -1;
            }
        }

        return result;
    }

    /**
     * 变量是多个字母  "AA1", ["AA1 = AB1 + 1", "AB1=1"] => "2"
     * @param formula
     * @param index
     * @return
     */

    private String findKey(String formula, int index) {
        int start = index;

        for(int i = index+1; i < formula.length(); i++) {
            if(Character.isLetter(formula.charAt(i))) {
                continue;
            } else if(Character.isDigit(formula.charAt(i))) {
                return formula.substring(start, i+1);
            }
        }

        return null;
    }


    public static void main(String[] args) {
        Formula f = new Formula();

        try {
            Assert.assertEquals(1,f.question1("T2",new String[]{"T1 = 1", "T2 = T3", "T3 = T1"}));
            Assert.assertEquals(0, f.question2WithDFS("T2", new String[]{"T1 = 1", "T2 = 2 + T4", "T3 = T1 - 4", "T4 = T1 + T3"}));
            Assert.assertEquals(10, f.question2WithDFS("T3", new String[]{"T1 = 4", "T2 = 3", "T3 = T4 + T5", "T4=T1-T2+2", "T5 = T4 + T1"}));
            Assert.assertEquals(-25, f.question2WithDFS("T3", new String[]{"T1 =-3", "T2 = 8", "T3 = +T4 +T5", "T4 = T1- T2", "T5 = T4 + T1"}));
            //加visited
            //f.question2WithDFS("T3", new String[]{"T1 = T2", "T2 = T3", "T3 = T1"});
            //f.question2WithDFS("T2", new String[]{"T1 = 1", "T1 = T2 + 2", "T2 = 4 - T1"});
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
