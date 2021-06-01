package solutions.instacart;

import java.util.*;

public class Formula {



    public int question1(String answer, String[] input) throws Exception{
        Map<String, String> formulaMapping = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            String formula = input[i];

            formula = formula.replaceAll("\\s+","");
            String[] parts = formula.split("=");

            formulaMapping.put(parts[0], parts[1]);
        }

        return dfs1(answer, formulaMapping);
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

    public int question2WithDFS(String answer, String[] input) throws Exception {
        Map<String, String> formulaMapping = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            String formula = input[i];

            formula = formula.replaceAll("\\s+","");
            String[] parts = formula.split("=");

            formulaMapping.put(parts[0], parts[1]);
        }

        //DFS
        Map<String, Integer> cache = new HashMap<>();
        Set<String> visited = new HashSet<>();
        return dfs(answer, formulaMapping, cache, visited);


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

        int sign = 1;
        int result = 0;
        int len = formula.length();
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


    public static void main(String[] args) {
        Formula f = new Formula();

        try {
            System.out.println(f.question1("T2",new String[]{"T1 = 1", "T2 = T3", "T3 = T1"}));
            System.out.println(f.question2WithDFS("T2", new String[]{"T1 = 1", "T2 = 2 + T4", "T3 = T1 - 4", "T4 = T1 + T3"}));
            //加visited
            System.out.println(f.question2WithDFS("T2", new String[]{"T1 = 1", "T1 = T2 + 2", "T2 = 4 - T1"}));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
