package Leetcode.constructrectangle;

/**
 * Created by jennjwu on 3/1/17.
 */
public class Solution {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int minDiff = area;
        for (int l = 1; l <= area; l++) {
            if (area % l == 0) {
                int w = area / l;
                if (l >= w) {
                    System.out.println("length = " + l + " width = " + w);
                    System.out.println("diff = " + Math.abs(l - w));
                    int diff = Math.abs(l - w);
                    if (diff <= minDiff) {
                        result[0] = l;
                        result[1] = w;
                        minDiff = diff;
                    }
                    System.out.println(result[0] + " " + result[1]);
                }

            }
        }

        return result;
    }
}