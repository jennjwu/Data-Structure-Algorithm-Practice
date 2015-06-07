package Leetcode.singlenum;

import java.util.ArrayList;

public class Single {
    public int singleNumber(int[] nums){
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){

            if (newList.contains(nums[i])){
                int j = newList.indexOf(nums[i]);
                newList.remove(j);
            }
            else{
                newList.add(nums[i]);
            }
        }

        Integer[] arr = newList.toArray(new Integer[newList.size()]);

        return arr[0];

    }
}
