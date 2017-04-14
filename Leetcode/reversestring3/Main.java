class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("#" + s.reverseWords("Let's take LeetCode contest") + "#");
		System.out.println("#" + s.reverseWords(" Let's take LeetCode contest ") + "#");
		System.out.println("#" + s.reverseWords("  Let's take LeetCode contest") + "#");
		System.out.println("#" + s.reverseWords("Let's  take  LeetCode   contest") + "#");
	}
}