package Leetcode.sametree;

/**
 * Created by jennjwu on 11/7/15.
 */

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

    public static TreeNode makeTree2() {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root1 = makeTree();
        TreeNode root2 = makeTree2();
        TreeNode root3 = makeTree();

        System.out.println(s.isSameTree(root1, root2));
        System.out.println(s.isSameTree(root1, root3));
        System.out.println(s.isSameTree(root2, root3));
    }


}
