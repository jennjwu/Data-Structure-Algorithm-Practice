class Solution {
	 public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];
        for (int fwd = 0, bkwd = numbers.length - 1; fwd < bkwd; ) {
            int sum = numbers[fwd] + numbers[bkwd];
            if (sum == target) {
                sol[0] = fwd + 1;
                sol[1] = bkwd + 1;
                break;
            } else if (sum > target) {
                bkwd--;
            } else {
                fwd++;
            }
        }
        return sol;
    }
}