import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> combos = new ArrayList<>();
		ArrayList<String> combo1 = new ArrayList<>();
		combo1.add("a");
		combo1.add("b");
		combo1.add("c");
		combos.add(combo1);

		ArrayList<String> combo2 = new ArrayList<>();
		combo2.add("x");
		combo2.add("y");
		combo2.add("z");
		combos.add(combo2);

		ArrayList<String> combo3 = new ArrayList<>();
		combo3.add("0");
		combo3.add("1");
		combos.add(combo3);

		// ArrayList<String> combo4 = new ArrayList<>();
		// combo4.add("q");
		// combo4.add("r");
		// combo4.add("s");
		// combo4.add("t");
		// combos.add(combo4);

		ArrayList<String> result = allValidCombos(combos);
		System.out.println(result.size());
		System.out.println(result);
	}

	private static ArrayList<String> allValidCombos(ArrayList<ArrayList<String>> input) {
		ArrayList<String> tmpCombos = new ArrayList<>();
		for (int row = 0; row < input.size(); row++) {
			ArrayList<String> innerCombo = new ArrayList<>();
			for (int col = 0; col < input.get(row).size(); col++) {
				if (row > 0) {
					for (String s: tmpCombos) {
						innerCombo.add(s + input.get(row).get(col));
					}
				} else {
					tmpCombos.add(input.get(row).get(col));	
				}
			}
			if (row > 0 ) {
				tmpCombos = innerCombo;
			}
		}
		
		return tmpCombos;
	}
}