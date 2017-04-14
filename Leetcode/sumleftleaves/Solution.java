/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null) {
            // root.left is a leaf node (no children), so add it
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else { // recursively visit left until it is a leaf
                sum += sumOfLeftLeaves(root.left);
            }
        }

        // recursively try on root's right
        return sum += sumOfLeftLeaves(root.right);
    }
}