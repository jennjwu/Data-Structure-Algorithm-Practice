import java.lang.Math;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

/**
 * Note that this implementation deems 0 to be a perfect square/cube.
 */
class Solution {
	static int getPerfectSquareOrCube(int val) {
		int perfectSquareOrPerfectCube = 0;
		
		if (val < 0) {
			printResult(val, perfectSquareOrPerfectCube);
			return perfectSquareOrPerfectCube;
		}

		List<String> valSplitIntoDigitStr = splitIntegerIntoDigitStr(val);

		Set<String> permutations = getPermutationsOfDigits(valSplitIntoDigitStr);
		permutations.add(String.join("", valSplitIntoDigitStr)); // add self

		for (String p : permutations) {
			int number = Integer.valueOf(p);
			if (isPerfectSquare(number) || isPerfectCube(number)) {
				perfectSquareOrPerfectCube++;
			}
		}

		printResult(val, perfectSquareOrPerfectCube);

		return perfectSquareOrPerfectCube;
	}

	static List<String> splitIntegerIntoDigitStr(int val) {
		List<String> integerAsStrList = new ArrayList<String>();
		if (val == 0) {
			integerAsStrList.add(String.valueOf(0));
		}

		while (val > 0) {
    		integerAsStrList.add( String.valueOf(val % 10) );
    		val /= 10;
		}

		return integerAsStrList;
	}


	static Set<String> getPermutationsOfDigits(List<String> digitsStrList) {
		Set<String> permutations = new HashSet<>();

		// base case
		if (digitsStrList.size() == 1) {
			permutations.add(digitsStrList.get(0));
			return permutations;
		}

		for (int i = 0; i < digitsStrList.size(); i++) {
			// input list for recursion should exclude first elem, to end
			List<String> recurDigitList = digitsStrList.subList(1, digitsStrList.size());
			
			// recur to get permutations for rest of
			Set<String> recurPermutations = getPermutationsOfDigits(recurDigitList);

			for (String perm : recurPermutations) {
				permutations.add(digitsStrList.get(i) + perm);
			}
			
			// swap location of first digit and current digit
			digitsStrList = swapDigits(digitsStrList, 0, i);
		}

		return permutations;
	}

	static List<String> swapDigits(List<String> digits, int idx1, int idx2) {
		String valueAtIdx1 = digits.get(idx1);
		digits.set(idx1, digits.get(idx2));
		digits.set(idx2, valueAtIdx1);
		
		return digits;
	}

	static boolean isPerfectSquare(int val) {
		if (val < 0) return false;

		long closestRoot = (long) Math.sqrt(val);
    	return val == closestRoot * closestRoot;
	}

	static boolean isPerfectCube(int val) {
		if (val < 0) return false;

		double cubeRoot = Math.cbrt(val);
    	long closestCubeRoot = Math.round(cubeRoot);
    	return val == (closestCubeRoot * closestCubeRoot * closestCubeRoot);
	}

	static void printListOfStr(List<String> inputList) {
		for (String s : inputList) {
			System.out.print(s + " ");
		}
		System.out.println("");
	}

	static void printResult(int val, int numPerfectSquareOrCube) {
		System.out.println("input=" + val + " has " + numPerfectSquareOrCube + " perfect squares or perfect cubes");
	}

	////////// RUNNER ///////////
	public static void main(String[] args) {
		getPerfectSquareOrCube(414);
		getPerfectSquareOrCube(1000);
		getPerfectSquareOrCube(64);
		getPerfectSquareOrCube(36);
		getPerfectSquareOrCube(71);
		getPerfectSquareOrCube(1);
		getPerfectSquareOrCube(0);
		getPerfectSquareOrCube(-1);
	}
}