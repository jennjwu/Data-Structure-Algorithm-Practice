class Main {
	public static void main(String[] args){
		String valid1 = "()";
		String valid2 = "()[]{}";
		String invalid1 = "(]"; 
		String invalid2 = "([)]";

		Solution s = new Solution();
		System.out.println(s.isValid(valid1));
		System.out.println(s.isValid(valid2));
		System.out.println(s.isValid(invalid1));
		System.out.println(s.isValid(invalid2));
	}
}