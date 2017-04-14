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
import java.util.LinkedList;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // create a new root node -- copy of node passed in
        TreeNode newRoot = new TreeNode(root.val);
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        newRoot.left = invertTree(rightNode);
        newRoot.right = invertTree(leftNode);

        return newRoot;
    }

    // Preorder Traversal (L, root, R)
    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.val);
            inorderTraversal(node.right);
        }
    }

    public void printInorderTraversal(TreeNode root) {
        inorderTraversal(root);
    }

    // Preorder Traversal (root, L, R)
    private void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void printpreorderTraversal(TreeNode root) {
        preorderTraversal(root);
    }

    // Postorder Traversal (L, R, root)
    private void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.println(node.val);
        }
    }

    public void printpostorderTraversal(TreeNode root) {
        postorderTraversal(root);
    }

    public void breadthFirstTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        queue.clear();
        
        if (root != null) {
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                System.out.println(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}