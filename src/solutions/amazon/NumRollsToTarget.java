package solutions.amazon;

import java.util.HashMap;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.MOD;

public class NumRollsToTarget {
    Map<String,Integer> map = new HashMap<>();
    int MOD = 1000000000 + 7;

    public int numRollsToTarget(int d, int f, int target) {
        if(d ==0 || (d*f) < target || target <= 0)
            return 0;
        if(d == 1 && target <= f)
            return 1;
        String key=d+"-"+target;
        if(map.containsKey(key))
            return map.get(key);
        else{
            int count=0;
            for(int i=f;i>=1;i--)
            {
                count+=numRollsToTarget(d-1,f,target-i);
                count%=MOD;
            }
            map.put(key,count);
            return count;
        }
    }
}
