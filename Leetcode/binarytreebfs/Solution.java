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
    // At each level, visit the nodes and add each node's L then R to queue
    // In next round, visit each node in the queue and add their L & R until there are no more nodes
    // NOTE: Add the result of each level to the HEAD of the result list, so that the levels are reversed
    // Use a queue (FIFO) to hold the BFS order
    // Use a list to hold the node values per level
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.clear();

            q.add(root);
            while (q.size() > 0) {
                List<Integer> levelNodes = new ArrayList<>();
                System.out.println("queue size = " + q.size());
                int size = q.size();
                // for each node at this level
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    System.out.println("node = " + node.val);
                    
                    levelNodes.add(node.val);
                    if(node.left != null) {
                        q.add(node.left);
                    }
                    if(node.right!=null) {
                        q.add(node.right);
                    }
                }
                // add new levelNodes array to beginning of result list (at index 0)
                result.add(0, levelNodes);

                System.out.println("list = " + levelNodes);
                System.out.println("result = " + result);
            }
        }

        return result;
    }

    public void printlevelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        queue.clear();
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        if (root != null) {
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                
                // instead of adding Left child first, add the Right child first since the stack will reverse them
                if(node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                s.add(node);
            }
        }
        
        // print all nodes on the stack (which reverse the inorder BFS)
        while (s.isEmpty() == false) {
            System.out.println(s.pop().val);
        }
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
}