class Main {
	public static void main(String[] args){
		Solution s = new Solution();
		int[] test1 = new int[]{3, 2, 4};
		int[] test2 = new int[]{2, 7, 11, 15};
		
		for (int i: s.twoSum(test1, 6)) {
			System.out.println(i);
		}

		for (int i: s.twoSum(test2, 18)) {
			System.out.println(i);
		}
	}
}