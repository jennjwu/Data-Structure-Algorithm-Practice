class Main {
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.findTheDifference("abcd", "abcde"));

		System.out.println(s.findTheDifference("abcd", "dcbya"));
		
		System.out.println(s.findTheDifference("abcd", "abxcd"));
	}
}