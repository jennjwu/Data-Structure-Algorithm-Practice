class Main {
	public static void main(String[] args){
		Solution s = new Solution();
		int[] test1 = new int[]{5, 4, 3, 2, 1};
		
		for (String i: s.findRelativeRanks(test1)) {
			System.out.println(i);
		}
	}
}