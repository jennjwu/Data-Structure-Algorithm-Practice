public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        System.out.println(findNums.length);
        for (int i = 0; i < findNums.length; i++) {
            System.out.println("findNums[" + i + "] = " + findNums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                System.out.print("nums[" + j + "] = " + nums[j]);
                
                
                // start with -1 for not found
                result[i] = -1;

                if (nums[j] > findNums[i]) {
                    result[i] = nums[j];
                    System.out.println(" result = " + result[i]);
                    break;
                } else {
                    System.out.println(" result = " + result[i]);
                }
            }
        }
        return result;
    }
}