package solutions;

import java.util.*;

/**
 * 1257 Smallest Common Region
 */
public class SmallestCommonRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parents = new HashMap<>();
        Set<String> ancestryHistory = new HashSet<>();
        for (List<String> region : regions)
            for (int i = 1; i < region.size(); ++i)
                parents.put(region.get(i), region.get(0));
        while (region1 != null) {
            ancestryHistory.add(region1);
            region1 = parents.get(region1);
        }
        while (!ancestryHistory.contains(region2))
            region2 = parents.get(region2);
        return region2;
    }
}
