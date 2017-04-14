class Main {
	public static void main(String[] args){
		Solution s = new Solution();

		// should give gfedcba
		System.out.println(s.reverseStr("abcdefg", 20));

		// should give bacdfeg
		System.out.println(s.reverseStr("abcdefg", 2));

		// should give bacdfegh
		System.out.println(s.reverseStr("abcdefgh", 2));

		// should give cbadefg
		System.out.println(s.reverseStr("abcdefg", 3));

		// should give dcbaefghlkjim
		System.out.println(s.reverseStr("abcdefghijklm", 4));
	}
}