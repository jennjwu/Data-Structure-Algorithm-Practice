import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> intersects = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int n: nums1) {
            if (!intersects.containsKey(n)) {
                intersects.put(n, 1);    
            }
        }

        for (int m: nums2) {
            if (intersects.containsKey(m) && !result.contains(m)) {
                result.add(m);
            }
        }

        int[] results = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i);
        }

        return results;
    }
}