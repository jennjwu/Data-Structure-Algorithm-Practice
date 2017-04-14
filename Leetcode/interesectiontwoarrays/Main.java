class Main {
	public static void main(String[] args){
		Solution s = new Solution();

		int[] result1 = s.intersection(new int[]{1,2,2,1}, new int[]{2,2});
		for (int i : result1) {
			System.out.print(" " + i + " ");	
		}

		System.out.println("--");
		
		int[] result2 = s.intersection(new int[]{1,4,5,1,6}, new int[]{6,5,4});
		for (int j: result2) {
			System.out.print(" " + j + " ");
		}
	}
}