package Leetcode.duplicates;

import java.util.HashMap;

/**
 * Created by jennjwu on 6/7/15.
 */
public class Duplicates {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                map.put(nums[i],++count);
            }
            else{
                map.put(nums[i],1);
            }
        }

        for(Integer key: map.keySet()){
            //System.out.println("key: "+ key + " value: " + map.get(key));
            int cnt = map.get(key);
            if (cnt > 1){
                return true;
            }
        }

        return false;
    }
}
