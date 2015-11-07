package Leetcode.binarytreedepth;

/**
 * Created by jennjwu on 11/7/15.
 */
import Leetcode.binarytreedepth.TreeNode;

public class Main {
    public static TreeNode makeTree() {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n3.right = n6;

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = makeTree();

        int d1 = s.maxDepth(root);
//        System.out.println(d1);
    }


}
