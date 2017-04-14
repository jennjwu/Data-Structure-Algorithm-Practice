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

		System.out.println(s.sumOfLeftLeaves(root));

		// build test binary tree
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(9);
		root2.right = new TreeNode(20);
		root2.right.left = new TreeNode(15);
		root2.right.right = new TreeNode(7);
		
		System.out.println(s.sumOfLeftLeaves(root2));
	}
}