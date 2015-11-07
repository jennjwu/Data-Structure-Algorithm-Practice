package Leetcode.binarytreedepth;

/**
 * Created by jennjwu on 11/7/15.
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1; // plus one for current level
    }
}
