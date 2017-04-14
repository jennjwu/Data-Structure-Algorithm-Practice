class Main {
	public static void main(String[] args) {
		int[][] row = new int[][]{
			{1,1,0},
			{0,0,1}
		};

		int[][] col = new int[][]{
			{1,0,0},
			{0,0,1},
			{1,0,0}
		};

		int[][] col2 = new int[][]{
			{1,0,0,0},
			{0,0,1,0},
			{0,0,0,0}
		};

		int[][] col3 = new int[][]{
			{1,0,0,0},
			{0,0,1,0},
			{0,1,0,0}
		};		

		int[][] diag = new int[][]{
			{1,0,0},
			{0,0,1}
		};

		int[][] diag2 = new int[][]{
			{1,0,0},
			{0,0,0},
			{0,0,1}
		};

		System.out.println(hasOnes(row));
		System.out.println(hasOnes(col));
		System.out.println(hasOnes(col2));
		System.out.println(hasOnes(col3));
		System.out.println(hasOnes(diag));
		System.out.println(hasOnes(diag2));
	}

	private static boolean hasOnes(int[][] input) {

		for (int row = 0; row < input.length; row++) {
			int onesInRow = 0;
			for (int col = 0; col < input[row].length; col++) {
				if (input[row][col] == 1) {
					onesInRow++;

					int r = row - 1;
					int c1 = col - 1; // diagonal col going to the left
					int c2 = col + 1; // diagonal col going to the right
					while (r >= 0) {
						// col case
						if (input[r][col] == 1) {
							return true;
						}

						// diagonal - up and left
						if (c1 >= 0 && input[r][c1] == 1) {
							return true;
						}

						// diagonal - up and right
						if (c2 < input[row].length && input[r][c2] == 1) {
							return true;
						}

						r--;
						c1--;
						c2++;
					}
				}
			}

			// row case
			if (onesInRow >= 2) {
				return true;
			}
		}
		return false;
	}
}