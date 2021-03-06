class Main {
	public static void main(String[] args){
		// build test binary tree
		TreeNode root = new TreeNode(4);
		TreeNode firstLeft = new TreeNode(2);
		TreeNode firstRight = new TreeNode(7);
		TreeNode secondLeft = new TreeNode(1);
		TreeNode secondRight = new TreeNode(3);
		TreeNode secondLeft2 = new TreeNode(6);
		TreeNode secondRight2 = new TreeNode(9);
		TreeNode test = new TreeNode(11);
		TreeNode test2 = new TreeNode(16);

		// add first level
		root.left = firstLeft;
		root.right = firstRight;

		// add second level
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		firstRight.left = secondLeft2;
		firstRight.right = secondRight2;

		// add some test cases
		secondLeft.left = test;
		secondRight2.right = test2;

		Solution s = new Solution();

		System.out.println("inorder");
		s.printInorderTraversal(root);

		// System.out.println("reverse BFS");
		// s.printlevelOrderBottom(root);

		System.out.println("reverse BFS by level");
		System.out.println(s.levelOrderBottom(root));
	}
}