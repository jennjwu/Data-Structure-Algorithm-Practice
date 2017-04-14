class Main {
	public static void main(String[] args){
		Solution s = new Solution();

		int[] test1 = s.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
		System.out.println(test1.length);
		for (int i: test1) {
			System.out.print(" " + i + " ");
		}

		int[] test2 = s.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
		for (int i: test2) {
			System.out.print(" " + i + " ");
		}
	}
}