class Main {
	public static void main(String[] args){
		Solution s = new Solution();

		System.out.println(s.canConstruct("a", "b"));
		System.out.println(s.canConstruct("aa", "ab"));
		System.out.println(s.canConstruct("aa", "aab"));
		System.out.println(s.canConstruct("abca", "abcd"));
	}
}